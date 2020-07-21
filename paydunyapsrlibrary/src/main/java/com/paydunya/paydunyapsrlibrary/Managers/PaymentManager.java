package com.paydunya.paydunyapsrlibrary.Managers;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.paydunya.paydunyapsrlibrary.Constants.EndPointsConstants;
import com.paydunya.paydunyapsrlibrary.Network.ApiServices;
import com.paydunya.paydunyapsrlibrary.Network.Entities.CheckoutInvoiceModel;
import com.paydunya.paydunyapsrlibrary.Network.Entities.InvoiceModel;
import com.paydunya.paydunyapsrlibrary.Network.Entities.Parameters;
import com.paydunya.paydunyapsrlibrary.Network.Entities.StoreModel;
import com.paydunya.paydunyapsrlibrary.Network.RetroFitBuilder;
import com.paydunya.paydunyapsrlibrary.PayInActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentManager {

    private static PaymentManager instance;
    private String paydunyaMasterKey;
    private String paydunyaPrivateKey;
    private String paydunyaToken;
    private Integer amount;

    private CheckoutInvoiceModel checkoutInvoiceModel;

    private PaymentManager() {

    }

    public static PaymentManager getInstance() {
        if (instance == null) {
            instance = new PaymentManager();
        }
        return instance;
    }

    public String getPaydunyaMasterKey() {
        return paydunyaMasterKey;
    }

    public void setPaydunyaMasterKey(String paydunyaMasterKey) {
        this.paydunyaMasterKey = paydunyaMasterKey;
    }

    public String getPaydunyaPrivateKey() {
        return paydunyaPrivateKey;
    }

    public void setPaydunyaPrivateKey(String paydunyaPrivateKey) {
        this.paydunyaPrivateKey = paydunyaPrivateKey;
    }

    public String getPaydunyaToken() {
        return paydunyaToken;
    }

    public void setPaydunyaToken(String paydunyaToken) {
        this.paydunyaToken = paydunyaToken;
    }

    public CheckoutInvoiceModel getCheckoutInvoiceModel() {
        return checkoutInvoiceModel;
    }

    public void setCheckoutInvoiceModel(CheckoutInvoiceModel checkoutInvoiceModel) {
        this.checkoutInvoiceModel = checkoutInvoiceModel;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void initPayment(final Activity activity) {
        ApiServices apiServices = RetroFitBuilder.createService(ApiServices.class, EndPointsConstants.PAYDUNYA_DIRECT_PAY_BASE_URL, activity);
        if (paydunyaToken == null || paydunyaPrivateKey == null || paydunyaMasterKey == null || amount == null) {
            return;
        } else {
            Parameters parameters = new Parameters();
            InvoiceModel invoiceModel = new InvoiceModel();
            invoiceModel.setTotalAmount(200);

            StoreModel storeModel = new StoreModel();
            storeModel.setName("Boutique");
            ArrayList<String> channels = new ArrayList();
            channels.add("card");
            invoiceModel.setChannels(channels);
            parameters.setInvoice(invoiceModel);
            parameters.setStore(storeModel);
            Call<CheckoutInvoiceModel> callCheckoutInvoice = apiServices.initCheckoutInvoice(paydunyaMasterKey,
                    paydunyaPrivateKey,
                    paydunyaToken,
                    parameters);
            callCheckoutInvoice.enqueue(new Callback<CheckoutInvoiceModel>() {
                @Override
                public void onResponse(Call<CheckoutInvoiceModel> call, Response<CheckoutInvoiceModel> response) {
                    if(response.isSuccessful()){
                        checkoutInvoiceModel = response.body();
                        if(checkoutInvoiceModel.getToken() != null) {
                            activity.startActivity(new Intent(activity, PayInActivity.class));
                        }else {
                            Toast.makeText(activity, "Impossible initier le paiement", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<CheckoutInvoiceModel> call, Throwable t) {
                    Toast.makeText(activity, "Impossible initier le paiement", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
