package br.ufba.tomorrow.tomogram.exceptions.models;

public class ExceptionModel {
    private String message;
    private int statusCode;

    public ExceptionModel(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
