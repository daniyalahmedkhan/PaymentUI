package com.daniyal.payment.adapters;

/*This interface is handler of PaymentListAdapter */
public interface PaymentOptionListHandler  {

    void falsePreviousSelectedItems();
    String returnValidNetworkMethod(String methodName);

}
