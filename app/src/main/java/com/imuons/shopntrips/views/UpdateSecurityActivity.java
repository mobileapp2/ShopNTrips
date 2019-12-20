package com.imuons.shopntrips.views;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.imuons.shopntrips.R;
import com.imuons.shopntrips.model.ChangePasswordResponseModel;
import com.imuons.shopntrips.retrofit.ApiHandler;
import com.imuons.shopntrips.retrofit.ShopNTrips;
import com.imuons.shopntrips.utils.Constants;
import com.imuons.shopntrips.utils.SharedPreferenceUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateSecurityActivity extends AppCompatActivity  {


    @BindView(R.id.old_pass)
    EditText old_pass;
    @BindView(R.id.new_trs_pass)
    EditText new_trs_pass;
    @BindView(R.id.retype_pass)
    EditText retype_pass;
    @BindView(R.id.updatetrans)
    Button updatetrans;
    String oldpass,newtranspass,retypepass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_security);
        ButterKnife.bind(this);

        updatetrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePassword();
                if(validatePassword() && validateConfirmPassword() && comfirmPassword() && newpassword()){

                }
            }
        });
    }



    private void changePassword() {
        Map<String, String> passwordmap = new HashMap<>();
        final String oldpass, newpass, compass;


        oldpass= old_pass.getText().toString().trim();
        newpass =new_trs_pass.getText().toString().trim();
        compass = retype_pass.getText().toString().trim();


        passwordmap.put("old_password", compass);
        passwordmap.put("new_password", newpass);
        passwordmap.put("retype_password", oldpass);


        ShopNTrips apiService = ApiHandler.getApiService();
        final Call<ChangePasswordResponseModel> loginCall = apiService.wsChangePassword("Bearer " + SharedPreferenceUtils.getAccesstoken(UpdateSecurityActivity.this), passwordmap);
        loginCall.enqueue(new Callback<ChangePasswordResponseModel>() {
            @SuppressLint("WrongConstant")
            @Override
            public void onResponse(Call<ChangePasswordResponseModel> call,
                                   Response<ChangePasswordResponseModel> response) {
                if (response.isSuccessful()) {
                    ChangePasswordResponseModel changePasswordResponseModel = response.body();
                    if (changePasswordResponseModel.getCode() == Constants.RESPONSE_CODE_OK &&
                            changePasswordResponseModel.getStatus().equals("OK")) {

                        Toast.makeText(UpdateSecurityActivity.this, changePasswordResponseModel.getMessage(), Toast.LENGTH_SHORT).show();

                        old_pass.setText("");
                        new_trs_pass.setText("");
                        retype_pass.setText("");
                    } else {
                        Toast.makeText(UpdateSecurityActivity.this, changePasswordResponseModel.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(UpdateSecurityActivity.this, "Check username or password", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<ChangePasswordResponseModel> call,
                                  Throwable t) {


                Toast.makeText(UpdateSecurityActivity.this, getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean newpassword() {
        newtranspass  = new_trs_pass.getText().toString().trim();
        if (newtranspass.isEmpty() && new_trs_pass.length() < 8) {
            Toast.makeText(UpdateSecurityActivity.this, "Empty or invalid new password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean validatePassword() {
        oldpass  = old_pass.getText().toString().trim();
        if (oldpass.isEmpty() && old_pass.length() < 8) {
            Toast.makeText(UpdateSecurityActivity.this, "Empty or invalid old password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private boolean validateConfirmPassword() {
        newtranspass = new_trs_pass.getText().toString().trim();
        retypepass = retype_pass.getText().toString().trim();
        if (!newtranspass.equals(retypepass)) {
            Toast.makeText(UpdateSecurityActivity.this, "Empty or not matching  new or retype password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean comfirmPassword() {
        retypepass = retype_pass.getText().toString().trim();
        if (retypepass.isEmpty() || retype_pass.length() < 8) {
            Toast.makeText(UpdateSecurityActivity.this, "Empty or invalid retype new password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
