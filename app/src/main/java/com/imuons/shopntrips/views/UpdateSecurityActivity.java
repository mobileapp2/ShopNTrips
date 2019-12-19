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

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateSecurityActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mEditOldPassword, mEditNewPassword, mEditConfirmPassword;
    private Button mButtonUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_security);
        ButterKnife.bind(this);
        registerListeners();
        initializeViews();
    }

    private void initializeViews() {
        mEditOldPassword = findViewById(R.id.edit_old_password);
        mEditNewPassword = findViewById(R.id.edit_new_password);
        mEditConfirmPassword = findViewById(R.id.edit_re_type_passsword);
        mButtonUpdate = findViewById(R.id.button_update);
    }

    private void registerListeners() {
        mButtonUpdate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (validateOldPassword() && validateNewPassword() && validateConfirmPassword()) {
            changePassword();
        }
    }

    private void changePassword() {
        Map<String, String> passwordmap = new HashMap<>();
        final String oldpass, newpass, compass;


        oldpass = mEditOldPassword.getText().toString().trim();
        newpass = mEditNewPassword.getText().toString().trim();
        compass = mEditConfirmPassword.getText().toString().trim();


        passwordmap.put("password_confirmation", compass);
        passwordmap.put("new_password", newpass);
        passwordmap.put("current_pwd", oldpass);


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

                        mEditOldPassword.setText("");
                        mEditNewPassword.setText("");
                        mEditConfirmPassword.setText("");
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

    private boolean validateConfirmPassword() {
        String password = mEditNewPassword.getText().toString().trim();
        String confirmPassword = mEditConfirmPassword.getText().toString().trim();
        if (!confirmPassword.equals(password)) {
            Toast.makeText(UpdateSecurityActivity.this, getString(R.string.invalid_confirm_password_message), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean validateNewPassword() {
        String password = mEditNewPassword.getText().toString().trim();
        if (password.isEmpty()) {
            Toast.makeText(UpdateSecurityActivity.this, getString(R.string.invalid_new_password_message), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean validateOldPassword() {
        String oldPassword = mEditOldPassword.getText().toString().trim();
        if (oldPassword.isEmpty()) {
            Toast.makeText(UpdateSecurityActivity.this, getString(R.string.empty_password), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }


}
