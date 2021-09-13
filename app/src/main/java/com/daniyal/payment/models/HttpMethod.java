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
 * This class describes HTTP methods that are valid for customer's browser redirect.
 */
public class HttpMethod {

    public final static String GET = "GET";
    public final static String POST = "POST";

    /**
     * Check if the given method is a valid http method
     *
     * @param method the http method to validate
     * @return true when valid, false otherwise
     */
    public static boolean isValid(final String method) {

        if (method != null) {
            switch (method) {
                case GET:
                case POST:
                    return true;
            }
        }
        return false;
    }

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
        GET,
        POST })
    public @interface Definition { }
}
