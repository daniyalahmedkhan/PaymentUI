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
 * Type of possible input element
 */
public class RedirectType {

    public final static String SUMMARY = "SUMMARY";
    public final static String RETURN = "RETURN";
    public final static String CANCEL = "CANCEL";
    public final static String PROVIDER = "PROVIDER";
    public final static String HANDLER3DS2 = "3DS2-HANDLER";

    /**
     * Check if the given type is a valid Redirect type
     *
     * @param type the redirect type to validate
     * @return true when valid, false otherwise
     */
    public static boolean isValid(final String type) {

        if (type != null) {
            switch (type) {
                case SUMMARY:
                case RETURN:
                case CANCEL:
                case PROVIDER:
                case HANDLER3DS2:
                    return true;
            }
        }
        return false;
    }

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
        SUMMARY,
        RETURN,
        CANCEL,
        PROVIDER,
        HANDLER3DS2 })
    public @interface Definition { }
}



