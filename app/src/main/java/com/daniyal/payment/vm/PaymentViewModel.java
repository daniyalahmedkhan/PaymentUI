package com.daniyal.payment.vm;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.daniyal.payment.models.ListResult;
import com.daniyal.payment.repo.ApiResponse;
import com.daniyal.payment.repo.PaymentOptionRepo;

/* This class OR viewModel to get payment methods list from repo */
public class PaymentViewModel extends ViewModel {

    private final PaymentOptionRepo paymentOptionRepo;
    private MutableLiveData<ApiResponse> mutableLiveData;
    private final Context context;

    public PaymentViewModel(Context context) {
        paymentOptionRepo = new PaymentOptionRepo();
        this.context = context;

    }

    public LiveData<ApiResponse> getData() {

        if (mutableLiveData == null) {
            mutableLiveData = paymentOptionRepo.getPaymentOptions(context);
        }

        return mutableLiveData;

    }


}
