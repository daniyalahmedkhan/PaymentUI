package com.daniyal.payment.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.daniyal.payment.R;
import com.daniyal.payment.models.ListResult;
import com.daniyal.payment.network.WebService;
import com.daniyal.payment.network.WebServiceFactory;
import com.daniyal.payment.repo.ApiResponse;
import com.daniyal.payment.ui.views.Toolbar;
import com.daniyal.payment.vm.PaymentViewModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PaymentOptionFragment extends BaseFragment {

    PaymentViewModel paymentViewModel;
    ListResult listResult;

    public static PaymentOptionFragment newInstance() {
        return new PaymentOptionFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.payment_card_item, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //paymentViewModel = ViewModelProviders.of(requireActivity()).get(PaymentViewModel.class);

        paymentViewModel = new PaymentViewModel();

        paymentViewModel.getData().observe(requireActivity(), new Observer<ApiResponse>() {
            @Override
            public void onChanged(ApiResponse apiResponse) {
                Log.d("TEST", String.valueOf(apiResponse));
                listResult = (ListResult) apiResponse.getResponse().body();
                listResult.getNetworks();
            }
        });

//        WebService webService = WebServiceFactory.getInstance();
//        Call<ListResult> call = webService.getNetworkListing();
//
//        call.enqueue(new Callback<ListResult>() {
//            @Override
//            public void onResponse(Call<ListResult> call, Response<ListResult> response) {
//
//                if (response.code() == 200){
//                    Log.d("TEST", String.valueOf(response.body()));
//                }else if (response.code() == 400){
//                    Log.d("TEST", String.valueOf(response.body()));
//                }if (response.code() == 500){
//                    Log.d("TEST", String.valueOf(response.body()));
//                }if (response.code() == 404){
//                    Log.d("TEST", String.valueOf(response.body()));
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ListResult> call, Throwable t) {
//                Log.d("TEST", String.valueOf(t));
//            }
//        });


    }

    @Override
    protected void setTitleBar(Toolbar toolbar) {
        toolbar.setSubHeading("Toolbar");
        toolbar.setTitleBarColor(R.color.black);
    }
}
