package com.daniyal.payment.adapters;


public interface PaymentOptionListHandler  {

    void falsePreviousSelectedItems();
    String returnValidNetworkMethod(String methodName);

}
