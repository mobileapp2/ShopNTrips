package com.imuons.shopntrips.views;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.imuons.shopntrips.R;
import com.imuons.shopntrips.model.UserPhotosDataModel;
import com.imuons.shopntrips.model.UserPhotosResponseModel;
import com.imuons.shopntrips.model.UserProfileResponseModel;
import com.imuons.shopntrips.retrofit.ApiHandler;
import com.imuons.shopntrips.retrofit.ShopNTrips;
import com.imuons.shopntrips.utils.Constants;
import com.imuons.shopntrips.utils.SharedPreferenceUtils;
import com.imuons.shopntrips.utils.ViewUtils;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileInfoActivity extends AppCompatActivity {

    private UserProfileResponseModel model;

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


    @BindView(R.id.text_user_name)
    TextView mTextUserName;
    @BindView(R.id.txt_DateOfJoining)
    TextView mTextDateOfJoining;
    @BindView(R.id.text_email_id)
    TextView mTextEmailIds;
    @BindView(R.id.text_mobile_number)
    TextView mTextMobileNumber;
    @BindView(R.id.image_profile)
    ImageView mImageUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_info);
        ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.profile);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        Gson gS = new Gson();
        String target = getIntent().getStringExtra("object");
        model = gS.fromJson(target, UserProfileResponseModel.class);
        if (model != null && model.getData().getUserId() != null) {
            displayData(model);
        } else {
            Toast.makeText(ProfileInfoActivity.this, "No Data found!", Toast.LENGTH_SHORT).show();
        }
        getUserPhotos();
    }

    private void getUserPhotos() {
        final ProgressDialog pd = ViewUtils.getProgressBar(ProfileInfoActivity.this, "Loading...", "Please wait..!");

        ShopNTrips apiService = ApiHandler.getApiService();
        final Call<UserPhotosResponseModel> loginCall = apiService.wsUserPhotos(
                "Bearer " + SharedPreferenceUtils.getLoginObject(
                        ProfileInfoActivity.this).getData().getAccess_token());
        loginCall.enqueue(new Callback<UserPhotosResponseModel>() {
            @SuppressLint("WrongConstant")
            @Override
            public void onResponse(Call<UserPhotosResponseModel> call,
                                   Response<UserPhotosResponseModel> response) {
                pd.hide();
                if (response.isSuccessful()) {
                    UserPhotosResponseModel loginModel = response.body();
                    if (loginModel.getCode() == Constants.RESPONSE_CODE_OK &&
                            loginModel.getStatus().equals("OK")) {
                        setUserDataPhoto(loginModel.getData());
                    } else {
                        Toast.makeText(ProfileInfoActivity.this, loginModel.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<UserPhotosResponseModel> call,
                                  Throwable t) {
                pd.hide();
                Toast.makeText(ProfileInfoActivity.this, getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setUserDataPhoto(UserPhotosDataModel data) {
        if (data.getPhoto() != null) {
            Picasso.get().load(String.valueOf(data.getPhoto())).into(mImageUser);
        }
    }

    private void displayData(UserProfileResponseModel data) {
        mTextName.setText(data.getData().getFullname());
        mTextEmail.setText(data.getData().getEmail());
        mTextMobileNumbers.setText(data.getData().getMobile());
        mTextSponsorID.setText(data.getData().getSponserId());
        mTextUserID.setText(data.getData().getUserId());
        mTextUserName.setText(data.getData().getFullname());
        mTextEmailIds.setText(data.getData().getEmail());
        mTextMobileNumber.setText(data.getData().getMobile());
        mTextDateOfJoining.setText(data.getData().getEntryTime());
    }

}
