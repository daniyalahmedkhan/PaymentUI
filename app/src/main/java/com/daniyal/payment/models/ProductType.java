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
 * A type of the product.
 */
public class ProductType {

    public final static String PHYSICAL = "PHYSICAL";
    public final static String DIGITAL = "DIGITAL";
    public final static String SERVICE = "SERVICE";
    public final static String TAX = "TAX";
    public final static String OTHER = "OTHER";

    /**
     * Check if the given type is a valid product type
     *
     * @param productType the product type to validate
     * @return true when valid, false otherwise
     */
    public static boolean isValid(final String productType) {

        if (productType != null) {
            switch (productType) {
                case PHYSICAL:
                case DIGITAL:
                case SERVICE:
                case TAX:
                case OTHER:
                    return true;
            }
        }
        return false;
    }

    /**
     * The interface Definition
     */
    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
        PHYSICAL,
        DIGITAL,
        SERVICE,
        TAX,
        OTHER })
    public @interface Definition { }
}
