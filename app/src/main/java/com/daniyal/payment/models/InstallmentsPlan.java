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
import java.util.List;


/**
 * Payment plan to pay by schedule.
 */

public class InstallmentsPlan {
    /** unique plan id. */
    private String id;
    /** Collection of installment's info (mandatory) */
    private List<InstallmentItem> schedule;
    /** An array of possible payment days (optional) */
    private List<Integer> dueDays;

    /** Currency value (mandatory) */
    private String currency;

    /** The interest amount. */
    private BigDecimal interestAmount;
    /** Fee for opening up an installment plan (optional) */
    private BigDecimal installmentSetupFee;
    /** Constant periodic fee for each installment item  (optional) */
    private BigDecimal installmentPeriodicFee;
    /**
     * The total fee for the installment payment (or serviceChargeAmount) (mandatory).
     * Includes all periodic fees and the installment set-up fee.
     */
    private BigDecimal installmentFee;
    /** The total transaction amount after calculation including all fees and interest (mandatory) */
    private BigDecimal totalAmount;

    /** The interest rate per year in percentages (Nominalzins or Sollzins) (mandatory) */
    private BigDecimal nominalInterestRate;
    /** The effective interest rate per year in percentages (Effektivzins) (mandatory) */
    private BigDecimal effectiveInterestRate;

    /** An URL to the Credit Information document (optional) */
    private URL creditInformationUrl;
    /** An URL to terms and conditions information document (optional) */
    private URL termsAndConditionsUrl;
    /** An URL to the data privacy consent document (optional) */
    private URL dataPrivacyConsentUrl;
    /** An URL to the installment plan logo (optional) */
    private URL logoUrl;
    /** Description of the installments plan (optional) */
    private String description;
    /** Number of installments in the installments plan (optional) */
    private Integer numberOfInstallments;
}
