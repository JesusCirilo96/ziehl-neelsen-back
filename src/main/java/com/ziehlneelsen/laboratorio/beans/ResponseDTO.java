package com.ziehlneelsen.laboratorio.beans;

public class ResponseDTO {

    /**
     * coodigo de error
     */
    String errorCode;

    /**
     * informacion adicional del error
     */
    String errorInfo;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "errorCode='" + errorCode + '\'' +
                ", errorInfo='" + errorInfo + '\'' +
                '}';
    }
}
