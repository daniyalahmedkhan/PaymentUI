/*
 * Copyright (c) 2020 Payoneer Germany GmbH
 * https://www.payoneer.com
 *
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more information.
 */

package com.daniyal.payment.models;


/**
 * This class is designed to hold information checkbox element that is displayed on payment page.
 */

public class Checkbox {
    /** Defines the mode of this Checkbox, required */
    @CheckboxMode.Definition
    private String mode;
    /** Error message that should be displayed if required checkbox is not checked by customer. */
    private String requiredMessage;
}
