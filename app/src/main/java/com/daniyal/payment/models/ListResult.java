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
 * This class is designed to hold list of payment networks available for particular transaction based on provided information and result of
 * initialized payment session.
 * <p>
 * An instance of this object is returned as a result of new <code>Transaction</code> initialization, or during list status update via GET
 * method.
 */

public class ListResult {
    /** Simple API, always present */
    private Map<String, URL> links;
    /** Simple API, always present */
    private String resultInfo;
    /** Simple API, optional, always present in response to action (POST, UPDATE) */
    private Interaction interaction;
    /** Simple API, optional */
    private List<AccountRegistration> accounts;
    /** Simple API, optional, always present in native LIST */
    private Networks networks;
    /** Advanced API, optional */
    private ExtraElements extraElements;
    /** Preset account, Simple API, optional, could present only in the LIST-for-PRESET */
    private PresetAccount presetAccount;
    /** LIST type based on operation of next referred actions, could be one of CHARGE, PRESET, PAYOUT, UPDATE. */
    private String operationType;
    /** Indicates whether this LIST is explicitly initialized with permission or denial to delete accounts. */
    private Boolean allowDelete;
    /** The style object passed in the transaction. */
    private Style style;
    /** Payment information, optional */
    private Payment payment;
    /** Collections of the products, optional */
    private List<Product> products;
    /** Integration type used when creating the LIST session, always present */
    private String integrationType;

    public Map<String, URL> getLinks() {
        return links;
    }

    public void setLinks(Map<String, URL> links) {
        this.links = links;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    public Interaction getInteraction() {
        return interaction;
    }

    public void setInteraction(Interaction interaction) {
        this.interaction = interaction;
    }

    public List<AccountRegistration> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountRegistration> accounts) {
        this.accounts = accounts;
    }

    public Networks getNetworks() {
        return networks;
    }

    public void setNetworks(Networks networks) {
        this.networks = networks;
    }

    public ExtraElements getExtraElements() {
        return extraElements;
    }

    public void setExtraElements(ExtraElements extraElements) {
        this.extraElements = extraElements;
    }

    public PresetAccount getPresetAccount() {
        return presetAccount;
    }

    public void setPresetAccount(PresetAccount presetAccount) {
        this.presetAccount = presetAccount;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Boolean getAllowDelete() {
        return allowDelete;
    }

    public void setAllowDelete(Boolean allowDelete) {
        this.allowDelete = allowDelete;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getIntegrationType() {
        return integrationType;
    }

    public void setIntegrationType(String integrationType) {
        this.integrationType = integrationType;
    }
}
