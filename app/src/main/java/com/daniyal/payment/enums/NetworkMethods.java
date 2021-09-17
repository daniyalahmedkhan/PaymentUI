package com.daniyal.payment.enums;

import android.content.Context;

import com.daniyal.payment.R;

public enum NetworkMethods {
    CREDIT_CARD,
    DEBIT_CARD,
    ONLINE_BANK_TRANSFER,
    WALLET,
    OPEN_INVOICE,
    DIRECT_DEBIT;

    public static String getMethods(NetworkMethods networkMethods, Context context) {
        switch (networkMethods) {
            case CREDIT_CARD:
                return context.getResources().getString(R.string.CreditCard);
            case DEBIT_CARD:
                return context.getResources().getString(R.string.DebitCard);
            case WALLET:
                return context.getResources().getString(R.string.Wallet);
            case ONLINE_BANK_TRANSFER:
                return context.getResources().getString(R.string.OnlineBankTransfer);
            case OPEN_INVOICE:
                return context.getResources().getString(R.string.OpenInvoice);
            case DIRECT_DEBIT:
                return context.getResources().getString(R.string.DirectDebit);
            default:
                return context.getResources().getString(R.string.Others);
        }
    }
}
