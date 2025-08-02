package br.ufba.tomorrow.gerenciador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import br.ufba.tomorrow.gerenciador.exceptions.NotFoundException;
import br.ufba.tomorrow.gerenciador.exceptions.enums.TypeException;
import br.ufba.tomorrow.gerenciador.exceptions.models.ExceptionModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ExceptionModel> genericException(Exception e) {
        String message = e.getMessage();
        TypeException typeException = TypeException.internalServer;
        List<String> details = new ArrayList<>();

        if (e instanceof MethodArgumentTypeMismatchException) {
            message = "Tipo inválido";
            typeException = TypeException.typeMismatch;
        } else if (e instanceof MethodArgumentNotValidException) {
            var error = (MethodArgumentNotValidException) e;
            var errorList = Arrays.stream(error.getDetailMessageArguments()).toList();

            for (var obj : errorList) {
                if (obj != null && !obj.toString().isBlank()) {
                    details.add(obj.toString());
                }
            }

            message = "Campo inválido";
            typeException = TypeException.notValid;
        }

        return ResponseEntity.badRequest().body(new ExceptionModel(message, 400, typeException, details));
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionModel> notFoundException(NotFoundException e) {
        return ResponseEntity.badRequest().body(new ExceptionModel(e.getMessage(), 404, TypeException.notFound));
    }
}
