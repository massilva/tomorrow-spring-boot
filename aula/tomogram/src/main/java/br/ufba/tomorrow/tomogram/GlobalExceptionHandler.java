package br.ufba.tomorrow.tomogram;

import br.ufba.tomorrow.tomogram.exceptions.NotFoundException;
import br.ufba.tomorrow.tomogram.exceptions.models.ExceptionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ExceptionModel> genericException(Exception e) {
        String mensagem = e.getMessage();
        if (e instanceof MethodArgumentTypeMismatchException) {
            mensagem = "Tipo inválido";
        }
        return ResponseEntity.badRequest().body(new ExceptionModel(mensagem, 400));
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionModel> notFoundException(NotFoundException e) {
        return ResponseEntity.badRequest().body(new ExceptionModel(e.getMessage(), 404));
    }
}
