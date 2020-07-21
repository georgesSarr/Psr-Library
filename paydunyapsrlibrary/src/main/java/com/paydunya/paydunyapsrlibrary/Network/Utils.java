package com.paydunya.paydunyapsrlibrary.Network;

import android.content.Context;


import com.paydunya.paydunyapsrlibrary.Network.Entities.ApiError;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class Utils {

    public static ApiError convertErrors(Context context, ResponseBody response, String baseUrl){
        Converter<ResponseBody, ApiError> converter = RetroFitBuilder.getRetrofit(context, baseUrl).responseBodyConverter(ApiError.class, new Annotation[0]);
        ApiError apiError = null;
        try {
            apiError = converter.convert(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return apiError;
    }
}
