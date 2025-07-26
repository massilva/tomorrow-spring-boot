package br.ufba.tomorrow.tomogram.exceptions.models;

import java.util.Collections;
import java.util.List;

public class ExceptionModel {
    private String message;
    private List details;
    private int statusCode;

    public ExceptionModel(String message, int statusCode) {
        this(message, statusCode, Collections.emptyList());
    }

    public ExceptionModel(String message, int statusCode, List details) {
        this.message = message;
        this.details = details;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public List getDetails() {
        return details;
    }

}
