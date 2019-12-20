package com.imuons.shopntrips.views;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.imuons.shopntrips.R;
import com.imuons.shopntrips.model.GetCityResponseModel;
import com.imuons.shopntrips.model.UpdateProfileResponseModel;
import com.imuons.shopntrips.retrofit.ApiHandler;
import com.imuons.shopntrips.retrofit.ShopNTrips;
import com.imuons.shopntrips.utils.Constants;
import com.imuons.shopntrips.utils.SharedPreferenceUtils;
import com.imuons.shopntrips.utils.ViewUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactInfoActivity extends AppCompatActivity {

    @BindView(R.id.btn_Update)
    Button mbtnSubmit;


    @BindView(R.id.txt_postalAddress)
    EditText mTextpostalAddress;

    @BindView(R.id.txt_pincode)
    EditText mTextPincode;
    @BindView(R.id.txt_state)
    EditText mSpinnerState;

    String strstate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);
        ButterKnife.bind(this);
        mbtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateProfile();
            }
        });
        mSpinnerState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getcitybystate(strstate);
            }
        });
    }

    private void getcitybystate(String strstate) {
        final ProgressDialog pd = ViewUtils.getProgressBar(ContactInfoActivity.this, "Loading...", "Please wait..!");

        Map<String, String> loginMap = new HashMap<>();
        loginMap.put("state", strstate);

        ShopNTrips apiService = ApiHandler.getApiService();
        final Call<GetCityResponseModel> loginCall = apiService.wsGetCityByState(loginMap);

        loginCall.enqueue(new Callback<GetCityResponseModel>() {
            @SuppressLint("WrongConstant")
            @Override
            public void onResponse(Call<GetCityResponseModel> call,
                                   Response<GetCityResponseModel> response) {
                pd.hide();
                if (response.isSuccessful()) {
                    GetCityResponseModel getCityResponseModel = response.body();
                    if (getCityResponseModel.getCode() == Constants.RESPONSE_CODE_OK &&
                            getCityResponseModel.getStatus().equals("OK")) {
                      //  citylist.addAll(getCityResponseModel.getData());
                    //    listCityName.clear();
                      //  getcitybyname(getCityResponseModel.getData());
                    } else {
                        Toast.makeText(ContactInfoActivity.this, getCityResponseModel.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<GetCityResponseModel> call,
                                  Throwable t) {
                pd.hide();
                Toast.makeText(ContactInfoActivity.this, getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void UpdateProfile() {
        final ProgressDialog pd = ViewUtils.getProgressBar(ContactInfoActivity.this, "Loading...", "Please wait..!");
        String postaladdress = mTextpostalAddress.getText().toString();
        String pincode = mTextPincode.getText().toString();


        Map<String, String> roiMap = new HashMap<>();
        roiMap.put("address", postaladdress);
        roiMap.put("pincode", pincode);


        ShopNTrips apiService = ApiHandler.getApiService();

        final Call<UpdateProfileResponseModel> loginCall = apiService.wsUpdateProfile("Bearer "
                + SharedPreferenceUtils.getLoginObject(
                ContactInfoActivity.this).getData().getAccess_token(), roiMap);

        loginCall.enqueue(new Callback<UpdateProfileResponseModel>() {
            @SuppressLint("WrongConstant")
            @Override
            public void onResponse(Call<UpdateProfileResponseModel> call,
                                   Response<UpdateProfileResponseModel> response) {
                pd.hide();
                if (response.isSuccessful()) {
                    UpdateProfileResponseModel profileResponseModel = response.body();
                    if (profileResponseModel.getCode() == Constants.RESPONSE_CODE_OK &&
                            profileResponseModel.getStatus().equals("OK")) {
                        Toast.makeText(ContactInfoActivity.this, "Information Updated", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ContactInfoActivity.this, DashboardActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(ContactInfoActivity.this, profileResponseModel.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<UpdateProfileResponseModel> call,
                                  Throwable t) {
                pd.hide();
                Toast.makeText(ContactInfoActivity.this, getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
