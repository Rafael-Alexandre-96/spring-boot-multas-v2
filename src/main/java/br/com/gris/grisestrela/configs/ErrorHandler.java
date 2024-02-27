package br.com.gris.grisestrela.configs;

import java.util.Dictionary;
import java.util.Hashtable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.gris.grisestrela.exceptions.IdNotFoundException;
import br.com.gris.grisestrela.exceptions.InvalidFormatException;
import br.com.gris.grisestrela.exceptions.InvalidSaveDataException;
import br.com.gris.grisestrela.exceptions.RelationalViolationException;
import br.com.gris.grisestrela.models.exception.ExceptionModel;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({RuntimeException.class, Exception.class})
  public ResponseEntity<ExceptionModel> handleAll(RuntimeException ex, WebRequest request) {
    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    ExceptionModel model = new ExceptionModel();
    model.setHttpStatus(status);
    model.setMessage(ex.getMessage());
    model.setException(ex.getClass().getName().toString());
    model.setPath(request.getDescription(true));
    return new ResponseEntity<ExceptionModel>(model, status);
  }

  @ExceptionHandler({IdNotFoundException.class})
  public ResponseEntity<ExceptionModel> handleNotFound(RuntimeException ex, WebRequest request) {
    HttpStatus status = HttpStatus.NOT_FOUND;
    ExceptionModel model = new ExceptionModel();
    model.setHttpStatus(status);
    model.setMessage(ex.getMessage());
    model.setException(ex.getClass().getName().toString());
    model.setPath(request.getDescription(true));
    return new ResponseEntity<ExceptionModel>(model, status);
  }

  @ExceptionHandler({InvalidFormatException.class, InvalidSaveDataException.class, RelationalViolationException.class})
  public ResponseEntity<ExceptionModel> handleBadRequest(RuntimeException ex, WebRequest request) {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    ExceptionModel model = new ExceptionModel();
    model.setHttpStatus(status);
    model.setMessage(ex.getMessage());
    model.setException(ex.getClass().getName().toString());
    model.setPath(request.getDescription(true));
    return new ResponseEntity<ExceptionModel>(model, status);
  }

  @ExceptionHandler({ConstraintViolationException.class})
  public ResponseEntity<ExceptionModel> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    ExceptionModel model = new ExceptionModel();
    model.setHttpStatus(status);
    Dictionary<String, String> msg = new Hashtable<String, String>();
    ex.getConstraintViolations().forEach((x) -> {
      msg.put(x.getPropertyPath().toString(), x.getMessage());
    });
    model.setMessage(msg.toString());
    model.setException(ex.getClass().getName().toString());
    model.setPath(request.getDescription(true));
    return new ResponseEntity<ExceptionModel>(model, status);
  }
}
