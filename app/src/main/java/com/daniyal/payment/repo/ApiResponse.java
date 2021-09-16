package com.daniyal.payment.repo;

import retrofit2.Response;

public class ApiResponse {

    private Response response;
    private Throwable t;
    private String errorMessage;

    public ApiResponse(Response response){
        this.response = response;
        this.t = null;
        this.errorMessage = null;

    }

    public ApiResponse(Throwable t){
        this.response = null;
        this.t = t;
        this.errorMessage = null;
    }

    public ApiResponse(String errorMessage){
        this.errorMessage = errorMessage;
        this.response = null;
        this.t = null;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Throwable getT() {
        return t;
    }

    public void setT(Throwable t) {
        this.t = t;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
