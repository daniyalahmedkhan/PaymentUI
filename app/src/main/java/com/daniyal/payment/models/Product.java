/*
 * Copyright (c) 2020 Payoneer Germany GmbH
 * https://www.payoneer.com
 *
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more information.
 */

package com.daniyal.payment.models;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Date;



/**
 * This class is designed to hold product information.
 */

public class Product {
    /** optional */
    private String code;
    /** mandatory */
    private String name;
    /** optional (totalAmount) */
    private BigDecimal amount;
    /** optional */
    private String currency;
    /** optional */
    private Integer quantity;
    /** optional */
    private Date plannedShippingDate;
    /** optional */
    private URL productDescriptionUrl;
    /** optional */
    private URL productImageUrl;
    /** optional */
    private String description;
    /** optional */
    private String shippingAddressId;
    /** optional */
    private ProductType type;
    /** optional */
    private BigDecimal netAmount;
    /** optional */
    private BigDecimal taxAmount;
    /** optional */
    private BigDecimal taxRatePercentage;
}
