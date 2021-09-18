package com.daniyal.payment.vm;

import android.content.Context;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;
import androidx.test.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.daniyal.payment.models.ListResult;
import com.daniyal.payment.repo.ApiResponse;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import kotlin.jvm.Throws;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4ClassRunner.class)
public class PaymentViewModelTest_ {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    public Observer<ApiResponse> observer;
    public PaymentViewModel paymentViewModel;
    public Context context;

    @Before
    @Throws(exceptionClasses = Exception.class)
    public void setUp() {

        //creating instance of viewmodel
        context = InstrumentationRegistry.getInstrumentation().getContext();
        paymentViewModel = new PaymentViewModel(context);

    }

    @After
    @Throws(exceptionClasses = Exception.class)
    public void tearDown() {
        paymentViewModel.getData().removeObserver(observer);
    }

    // Testing ViewModel
    @Test
    @Throws(exceptionClasses = InterruptedException.class)
    public void getPaymentMethods() {

        try {
            paymentViewModel.getData();
            CountDownLatch signal = new CountDownLatch(1);

            observer = new Observer<ApiResponse>() {
                @Override
                public void onChanged(ApiResponse apiResponse) {
                    signal.countDown();

                    Assert.assertTrue(apiResponse.getResponse().isSuccessful() && apiResponse.getResponse() != null);
                }
            };

            paymentViewModel.getData().observeForever(observer);

            signal.await();
        } catch (Exception e) {
        }


    }

}