package br.com.gris.grisestrela.models.interfaces;

import br.com.gris.grisestrela.models.embeddeds.RegistroStatus;

public interface ControlledRegistration {

  void setRegistroStatus(RegistroStatus registroStatus);
  RegistroStatus getRegistroStatus();

}
