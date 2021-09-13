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


/**
 * This class is designed to hold information to redirect customers browser as a result of operation execution.
 */

public class Redirect {
    /** Simple API, always present */
    private URL url;
    /** Simple API, always present */
    @HttpMethod.Definition
    private String method;
    /** Simple API, optional */
    private List<Parameter> parameters;
    /** Simple API, optional */
    private Boolean suppressIFrame;
    /** Simple API, always present in new transactions */
    private String type;
}
