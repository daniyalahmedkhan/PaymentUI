package com.daniyal.payment.enums;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.util.HashMap;

/* This enum will help to get keys of { Map<String, URL> links } after network api */
public enum NetworkLinks {
    LOGO("logo"),
    self("self"),
    lang("lang"),
    operation("operation"),
    validation("validation");


    private String linkName;

    NetworkLinks(String linkName) {
        this.linkName = linkName;
    }


    @NonNull
    @NotNull
    @Override
    public String toString() {
        return super.toString();
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }
}
