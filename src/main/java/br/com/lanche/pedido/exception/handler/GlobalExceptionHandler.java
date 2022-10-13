package br.com.lanche.pedido.exception.handler;

import br.com.lanche.pedido.exception.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;
import java.util.Optional;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {

        return ResponseEntity.badRequest().body(ex.getFieldErrors());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> naoEncontrado() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.of(Map.of("message", "Objeto não encontrado")));
    }
}
