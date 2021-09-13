/*
 * Copyright (c) 2020 Payoneer Germany GmbH
 * https://www.payoneer.com
 *
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more information.
 */

package com.daniyal.payment.models;

import java.math.BigDecimal;


/**
 * This class is designed to hold payment information.
 */

public class Payment {
    /** mandatory */
    private String reference;
    /** mandatory */
    private BigDecimal amount;
    /** mandatory */
    private String currency;
    /** optional (max 128) */
    private String invoiceId;
    /** optional */
    private LongReference longReference;
}
