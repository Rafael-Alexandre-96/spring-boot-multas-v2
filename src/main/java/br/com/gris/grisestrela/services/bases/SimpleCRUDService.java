package br.com.gris.grisestrela.services.bases;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import br.com.gris.grisestrela.exceptions.IdNotFoundException;
import br.com.gris.grisestrela.models.interfaces.ControlledRegistration;
import br.com.gris.grisestrela.models.interfaces.Entited;
import jakarta.transaction.Transactional;

public class SimpleCRUDService<Entity> {
  
  private final JpaRepository<Entity, Long> repository;
  private final String entityName;

  public SimpleCRUDService(JpaRepository<Entity, Long> repository, String entityName) {
    this.repository = repository;
    this.entityName = entityName;
  }
  
  @SuppressWarnings("null")
  @NonNull
  public Entity findById(@NonNull Long id) {
    return this.repository.findById(id).orElseThrow(() -> new IdNotFoundException(entityName, id));
  }

  public List<Entity> findAll() {
    return this.repository.findAll();
  }

  @Transactional
  public Entity create(@NonNull Entity entity) {
    return this.repository.save(entity);
  }

  @Transactional
  public Entity update(@NonNull Long id, @NonNull Entity entity) {
    Entity finded = this.findById(id);
    ((Entited) entity).setId(((Entited) finded).getId());
    if (entity instanceof ControlledRegistration)
      ((ControlledRegistration) entity).setRegistroStatus(((ControlledRegistration) finded).getRegistroStatus());
    return this.repository.save(entity);
  } 

  @Transactional
  public void deleteById(@NonNull Long id) {
    Entity entity = this.findById(id);
    this.repository.delete(entity);
  }

}
