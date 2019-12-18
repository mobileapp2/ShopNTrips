package com.imuons.shopntrips.retrofit;

import com.imuons.shopntrips.model.CheckUserExistResponseModel;
import com.imuons.shopntrips.model.DashboardResponseModel;
import com.imuons.shopntrips.model.GetCityResponseModel;
import com.imuons.shopntrips.model.GetStateResponseModel;
import com.imuons.shopntrips.model.LoginResponseModel;
import com.imuons.shopntrips.model.RegisterResponseModel;
import com.imuons.shopntrips.model.ResetPasswordResponseModel;
import com.imuons.shopntrips.model.WithdrawHistoryReportResponseModel;
import com.imuons.shopntrips.model.WithdrawRequestReportResponseModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ShopNTrips {


    @FormUrlEncoded
    @POST("login")
    Call<LoginResponseModel> wsLogin(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("forgot-password")
    Call<ResetPasswordResponseModel> wsResetPassword(@Field("user_id") String user_id);

    @FormUrlEncoded
    @POST("checkuserexist")
    Call<CheckUserExistResponseModel> wsCheckUser(@FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("register")
    Call<RegisterResponseModel> wsRegister(@FieldMap Map<String, String> map);

   @GET("userDashboard")
   Call<DashboardResponseModel> wsGetDashboardData(@Header("Authorization") String authHeader);


    @FormUrlEncoded
    @POST("getStateByCountry")
    Call<GetStateResponseModel> wsGetStateByCountry(@FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("getCityByState")
    Call<GetCityResponseModel> wsGetCityByState(@FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("withdraw-amount-report")
    Call<WithdrawRequestReportResponseModel> wsWithdrawalRequestReport(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("withdraw-report")
    Call<WithdrawHistoryReportResponseModel> wsWithdrawalHistoryReport(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

  /*






    @GET("country")
    Call<GetCountryResponseModel> wsGetCountry();
    @FormUrlEncoded

    @FormUrlEncoded
    @POST("checkPinValid")
    Call<CheckPinValidResponseModel> wsCheckPinValid(@FieldMap Map<String, String> loginMap);
    @FormUrlEncoded
    @POST("checkPanValid")
    Call<CheckPanValidResponseModel> wsCheckPanValid(@FieldMap Map<String, String> loginMap);



    @FormUrlEncoded
    @POST("user/change-password")
    Call<ChangePasswordResponseModel> wsChangePassword(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);
    @FormUrlEncoded
    @POST("user/transfer_pins")
    Call<TransferPinResponseModel> wsTransferPins(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("user/get_transfer_pin_report")
    Call<TransferPinReportResponseModel> wsTransferEpinReport(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("user/getTransferPinDetailReport")
    Call<TransferPinDetailDataModel> wsGetTransferPins(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("user/get_received_pin_report")
    Call<RecivedPinHistoryResponseModel> wsGetReceivedEpin(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("user/userexist")
    Call<UserExistResponseModel> wsCheckUserexist(@FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("user/roi-income")
    Call<CashbackIncomeReportResponseModel> wsROIIncomeReport(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("user/level-view")
    Call<LevelViewResponseModel> wsLevelViewReport(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("user/all-epins")
    Call<PinReportResponseModel> wsPinReport(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("user/get_pin_requests")
    Call<PinRequestReportResponseModel> wsPinrequestReportReport(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("user/get_pin_requests_byid")
    Call<PinRequestAmountDepositeResponseModel> wsPinrequestAmtDepositeReport(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("user/get-user-order-items")
    Call<PinRequestDetailResponseModel> wsPinRequestDetail(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("user/send-registration-otp")
    Call<SendRegistrationOtpResponseModel> wsSendOTP(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @GET("user/profile")
    Call<UserProfileResponseModel> wsUserProfileInfo(@Header("Authorization") String authHeader);

    @GET("user/get_products_for_pin_transfer")
    Call<GetProductsPinTransferResponseModel> wsGetProductsForPinTransfer(@Header("Authorization") String authHeader);

    @FormUrlEncoded
    @POST("user/getproducts")
    Call<ActivePinProductResponseModel> wsActivePinGetProduct(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("user/epin-details-unused")
    Call<ActivePinRequestResponseModel> wsActivePinReport(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @GET("user/get_products_for_pin_request")
    Call<ProductsForPinRequestResponseModel> wsGetProductForPinRequest(@Header("Authorization") String authHeader);

    @FormUrlEncoded
    @POST("user/add_to_cart")
    Call<AddToCartResponseModel> wsAddToCart(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @GET("user/get_user_cart_items")
    Call<UserCartResponseModel> wsGetUserCart(@Header("Authorization") String authHeader);

    @GET("user/dashboard")
    Call<DashboardResponseModel> wsGetDashboardData(@Header("Authorization") String authHeader);

    @GET("user/checkRegistrationPackage")
    Call<CheckRegistrationResponseModel> wsGetregistrationData(@Header("Authorization") String authHeader);

    @FormUrlEncoded
    @POST("user/verify-registration-otp")
    Call<VerifyotpResponseModel> wsVerifyOTP(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("user/update-bank-detail")
    Call<UpdateUserProfileResponseModel> wsUpdateUserProfile(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("user/remove_items_from_cart")
    Call<RemoveProductResponseModel> wsRemoveProduct(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);


    @GET("user/directOfDirectList")
    Call<DirectOfUserModel> wsDirectOfDirect(@Header("Authorization") String authHeader);

    @Multipart
    @POST("user/send_multiple_pin_request")
    Call<SendMultiplePinResponseModel> wsSendPinRequest(@Header("Authorization") String authHeader, @PartMap() Map<String, okhttp3.RequestBody> partMap,
                                                        @Part MultipartBody.Part file);
*/
}
