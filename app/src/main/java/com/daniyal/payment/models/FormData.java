/*
 * Copyright (c) 2020 Payoneer Germany GmbH
 * https://www.payoneer.com
 *
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more information.
 */

package com.daniyal.payment.models;

import java.net.URL;


/**
 * Form data to pre-fill network form. Not all data could be provided- it depends what data we know already and what network should been used.
 */

public class FormData {
    /** account-related data to pre-fill a form */
    private AccountFormData account;
    /** customer-related data to pre-fill a form */
    private CustomerFormData customer;
    /** installments plans data */
    private Installments installments;
    /** An URL to the data privacy consent document */
    private URL dataPrivacyConsentUrl;
}
