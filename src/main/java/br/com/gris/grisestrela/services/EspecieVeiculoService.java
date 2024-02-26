package br.com.gris.grisestrela.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import br.com.gris.grisestrela.models.EspecieVeiculo;
import br.com.gris.grisestrela.repositories.EspecieVeiculoRepository;
import br.com.gris.grisestrela.services.bases.SimpleCRUDService;
import br.com.gris.grisestrela.services.bases.SimplePageableService;
import jakarta.transaction.Transactional;

@Service
public class EspecieVeiculoService {
  
  private final String entityName = "Veiculo";
  private final SimpleCRUDService<EspecieVeiculo> simpleCrudService;
  private final SimplePageableService<EspecieVeiculo> simplePageableService;

  public EspecieVeiculoService(EspecieVeiculoRepository especieVeiculoRepository) {
    this.simpleCrudService = new SimpleCRUDService<>(especieVeiculoRepository, this.entityName);
    this.simplePageableService = new SimplePageableService<>(especieVeiculoRepository);
  }

  @NonNull
  public EspecieVeiculo findById(@NonNull Long id) {
    return this.simpleCrudService.findById(id);
  }

  public List<EspecieVeiculo> findAll() {
    return this.simpleCrudService.findAll();
  }

  public Page<EspecieVeiculo> findAll(
    @NonNull Direction direction,
    @NonNull String sort
  ) {
    return this.simplePageableService.findAll(0, Integer.MAX_VALUE, direction, sort);
  }

  public Page<EspecieVeiculo> findAll(
    @NonNull Integer pageNumber,
    @NonNull Integer pageSize,
    @NonNull Direction direction,
    @NonNull String sort
  ) {
    return this.simplePageableService.findAll(pageNumber, pageSize, direction, sort);
  }

  public Page<EspecieVeiculo> findBy(
    @NonNull EspecieVeiculo exampleEntity,
    @NonNull Direction direction,
    @NonNull String sort
  ) {
    return this.simplePageableService.findBy(exampleEntity, 0, Integer.MAX_VALUE, direction, sort);
  }

  public Page<EspecieVeiculo> findBy(
    @NonNull EspecieVeiculo exampleEntity,
    @NonNull Integer pageNumber,
    @NonNull Integer pageSize,
    @NonNull Direction direction,
    @NonNull String sort
  ) {
    return this.simplePageableService.findBy(exampleEntity, pageNumber, pageSize, direction, sort);
  }

  @Transactional
  public EspecieVeiculo create(@NonNull EspecieVeiculo entity) {
    return this.simpleCrudService.create(entity);
  }

  @Transactional
  public EspecieVeiculo update(@NonNull Long id, @NonNull EspecieVeiculo entity) {
    return this.simpleCrudService.update(id, entity);
  }

  @Transactional
  public void deleteById(@NonNull Long id) {
    this.simpleCrudService.deleteById(id);
  }
}
