package br.com.gestor.multas.models.exception;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExceptionModel {
  
  @Setter(AccessLevel.NONE)
  private Integer httpStatusCode;
  private HttpStatus httpStatus;
  private OffsetDateTime timestamp = OffsetDateTime.now();
  private String message;
  private String exception;
  private String path;
  
  public void setHttpStatus(HttpStatus httpStatus) {
    this.httpStatus = httpStatus;
    this.httpStatusCode = httpStatus.value();
  }
}
