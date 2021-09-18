package com.daniyal.payment.repo;

import android.content.Context;

import com.daniyal.payment.R;

import okhttp3.ResponseBody;
import retrofit2.Response;


/*This class is responsible to handle api response code also body and errors */
public class ResponseCodeHandle {

    public static <T> ApiResponse extractResponseCode(Response<T> response, Context context) {
        switch (response.code()) {
            case 200:
                return new ApiResponse(response);
            case 400:
                return new ApiResponse(context.getResources().getString(R.string.badRequestError));
            case 401:
                return new ApiResponse(context.getResources().getString(R.string.unauthorizedError));
            case 403:
                return new ApiResponse(context.getResources().getString(R.string.forbiddenError));
            case 404:
                return new ApiResponse(context.getResources().getString(R.string.notFound));
            case 500:
                return new ApiResponse(context.getResources().getString(R.string.serverError));
            case 502:
                return new ApiResponse(context.getResources().getString(R.string.gatewayBadError));
            case 504:
                return new ApiResponse(context.getResources().getString(R.string.gatewayTimeoutError));
            default:
                return new ApiResponse(context.getResources().getString(R.string.generalError));
        }
    }
}
