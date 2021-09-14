package com.daniyal.payment.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.daniyal.payment.models.ListResult;
import com.daniyal.payment.network.WebService;
import com.daniyal.payment.network.WebServiceFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentOptionRepo {

    WebService webService = WebServiceFactory.getInstance();
    final MutableLiveData<ApiResponse> apiResponse = new MutableLiveData<>();

    public MutableLiveData<ApiResponse> getPaymentOptions() {

        Call<ListResult> call = webService.getNetworkListing();
        call.enqueue(new Callback<ListResult>() {
            @Override
            public void onResponse(Call<ListResult> call, Response<ListResult> response) {

                if (response.code() == 200){
                    apiResponse.postValue(new ApiResponse(response));
                }
            }

            @Override
            public void onFailure(Call<ListResult> call, Throwable t) {

            }
        });

        return apiResponse;
    }
}
