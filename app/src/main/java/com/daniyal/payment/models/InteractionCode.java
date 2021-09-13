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
 * This class contains the interaction codes of a result.
 */
public class InteractionCode {

    public final static String PROCEED = "PROCEED";
    public final static String ABORT = "ABORT";
    public final static String TRY_OTHER_NETWORK = "TRY_OTHER_NETWORK";
    public final static String TRY_OTHER_ACCOUNT = "TRY_OTHER_ACCOUNT";
    public final static String RETRY = "RETRY";
    public final static String RELOAD = "RELOAD";

    // client side interaction codes
    public final static String VERIFY = "VERIFY";

    /**
     * Check if the given type is a valid interaction code
     *
     * @param code the interaction code to validate
     * @return true when valid, false otherwise
     */
    public static boolean isValid(final String code) {

        if (code != null) {
            switch (code) {
                case PROCEED:
                case ABORT:
                case TRY_OTHER_NETWORK:
                case TRY_OTHER_ACCOUNT:
                case RETRY:
                case RELOAD:
                case VERIFY:
                    return true;
            }
        }
        return false;
    }

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
        PROCEED,
        ABORT,
        TRY_OTHER_NETWORK,
        TRY_OTHER_ACCOUNT,
        RETRY,
        RELOAD,
        VERIFY
    })
    public @interface Definition { }
}



