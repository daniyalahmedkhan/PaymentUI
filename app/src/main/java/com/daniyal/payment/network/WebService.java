package com.daniyal.payment.network;



import com.daniyal.payment.models.ListResult;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface WebService {

    @GET(WebServiceConstants.PAYMENT_OPTIONS)
    Call<ListResult> getNetworkListing();
}
