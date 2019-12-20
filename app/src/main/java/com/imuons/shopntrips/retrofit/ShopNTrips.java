package com.imuons.shopntrips.retrofit;

import com.imuons.shopntrips.model.BinaryIncomeReportResponseModel;
import com.imuons.shopntrips.model.BinaryRoiReportResponseModel;
import com.imuons.shopntrips.model.ChangePasswordResponseModel;
import com.imuons.shopntrips.model.CheckDownlineUserResponseModel;
import com.imuons.shopntrips.model.CheckUserExistResponseModel;
import com.imuons.shopntrips.model.DashboardResponseModel;
import com.imuons.shopntrips.model.DepartmentResponseModel;
import com.imuons.shopntrips.model.DirectRoiReportResponseModel;
import com.imuons.shopntrips.model.DownlineTopUpReportResponseModel;
import com.imuons.shopntrips.model.FundRequestReportResponseModel;
import com.imuons.shopntrips.model.FundTransferReportResponseModel;
import com.imuons.shopntrips.model.GetBalanceReponseModel;
import com.imuons.shopntrips.model.GetCityResponseModel;
import com.imuons.shopntrips.model.GetProductResponseModel;
import com.imuons.shopntrips.model.GetStateResponseModel;
import com.imuons.shopntrips.model.LoginResponseModel;
import com.imuons.shopntrips.model.RegisterResponseModel;
import com.imuons.shopntrips.model.ResetPasswordResponseModel;
import com.imuons.shopntrips.model.ResponseModel;
import com.imuons.shopntrips.model.RoiIncomeReportResponseModel;
import com.imuons.shopntrips.model.TicketResponseModel;
import com.imuons.shopntrips.model.TopUpReportResponseModel;
import com.imuons.shopntrips.model.UserPhotosResponseModel;
import com.imuons.shopntrips.model.UserProfileResponseModel;
import com.imuons.shopntrips.model.WithdrawHistoryReportResponseModel;
import com.imuons.shopntrips.model.WithdrawRequestReportResponseModel;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

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

    @FormUrlEncoded
    @POST("PayoutNoWiseHistoryReport")
    Call<BinaryIncomeReportResponseModel> wsBinaryIncomeReport(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("dailyroi")
    Call<RoiIncomeReportResponseModel> wsROIIncomeReport(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("binaryroi")
    Call<BinaryRoiReportResponseModel> wsBinaryROIReport(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("direct_roi_income")
    Call<DirectRoiReportResponseModel> wsBDirectROIReport(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("withdraw-amount-report")
    Call<WithdrawRequestReportResponseModel> wsWithdrawRequest(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("withdraw-report")
    Call<WithdrawHistoryReportResponseModel> wsWithdrawHistory(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("repurchaseProductReport")
    Call<TopUpReportResponseModel> wsTopupReport(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("downlinerepurchaseProductReport")
    Call<DownlineTopUpReportResponseModel> wsDownlineTopupReport(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("fund-request-report")
    Call<FundRequestReportResponseModel> wsFundRequestReport(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("fund-transfer-report")
    Call<FundTransferReportResponseModel> wsFundTransferReport(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @GET("get_departements")
    Call<DepartmentResponseModel> wsGetDepartments(@Header("Authorization") String authHeader);

    @Multipart
    @POST("insert_ticket")
    Call<TicketResponseModel> wsSendQuery(@Header("Authorization") String authHeader, @PartMap() Map<String, RequestBody> partMap,
                                          @Part MultipartBody.Part file);
    @GET("user-profile")
    Call<UserProfileResponseModel> wsUserProfileInfo(@Header("Authorization") String authHeader);

    @GET("user-photos")
    Call<UserPhotosResponseModel> wsUserPhotos(@Header("Authorization") String authHeader);

    @FormUrlEncoded
    @POST("change_password")
    Call<ChangePasswordResponseModel> wsChangePassword(@Header("Authorization") String authHeader, @FieldMap Map<String, String> loginMap);

    @FormUrlEncoded
    @POST("checkdownlineuser")
    Call<CheckDownlineUserResponseModel> wsCheckDownlineUser(@Field("user_id") String user_id);

        @GET("getproducts")
    Call<GetProductResponseModel> wsGetProducts(@Header("Authorization") String authHeader);

    @FormUrlEncoded
    @POST("getbalance")
    Call<GetBalanceReponseModel> wsTopUpBalance(@Header("Authorization") String authHeader,  @FieldMap Map<String, String> loginMap);

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
