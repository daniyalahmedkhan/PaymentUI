package com.daniyal.payment.repo;

import android.content.Context;

import com.daniyal.payment.R;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class ResponseCodeHandle {

    public static ApiResponse extractResponseCode(Response response, Context context) {
        switch (response.code()) {
            case 200:
                return new ApiResponse(response);
            case 400:
                break;
            case 401:
                break;
            case 403:
                break;
            case 404:
                return new ApiResponse(context.getResources().getString(R.string.notFound));
            case 500:
                break;
            case 502:
                break;
            case 504:
                break;
        }
        return null;
    }
}
