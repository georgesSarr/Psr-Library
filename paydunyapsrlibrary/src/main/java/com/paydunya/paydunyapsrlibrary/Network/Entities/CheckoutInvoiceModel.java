package com.paydunya.paydunyapsrlibrary.Network.Entities;

import com.squareup.moshi.Json;

public class CheckoutInvoiceModel {


    @Json(name = "response_code")
    String responseCode;
    @Json(name = "response_text")
    String responseText;
    @Json(name = "description")
    String description;
    @Json(name = "token")
    String token;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
