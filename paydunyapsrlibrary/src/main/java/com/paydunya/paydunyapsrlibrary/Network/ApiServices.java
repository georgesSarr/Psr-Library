package com.paydunya.paydunyapsrlibrary.Network;


import com.paydunya.paydunyapsrlibrary.Constants.EndPointsConstants;
import com.paydunya.paydunyapsrlibrary.Network.Entities.CheckoutInvoiceModel;
import com.paydunya.paydunyapsrlibrary.Network.Entities.InvoiceModel;
import com.paydunya.paydunyapsrlibrary.Network.Entities.Parameters;
import com.paydunya.paydunyapsrlibrary.Network.Entities.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ApiServices {

    /*Start common api service
     *register
     * login
     * signUp
     * logout
     * user
     */


    @POST("create")
    Call<CheckoutInvoiceModel> initCheckoutInvoice(@Header("PAYDUNYA-MASTER-KEY") String masterKey,
                                                   @Header("PAYDUNYA-PRIVATE-KEY") String privateKey,
                                                   @Header("PAYDUNYA-TOKEN") String token,
                                                   @Body() Parameters parameters);

    @POST(EndPointsConstants.ORANGE_MONEY_PARAMETER)
    @FormUrlEncoded
    Call<ResponseModel<Object>> OMSPayment(@Field("phone_number") String phone,
                                           @Field("authorization_code") String authorizationCode,
                                           @Field("invoice_token") String invoiceToken);

    @POST(EndPointsConstants.WIZALL_MONEY_INIT_PARAMETER)
    @FormUrlEncoded
    Call<ResponseModel<Object>> wizallInitPayment(@Field("phone_number") String phone,
                                                  @Field("invoice_token") String invoiceToken);

    @POST(EndPointsConstants.WIZALL_MONEY_CONFIRM_PARAMETER)
    @FormUrlEncoded
    Call<ResponseModel<Object>> wizallConfirmPayment(@Field("phone_number") String phone,
                                                     @Field("authorization_code") String invoiceToken);

}
