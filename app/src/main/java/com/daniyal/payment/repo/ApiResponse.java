package com.daniyal.payment.repo;

import retrofit2.Response;

public class ApiResponse {

    public Response response;
    public Throwable t;


    public ApiResponse(Response response){
        this.response = response;
        this.t = null;

    }

    public ApiResponse(Throwable t){
        this.response = null;
        this.t = t;
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
}
