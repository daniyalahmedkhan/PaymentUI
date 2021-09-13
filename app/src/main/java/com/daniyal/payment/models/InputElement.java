/*
 * Copyright (c) 2020 Payoneer Germany GmbH
 * https://www.payoneer.com
 *
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more information.
 */

package com.daniyal.payment.models;

import java.util.List;


/**
 * Form input element description.
 */

public class InputElement {
    /** name */
    private String name;
    /** type */
    private String type;
    /** options */
    private List<SelectOption> options;
}
