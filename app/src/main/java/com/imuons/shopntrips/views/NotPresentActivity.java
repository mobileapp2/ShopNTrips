package com.imuons.shopntrips.views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.imuons.shopntrips.R;
import com.imuons.shopntrips.fragments.ProfileFragment;
import com.imuons.shopntrips.model.UserProfileDataModel;
import com.imuons.shopntrips.model.UserProfileResponseModel;
import com.imuons.shopntrips.model.UserTopUpResponse;
import com.imuons.shopntrips.retrofit.ApiHandler;
import com.imuons.shopntrips.retrofit.ShopNTrips;
import com.imuons.shopntrips.utils.Constants;
import com.imuons.shopntrips.utils.SharedPreferenceUtils;
import com.imuons.shopntrips.utils.ViewUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotPresentActivity extends AppCompatActivity {
    private UserProfileResponseModel profileModel;
    private UserTopUpResponse profileModel2;
    @BindView(R.id.text_user_name)
    TextView mTextUserName;
    @BindView(R.id.text_email_id)
    TextView mTextEmailId;
    @BindView(R.id.text_mobile_number)
    TextView mTextMobileNumber;
    @BindView(R.id.image_profile)
    ImageView mImageUser;

    @BindView(R.id.txt_userId)
    TextView mTextUserID;

    @BindView(R.id.txt_mobileNo)
    TextView mTextMobileNumbers;

    @BindView(R.id.txt_sponsorId)
    TextView mTextSponsorID;

    @BindView(R.id.txt_Email)
    TextView mTextEmail;

    @BindView(R.id.txt_name)
    TextView mTextName;


    @BindView(R.id.btn_Information)
    Button mBtnInformation;
    @BindView(R.id.btn_Security)
    Button mBtnSecurity;

    @BindView(R.id.btn_ContactInfo)
    Button mBtnContactInfo;
    @BindView(R.id.btn_BankDetails)
    Button mBtnBankDetails;
    @BindView(R.id.btn_About)
    Button mBtnAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_present);
        ButterKnife.bind(this);
        getUserProfileInfo();
    }

    private void getUserProfileInfo() {
        final ProgressDialog pd = ViewUtils.getProgressBar(NotPresentActivity.this,
                "Loading...", "Please wait..!");

        ShopNTrips apiService = ApiHandler.getApiService();
        final Call<UserProfileResponseModel> loginCall = apiService.wsUserProfileInfo(
                "Bearer " + SharedPreferenceUtils.getLoginObject(
                        NotPresentActivity.this).getData().getAccess_token());
        loginCall.enqueue(new Callback<UserProfileResponseModel>() {
            @SuppressLint("WrongConstant")
            @Override
            public void onResponse(Call<UserProfileResponseModel> call,
                                   Response<UserProfileResponseModel> response) {
                pd.hide();
                if (response.isSuccessful()) {
                    profileModel = response.body();
                    if (profileModel.getCode() == Constants.RESPONSE_CODE_OK &&
                            profileModel.getStatus().equals("OK")) {
                        setUserData(profileModel.getData());
                    } else {
                        Toast.makeText(NotPresentActivity.this, profileModel.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<UserProfileResponseModel> call,
                                  Throwable t) {
                pd.hide();
                Toast.makeText(NotPresentActivity.this, getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setUserData(UserProfileDataModel data) {
        mTextUserName.setText(data.getFullname());
        mTextEmailId.setText(data.getEmail());
        mTextMobileNumber.setText(data.getMobile());

        mTextName.setText(data.getFullname());
        mTextEmail.setText(data.getEmail());
        mTextMobileNumbers.setText(data.getMobile());
        mTextSponsorID.setText(data.getSponserId());
        mTextUserID.setText(data.getUserId());
    }

}
