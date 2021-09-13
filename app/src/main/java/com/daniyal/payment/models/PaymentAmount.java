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
 * Payment amount data.
 */

public class PaymentAmount {
    /** amount */
    private BigDecimal amount;
    /** currency */
    private String currency;
}
