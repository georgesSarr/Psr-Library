package com.paydunya.paydunyapsrlibrary.Network.Entities;

import com.squareup.moshi.Json;

public class ResponseModel<T> {

    @Json(name = "success")
    boolean success;
    @Json(name = "data")
    T data;
    @Json(name = "message")
    String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
