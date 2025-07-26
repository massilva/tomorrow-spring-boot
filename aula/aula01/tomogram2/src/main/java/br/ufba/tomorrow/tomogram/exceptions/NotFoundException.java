package br.ufba.tomorrow.tomogram.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Não encontrado");
    }
    public NotFoundException(String message) {
        super(message);
    }
}
