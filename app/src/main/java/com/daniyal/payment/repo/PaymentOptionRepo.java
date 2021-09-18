package com.daniyal.payment.repo;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.daniyal.payment.models.ListResult;
import com.daniyal.payment.network.WebService;
import com.daniyal.payment.network.WebServiceFactory;
import com.daniyal.payment.utilities.CommonHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* This class will make the network call to fetch data and post to VM */
public class PaymentOptionRepo {

    WebService webService = WebServiceFactory.getInstance();
    final MutableLiveData<ApiResponse> apiResponse = new MutableLiveData<>();


    public MutableLiveData<ApiResponse> getPaymentOptions(Context context) {

        Call<ListResult> call = webService.getNetworkListing();
        call.enqueue(new Callback<ListResult>() {
            @Override
            public void onResponse(Call<ListResult> call, Response<ListResult> response) {

                apiResponse.postValue(ResponseCodeHandle.extractResponseCode(response , context));

            }

            @Override
            public void onFailure(Call<ListResult> call, Throwable t) {
                apiResponse.postValue(new ApiResponse(t));
            }
        });

        return apiResponse;
    }
}
