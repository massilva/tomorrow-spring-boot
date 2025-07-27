package br.ufba.tomorrow.gerenciador.exceptions.models;

import java.util.Collections;
import java.util.List;

public class ExceptionModel {
    private String message;
    private List<String> details;
    private int statusCode;

    public ExceptionModel(String message, int statusCode) {
        this(message, statusCode, Collections.emptyList());
    }

    public ExceptionModel(String message, int statusCode, List<String> details) {
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

    public List<String> getDetails() {
        return details;
    }

}
