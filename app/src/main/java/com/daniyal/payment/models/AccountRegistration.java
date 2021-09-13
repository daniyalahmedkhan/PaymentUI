/*
 * Copyright (c) 2020 Payoneer Germany GmbH
 * https://www.payoneer.com
 *
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more information.
 */

package com.daniyal.payment.models;

import java.net.URL;
import java.util.List;
import java.util.Map;


/**
 * Represents a customer's account (payment information for a payment method) that has been registered (i.e. stored).
 */

public class AccountRegistration {
    /** Simple API, always present */
    private Map<String, URL> links;
    /** Simple API, always present */
    private String code;
    /** Simple API, always present */
    @PaymentMethod.Definition
    private String method;
    /** Simple API, always present */
    private String label;
    /** Simple API, always present */
    @NetworkOperationType.Definition
    private String operationType;
    /** Simple API, always present */
    private AccountMask maskedAccount;
    /** Indicates that this account registration is initially selected */
    private Boolean selected;
    /** code of button-label if this network is selected */
    private String button;
    /** An indicator that a form for this network is an empty one, without any text and input elements */
    private Boolean emptyForm;
    /** Form input elements descriptions */
    private List<InputElement> inputElements;
    /** contract data of first possible route. */
    private Map<String, String> contractData;
}
