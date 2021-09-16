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
 * This class is designed to hold information about applicable payment network.
 */

public class ApplicableNetwork {
    /** Simple API, always present */
    private String code;
    /** Simple API, always present */
    private String label;
    /** Simple API, always present */
    @PaymentMethod.Definition
    private String method;
    /** Simple API, always present */
    private String grouping;
    /** Simple API, always present */
    @NetworkOperationType.Definition
    private String operationType;
    /** Simple API, always present */
    @RegistrationType.Definition
    private String registration;
    /** Simple API, always present */
    @RegistrationType.Definition
    private String recurrence;
    /** Simple API, always present */
    private Boolean redirect;
    /** Simple API, always present */
    private Map<String, URL> links;
    /** code of button-label if this network is selected */
    private String button;
    /** flag that network is initially selected */
    private Boolean selected;
    /** form data to pre-fill a form */
    private FormData formData;
    /** An indicator that a form for this network is an empty one, without any text and input elements */
    private Boolean emptyForm;
    /** Form elements descriptions */
    private List<InputElement> inputElements;
    /** contract data of first possible route. */
    private Map<String, String> contractData;
    /** state maintain of click item in list*/
    private boolean isClicked;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getGrouping() {
        return grouping;
    }

    public void setGrouping(String grouping) {
        this.grouping = grouping;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }

    public Boolean getRedirect() {
        return redirect;
    }

    public void setRedirect(Boolean redirect) {
        this.redirect = redirect;
    }

    public Map<String, URL> getLinks() {
        return links;
    }

    public void setLinks(Map<String, URL> links) {
        this.links = links;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public FormData getFormData() {
        return formData;
    }

    public void setFormData(FormData formData) {
        this.formData = formData;
    }

    public Boolean getEmptyForm() {
        return emptyForm;
    }

    public void setEmptyForm(Boolean emptyForm) {
        this.emptyForm = emptyForm;
    }

    public List<InputElement> getInputElements() {
        return inputElements;
    }

    public void setInputElements(List<InputElement> inputElements) {
        this.inputElements = inputElements;
    }

    public Map<String, String> getContractData() {
        return contractData;
    }

    public void setContractData(Map<String, String> contractData) {
        this.contractData = contractData;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }
}
