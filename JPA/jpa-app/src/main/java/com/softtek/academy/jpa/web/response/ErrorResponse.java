package com.softtek.academy.jpa.web.response;

public class ErrorResponse {

    private Integer status;

    private String message;

    private String moreInfo;


    public ErrorResponse() {
    }

    public ErrorResponse(Integer status, String message, String moreInfo) {
        this.status = status;
        this.message = message;
        this.moreInfo = moreInfo;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }


    @Override
    public String toString() {
        return String.format("ErrorResponse [status=%s, message=%s, moreInfo=%s]", status, message, moreInfo);
    }

}
