package br.com.gestor.multas.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import br.com.gestor.multas.models.Veiculo;
import br.com.gestor.multas.repositories.VeiculoRepository;
import br.com.gestor.multas.services.bases.RecordControlService;
import br.com.gestor.multas.services.bases.SimpleCRUDService;
import br.com.gestor.multas.services.bases.SimplePageableService;
import jakarta.transaction.Transactional;

@Service
public class VeiculoService {

  private final String entityName = "Veiculo";
  private final SimpleCRUDService<Veiculo> simpleCrudService;
  private final SimplePageableService<Veiculo> simplePageableService;
  private final RecordControlService<Veiculo> recordControlService;
  private final EspecieVeiculoService especieVeiculoService;

  public VeiculoService(VeiculoRepository VeiculoRepository, EspecieVeiculoService especieVeiculoService) {
    this.simpleCrudService = new SimpleCRUDService<>(VeiculoRepository, this.entityName);
    this.simplePageableService = new SimplePageableService<>(VeiculoRepository);
    this.recordControlService = new RecordControlService<>(VeiculoRepository, this.entityName);
    this.especieVeiculoService = especieVeiculoService;
  }

  public Veiculo findById(@NonNull Long id) {
    return this.simpleCrudService.findById(id);
  }

  public List<Veiculo> findAll() {
    return this.simpleCrudService.findAll();
  }

  public Page<Veiculo> findAll(
    @NonNull Direction direction,
    @NonNull String sort
  ) {
    return this.simplePageableService.findAll(0, Integer.MAX_VALUE, direction, sort);
  }

  public Page<Veiculo> findAll(
    @NonNull Integer pageNumber,
    @NonNull Integer pageSize,
    @NonNull Direction direction,
    @NonNull String sort
  ) {
    return this.simplePageableService.findAll(pageNumber, pageSize, direction, sort);
  }

  public Page<Veiculo> findBy(
    @NonNull Veiculo exampleEntity,
    @NonNull Direction direction,
    @NonNull String sort
  ) {
    return this.simplePageableService.findBy(exampleEntity, 0, Integer.MAX_VALUE, direction, sort);
  }

  public Page<Veiculo> findBy(
    @NonNull Veiculo exampleEntity,
    @NonNull Integer pageNumber,
    @NonNull Integer pageSize,
    @NonNull Direction direction,
    @NonNull String sort
  ) {
    return this.simplePageableService.findBy(exampleEntity, pageNumber, pageSize, direction, sort);
  }

  @SuppressWarnings("null")
  @Transactional
  public Veiculo create(@NonNull Veiculo entity) {
    Veiculo created = this.simpleCrudService.create(entity);
    created.setEspecie(especieVeiculoService.findById(created.getEspecie().getId()));
    return created;
  }

  @Transactional
  public Veiculo update(@NonNull Long id, @NonNull Veiculo entity) {
    return this.simpleCrudService.update(id, entity);
  }

  @Transactional
  public Veiculo activeById(@NonNull Long id) {
    return this.recordControlService.activeById(id);
  }

  @Transactional
  public Veiculo deactiveById(@NonNull Long id) {
    return this.recordControlService.deactiveById(id);
  }
}
