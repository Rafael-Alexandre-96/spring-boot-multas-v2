package br.com.gestor.multas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestor.multas.models.EspecieVeiculo;
import br.com.gestor.multas.services.EspecieVeiculoService;


@RestController
@RequestMapping("/api/v1/EspecieVeiculo")
public class EspecieVeiculoController {
  
  @Autowired
  private EspecieVeiculoService service;
  private static final String DEFAULT_SORT = "descricao";

  @GetMapping("/{id}")
  public ResponseEntity<EspecieVeiculo> findById(@PathVariable @NonNull Long id) {
    return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
  }

  @GetMapping
  public Page<EspecieVeiculo> findAll(
    @RequestParam(defaultValue = "0") @NonNull Integer pageNumber,
    @RequestParam(defaultValue = "0") @NonNull Integer pageSize,
    @RequestParam(defaultValue = "asc") @NonNull String direction,
    @RequestParam(defaultValue = DEFAULT_SORT) @NonNull String sort
  ) {
    Direction thisDirection = direction.toLowerCase().equals("desc") ? Direction.DESC : Direction.ASC;

    if (pageSize == 0)
      return service.findAll(thisDirection, sort);
    else
      return service.findAll(pageNumber, pageSize, thisDirection, sort);
  }

  @GetMapping("/query")
  public Page<EspecieVeiculo> findBy(
    @RequestBody @NonNull EspecieVeiculo exampleEntity,
    @RequestParam(defaultValue = "0") @NonNull Integer pageNumber,
    @RequestParam(defaultValue = "0") @NonNull Integer pageSize,
    @RequestParam(defaultValue = "asc") @NonNull String direction,
    @RequestParam(defaultValue = DEFAULT_SORT) @NonNull String sort
  ) {
    Direction thisDirection = direction.toLowerCase().equals("desc") ? Direction.DESC : Direction.ASC;

    if (pageSize == 0)
      return service.findBy(exampleEntity, thisDirection, sort);
    else
      return service.findBy(exampleEntity, pageNumber, pageSize, thisDirection, sort);
  }

  @PostMapping
  public ResponseEntity<EspecieVeiculo> create(@RequestBody @NonNull EspecieVeiculo especieVeiculo) {
    return new ResponseEntity<>(service.create(especieVeiculo), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<EspecieVeiculo> update(@PathVariable @NonNull Long id, @RequestBody @NonNull EspecieVeiculo especieVeiculo) {
    return new ResponseEntity<>(service.update(id, especieVeiculo), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable @NonNull Long id) {
    service.deleteById(id);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }
}
