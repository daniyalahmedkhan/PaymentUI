/*
 * Copyright (c) 2020 Payoneer Germany GmbH
 * https://www.payoneer.com
 *
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more information.
 */

package com.daniyal.payment.models;

import java.math.BigDecimal;
import java.util.Date;


/**
 * An information about particular payment what is involved into installment payment process.
 */

public class InstallmentItem {
    /** The amount of installment (mandatory) */
    private BigDecimal amount;
    /** Installment/payment date */
    private Date date;
}
