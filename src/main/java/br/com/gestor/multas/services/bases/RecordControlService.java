package br.com.gestor.multas.services.bases;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import br.com.gestor.multas.exceptions.IdNotFoundException;
import br.com.gestor.multas.exceptions.InvalidSaveDataException;
import br.com.gestor.multas.models.interfaces.ControlledRegistration;
import jakarta.transaction.Transactional;

public class RecordControlService<Entity> {
  
  private final JpaRepository<Entity, Long> repository;
  private final String entityName;

  public RecordControlService(JpaRepository<Entity, Long> repository, String entityName) {
    this.repository = repository;
    this.entityName = entityName;
  }
  
  @Transactional
  public Entity activeById(@NonNull Long id) {
    Entity entity = this.repository.findById(id).orElseThrow(() -> new IdNotFoundException(entityName, id));
    if (((ControlledRegistration) entity).getRegistroStatus().getActived())
      throw new InvalidSaveDataException("O registro já está ativado.");
    ((ControlledRegistration) entity).getRegistroStatus().setActived(true);
    return entity;
  }

  @Transactional
  public Entity deactiveById(@NonNull Long id) {
    Entity entity = this.repository.findById(id).orElseThrow(() -> new IdNotFoundException(entityName, id));
    if (!((ControlledRegistration) entity).getRegistroStatus().getActived())
      throw new InvalidSaveDataException("O registro já está desativado.");
    ((ControlledRegistration) entity).getRegistroStatus().setActived(false);
    return entity;
  }
}
