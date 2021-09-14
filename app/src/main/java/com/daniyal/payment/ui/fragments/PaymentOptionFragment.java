package com.daniyal.payment.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.daniyal.payment.R;
import com.daniyal.payment.models.ListResult;
import com.daniyal.payment.network.WebService;
import com.daniyal.payment.network.WebServiceFactory;
import com.daniyal.payment.ui.views.Toolbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PaymentOptionFragment extends BaseFragment {

    public static PaymentOptionFragment newInstance(){
        return new PaymentOptionFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.payment_option_fragment , container , false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        WebService webService = WebServiceFactory.getInstance();
//        Call<ListResult> call = webService.getNetworkListing();
//        call.enqueue(new Callback<ListResult>() {
//            @Override
//            public void onResponse(Call<ListResult> call, Response<ListResult> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<ListResult> call, Throwable t) {
//
//            }
//        });


    }

    @Override
    protected void setTitleBar(Toolbar toolbar) {
        toolbar.setSubHeading("Toolbar");
        toolbar.setTitleBarColor(R.color.black);
    }
}
