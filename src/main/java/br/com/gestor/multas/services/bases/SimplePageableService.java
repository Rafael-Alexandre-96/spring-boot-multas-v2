package br.com.gestor.multas.services.bases;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

public class SimplePageableService<Entity> {
  
  private final JpaRepository<Entity, Long> repository;

  public SimplePageableService(JpaRepository<Entity, Long> repository) {
    this.repository = repository;
  }
  
  public Page<Entity> findAll(
    @NonNull Integer pageNumber,
    @NonNull Integer pageSize,
    @NonNull Direction direction,
    @NonNull String sort
  ) {
    PageRequest pageable = PageRequest.of(pageNumber, pageSize, direction, sort);
    return this.repository.findAll(pageable);
  }

  public Page<Entity> findBy(
    @NonNull Entity exampleEntity,
    @NonNull Integer pageNumber,
    @NonNull Integer pageSize,
    @NonNull Direction direction,
    @NonNull String sort
  ) {
    PageRequest pageable = PageRequest.of(pageNumber, pageSize, direction, sort);
    return this.repository.findAll(Example.of(exampleEntity, ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)), pageable);
  }
}
