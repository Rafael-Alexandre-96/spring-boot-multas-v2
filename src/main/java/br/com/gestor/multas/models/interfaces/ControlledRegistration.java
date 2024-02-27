package br.com.gestor.multas.models.interfaces;

import br.com.gestor.multas.models.embeddeds.RegistroStatus;

public interface ControlledRegistration {

  void setRegistroStatus(RegistroStatus registroStatus);
  RegistroStatus getRegistroStatus();

}
