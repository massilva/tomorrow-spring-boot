package br.ufba.tomorrow.gerenciador.exceptions.models;

import java.util.Collections;
import java.util.List;

import br.ufba.tomorrow.gerenciador.exceptions.enums.TypeException;

public class ExceptionModel {
    private String message;
    private List<String> details;
    private int statusCode;
    private TypeException typeException;

    public ExceptionModel(String message, int statusCode, TypeException typeException) {
        this(message, statusCode, typeException, Collections.emptyList());
    }

    public ExceptionModel(String message, int statusCode, TypeException typeException, List<String> details) {
        this.message = message;
        this.details = details;
        this.statusCode = statusCode;
        this.typeException = typeException;
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

    public TypeException getTypeException() {
        return typeException;
    }

}
