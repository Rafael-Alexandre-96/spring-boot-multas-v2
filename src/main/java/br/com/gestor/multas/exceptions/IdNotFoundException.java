package br.com.gestor.multas.exceptions;

import br.com.gestor.multas.models.interfaces.Entited;

public class IdNotFoundException extends RuntimeException {

  public IdNotFoundException(Entited entity) {
    super(String.format("Id %s da tabela %s não foi encontrado.", entity.getId(), entity.getClass().toString()));
  }

  public IdNotFoundException(Object object, Long id) {
    super(String.format("Id %s da tabela %s não foi encontrado.", id, object.getClass().toString()));
  }

  public IdNotFoundException(String className, Long id) {
    super(String.format("Id %s da tabela %s não foi encontrado.", id, className));
  }
  
}
