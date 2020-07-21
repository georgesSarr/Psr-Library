package com.paydunya.paydunyapsrlibrary.Network;

import android.content.Context;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.paydunya.paydunyapsrlibrary.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

import static android.content.Context.MODE_PRIVATE;

public class RetroFitBuilder {

    private static final String BASE_URL = "https://box-backend.dunyappstore.com/api/";


    private static OkHttpClient buildClient(final Context context) {


        OkHttpClient.Builder builder = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                Request.Builder builder = request.newBuilder()
                        .addHeader("Accept", "application.json")
                        .addHeader("Content-Type", "application.json")
                        .addHeader("Content-Type", "application/x-www-form-urlencoded")
                        .addHeader("X-Requested-With", "XMLHttpRequest")
                        .addHeader("Connection", "close");

                request = builder.build();

                return chain.proceed(request);
            }
        });
        if (BuildConfig.DEBUG) {
            builder.addNetworkInterceptor(new StethoInterceptor());
        }

        return builder.build();
    }

    private static Retrofit buildRetrofit(OkHttpClient client, String baseUrl) {

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create().asLenient())
                .build();

    }

    public static <T> T createService(Class<T> service, String baseUrl, Context context) {
        OkHttpClient client = buildClient(context);
        Retrofit retrofit = buildRetrofit(client, baseUrl);
        return retrofit.create(service);
    }

    public static Retrofit getRetrofit(Context context, String baseUrl) {
        return buildRetrofit(buildClient(context), baseUrl);
    }


}
