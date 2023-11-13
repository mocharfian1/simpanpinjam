package com.finance.simjam.models;

public class ApiResponse<T> {
    private Integer errorCode;
    private String errorMessage;
    private T data;

    public ApiResponse(Integer errorCode, String errorMessage, T data) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.data = data;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
