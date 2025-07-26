package br.ufba.tomorrow.tomogram;

import br.ufba.tomorrow.tomogram.exceptions.NotFoundException;
import br.ufba.tomorrow.tomogram.exceptions.models.ExceptionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ExceptionModel> genericException(Exception e) {
        String message = e.getMessage();
        List<String> details = new ArrayList<>();

        if (e instanceof MethodArgumentTypeMismatchException) {
            message = "Tipo inválido";
        } else if (e instanceof MethodArgumentNotValidException) {
            var error = (MethodArgumentNotValidException)e;
            var errorList = Arrays.stream(error.getDetailMessageArguments()).toList();

            for (var obj : errorList) {
                if (obj != null && !obj.toString().isBlank()) { 
                    details.add(obj.toString());
                }
            }

            message = "Campos inválidos";
        }
        return ResponseEntity.badRequest().body(new ExceptionModel(message, 400, details));
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionModel> notFoundException(NotFoundException e) {
        return ResponseEntity.badRequest().body(new ExceptionModel(e.getMessage(), 404));
    }
}
