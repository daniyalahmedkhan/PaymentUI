package com.daniyal.payment.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.daniyal.payment.models.ListResult;
import com.daniyal.payment.repo.ApiResponse;
import com.daniyal.payment.repo.PaymentOptionRepo;

public class PaymentViewModel extends ViewModel {

    private PaymentOptionRepo paymentOptionRepo;
    private MutableLiveData<ApiResponse> mutableLiveData;

    public PaymentViewModel(){
        paymentOptionRepo = new PaymentOptionRepo();

    }

    public LiveData<ApiResponse> getData(){

        if (mutableLiveData == null){
            mutableLiveData = paymentOptionRepo.getPaymentOptions();
        }

        //mutableLiveData.setValue(paymentOptionRepo.getPaymentOptions().getValue());
        return mutableLiveData;

    }


}
