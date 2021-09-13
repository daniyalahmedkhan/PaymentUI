/*
 * Copyright (c) 2020 Payoneer Germany GmbH
 * https://www.payoneer.com
 *
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more information.
 */

package com.daniyal.payment.models;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * This class describes the interaction reason of a result.
 */
public class InteractionReason {

    public final static String OK = "OK";
    public final static String PENDING = "PENDING";
    public final static String STRONG_AUTHENTICATION = "STRONG_AUTHENTICATION";
    public final static String DECLINED = "DECLINED";
    public final static String EXCEEDS_LIMIT = "EXCEEDS_LIMIT";
    public final static String TEMPORARY_FAILURE = "TEMPORARY_FAILURE";
    public final static String NETWORK_FAILURE = "NETWORK_FAILURE";
    public final static String BLACKLISTED = "BLACKLISTED";
    public final static String BLOCKED = "BLOCKED";
    public final static String SYSTEM_FAILURE = "SYSTEM_FAILURE";
    public final static String INVALID_ACCOUNT = "INVALID_ACCOUNT";
    public final static String FRAUD = "FRAUD";
    public final static String ADDITIONAL_NETWORKS = "ADDITIONAL_NETWORKS";
    public final static String INVALID_REQUEST = "INVALID_REQUEST";
    public final static String SCHEDULED = "SCHEDULED";
    public final static String NO_NETWORKS = "NO_NETWORKS";
    public final static String DUPLICATE_OPERATION = "DUPLICATE_OPERATION";
    public final static String CHARGEBACK = "CHARGEBACK";
    public final static String RISK_DETECTED = "RISK_DETECTED";
    public final static String CUSTOMER_ABORT = "CUSTOMER_ABORT";
    public final static String EXPIRED_SESSION = "EXPIRED_SESSION";
    public final static String EXPIRED_ACCOUNT = "EXPIRED_ACCOUNT";
    public final static String ACCOUNT_NOT_ACTIVATED = "ACCOUNT_NOT_ACTIVATED";
    public final static String TRUSTED_CUSTOMER = "TRUSTED_CUSTOMER";
    public final static String UNKNOWN_CUSTOMER = "UNKNOWN_CUSTOMER";
    public final static String ACTIVATED = "ACTIVATED";
    public final static String UPDATED = "UPDATED";
    public final static String TAKE_ACTION = "TAKE_ACTION";

    // client side interaction reasons
    public final static String COMMUNICATION_FAILURE = "COMMUNICATION_FAILURE";
    public final static String CLIENTSIDE_ERROR = "CLIENTSIDE_ERROR";

    /**
     * Check if the given reason is a valid interaction reason
     *
     * @param reason the interaction reason to validate
     * @return true when valid, false otherwise
     */
    public static boolean isValid(final String reason) {

        if (reason != null) {
            switch (reason) {
                case OK:
                case PENDING:
                case STRONG_AUTHENTICATION:
                case DECLINED:
                case EXCEEDS_LIMIT:
                case TEMPORARY_FAILURE:
                case NETWORK_FAILURE:
                case BLACKLISTED:
                case BLOCKED:
                case SYSTEM_FAILURE:
                case INVALID_ACCOUNT:
                case FRAUD:
                case ADDITIONAL_NETWORKS:
                case INVALID_REQUEST:
                case SCHEDULED:
                case NO_NETWORKS:
                case DUPLICATE_OPERATION:
                case CHARGEBACK:
                case RISK_DETECTED:
                case CUSTOMER_ABORT:
                case EXPIRED_SESSION:
                case EXPIRED_ACCOUNT:
                case ACCOUNT_NOT_ACTIVATED:
                case TRUSTED_CUSTOMER:
                case UNKNOWN_CUSTOMER:
                case ACTIVATED:
                case UPDATED:
                case TAKE_ACTION:
                case COMMUNICATION_FAILURE:
                case CLIENTSIDE_ERROR:
                    return true;
            }
        }
        return false;
    }

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
        OK,
        PENDING,
        STRONG_AUTHENTICATION,
        DECLINED,
        EXCEEDS_LIMIT,
        TEMPORARY_FAILURE,
        NETWORK_FAILURE,
        BLACKLISTED,
        BLOCKED,
        SYSTEM_FAILURE,
        INVALID_ACCOUNT,
        FRAUD,
        ADDITIONAL_NETWORKS,
        INVALID_REQUEST,
        SCHEDULED,
        NO_NETWORKS,
        DUPLICATE_OPERATION,
        CHARGEBACK,
        RISK_DETECTED,
        CUSTOMER_ABORT,
        EXPIRED_SESSION,
        EXPIRED_ACCOUNT,
        ACCOUNT_NOT_ACTIVATED,
        TRUSTED_CUSTOMER,
        UNKNOWN_CUSTOMER,
        ACTIVATED,
        UPDATED,
        TAKE_ACTION,
        COMMUNICATION_FAILURE,
        CLIENTSIDE_ERROR })
    public @interface Definition { }
}



