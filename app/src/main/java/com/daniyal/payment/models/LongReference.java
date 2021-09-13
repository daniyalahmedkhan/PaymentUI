/*
 * Copyright (c) 2020 Payoneer Germany GmbH
 * https://www.payoneer.com
 *
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more information.
 */

package com.daniyal.payment.models;


/**
 * This class is designed to hold advanced reference information about payment.
 */

public class LongReference {
    /** mandatory (max 32) */
    private String essential;
    /** optional (max 32) */
    private String extended;
    /** optional (max 32) */
    private String verbose;
}
