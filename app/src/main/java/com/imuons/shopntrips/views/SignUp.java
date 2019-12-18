package com.imuons.shopntrips.views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.imuons.shopntrips.R;
import com.imuons.shopntrips.retrofit.ApiHandler;
import com.imuons.shopntrips.retrofit.ShopNTrips;
import com.imuons.shopntrips.utils.Constants;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {
    @BindView(R.id.next)
    Button next;
    @BindView(R.id.edit_name)
    EditText edit_name;
    @BindView(R.id.edit_mobile)
    EditText edit_mobile;
    @BindView(R.id.edit_email)
    EditText edit_email;
    @BindView(R.id.edit_state)
    EditText edit_state;
    @BindView(R.id.edit_city)
    EditText edit_city;
    @BindView(R.id.edit_address)
        EditText edit_address;
    @BindView(R.id.edit_pincode)
    EditText edit_pincode;
    @BindView(R.id.submit)
    Button submit;
    @BindView(R.id.login)
    TextView login;
    @BindView(R.id.checkterm)
    CheckBox checkterm;

    String  selectedradio,sponsorname,sponsorid,userid,password,cpassword,email,mobile,fullName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        selectedradio = getIntent().getStringExtra("selectedradio");
        sponsorname = getIntent().getStringExtra("sponsorname");
        sponsorid = getIntent().getStringExtra("sponsorid");
        userid = getIntent().getStringExtra("userid");
        password = getIntent().getStringExtra("password");
        cpassword = getIntent().getStringExtra("cpassword");


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateEmail() && validateMobileNo() && validateFullName()) {


                   //register();
                }

            }
        });
    }

//    private void register() {
//        Map<String, String> registerMap = new HashMap<>();
//        //loginMap.put("confirm_password", cpassword);
//        registerMap.put("email", email);
//        registerMap.put("fullname", fullName);
//        registerMap.put("mobile", mobile);
//        // loginMap.put("password", password);
//        registerMap.put("ref_user_id", sponsorid);
//        registerMap.put("sponsor_name", sponsorname);
//        registerMap.put("user_id", userid);
//        registerMap.put("position", selectedradio);
//        registerMap.put("branch_name",branchName);
//        registerMap.put("bank_name",nameofbank);
//        registerMap.put("account_no",accountNo);
//        registerMap.put("ifsc_code",ifsc);
//        registerMap.put("pan_no",pancardNo);
//
//
//        ShopNTrips apiService = ApiHandler.getApiService();
//        final Call<RegisterResponseModel> registerCall = apiService.wsRegister(registerMap);
//        registerCall.enqueue(new Callback<RegisterResponseModel>() {
//            @SuppressLint("WrongConstant")
//            @Override
//            public void onResponse(Call<RegisterResponseModel> call,
//                                   Response<RegisterResponseModel> response) {
//
//                if (response.isSuccessful()) {
//                    RegisterResponseModel registerResponseModel = response.body();
//                    if (registerResponseModel.getCode() == Constants.RESPONSE_CODE_OK &&
//                            registerResponseModel.getStatus().equals("OK")) {
//                        String useridtosend = registerResponseModel.getRegisterDataModel().getUserId();
//                        String userpassword = registerResponseModel.getRegisterDataModel().getPassword();
//                        Intent showpassword = new  Intent (SignUp.this,ShowPassword.class);
//                        showpassword.putExtra("userid", useridtosend);
//                        showpassword.putExtra("password", userpassword);
//                        startActivity(showpassword);
//
//
//                    } else {
//                        Toast.makeText(SignUp.this, registerResponseModel.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                }else{
//                    Toast.makeText(SignUp.this, "Check username or password", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<RegisterResponseModel> call,
//                                  Throwable t) {
//
//                Toast.makeText(SignUp.this, getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }

    private boolean validateEmail() {
        email = edit_email.getText().toString().trim();
        if (email.isEmpty() || !email.matches(Constants.EMAIL_REGEX)) {
            Toast.makeText(SignUp.this,
                    getString(R.string.invalid_email_message), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {

    }

    private boolean validateMobileNo() {
        mobile = edit_mobile.getText().toString().trim();
        if (mobile.isEmpty() || mobile.length() < 10) {
            Toast.makeText(SignUp.this,
                    getString(R.string.invalid_mobile_number_message), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean validateFullName() {
        fullName =  edit_name.getText().toString().trim();
        if (fullName.isEmpty()) {
            Toast.makeText(SignUp.this,
                    getString(R.string.invalid_full_name_message), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
