package com.daniyal.payment.network;

import android.content.Context;

import com.daniyal.payment.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.CertificatePinner;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebServiceFactory {

    public static final Dispatcher dispatcher = new Dispatcher();
    private static WebService mInstance;

    private WebServiceFactory() {
        // Exists only to defeat instantiation.
    }

    public static WebService getInstance() {

        // set your desired log level
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            // development build
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            // production build
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }


        OkHttpClient.Builder httpclient = new OkHttpClient.Builder();
        httpclient.followRedirects(false);

        /**
         * To avoid time out exception
         */
        httpclient.connectTimeout(90, TimeUnit.SECONDS)
                .writeTimeout(90, TimeUnit.SECONDS)
                .readTimeout(90, TimeUnit.SECONDS);

        httpclient.addInterceptor(logging);
        httpclient.dispatcher(dispatcher);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WebServiceConstants.BASE)
                .client(httpclient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mInstance = retrofit.create(WebService.class);

        return mInstance;
    }
}
