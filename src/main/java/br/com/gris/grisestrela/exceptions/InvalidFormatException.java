package br.com.gris.grisestrela.exceptions;

public class InvalidFormatException extends RuntimeException {
  
  public InvalidFormatException(String field) {
    super(String.format("O campo %s está no formato incorreto.", field));
  }

}
