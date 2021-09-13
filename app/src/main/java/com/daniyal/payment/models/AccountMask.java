/*
 * Copyright (c) 2020 Payoneer Germany GmbH
 * https://www.payoneer.com
 *
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more information.
 */

package com.daniyal.payment.models;


/**
 * This class is designed to hold account mask for registered payment network.
 */

public class AccountMask {
    /** Simple API, always present */
    private String displayLabel;
    /** Simple API, optional */
    private String holderName;
    /** Simple API, optional */
    private String number;
    /** Simple API, optional */
    private String bankCode;
    /** Simple API, optional */
    private String bankName;
    /** Simple API, optional */
    private String bic;
    /** Simple API, optional */
    private String branch;
    /** Simple API, optional */
    private String city;
    /** Simple API, optional */
    private Integer expiryMonth;
    /** Simple API, optional */
    private Integer expiryYear;
    /** Simple API, optional */
    private String iban;
    /** Simple API, optional */
    private String login;
}
