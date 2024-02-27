package br.com.gestor.multas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestor.multas.models.Veiculo;
import br.com.gestor.multas.services.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Veiculo", description = "Endpoints para veiculo")
@RestController
@RequestMapping("/api/v1/Veiculo")
public class VeiculoController {
  
  @Autowired
  private VeiculoService service;
  private static final String DEFAULT_SORT = "placa";

  @Operation(summary = "Retorna um veiculo pelo ID")
  @ApiResponses(value = { 
  @ApiResponse(responseCode = "200", description = "Veiculo encontrado", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Veiculo.class)) }),
  @ApiResponse(responseCode = "404", description = "Veiculo não existe", content = @Content) })
  @GetMapping("/{id}")
  public ResponseEntity<Veiculo> findById(
    @Parameter(description = "ID do veiculo a ser procurado") @PathVariable @NonNull Long id
  ) {
    return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
  }

  @GetMapping
  public Page<Veiculo> findAll(
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
  public Page<Veiculo> findBy(
    @RequestBody @NonNull Veiculo exampleEntity,
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
  public ResponseEntity<Veiculo> create(@RequestBody @NonNull Veiculo Veiculo) {
    return new ResponseEntity<>(service.create(Veiculo), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Veiculo> update(@PathVariable @NonNull Long id, @RequestBody @NonNull Veiculo Veiculo) {
    return new ResponseEntity<>(service.update(id, Veiculo), HttpStatus.OK);
  }

  @PatchMapping("/{id}/active")
  public ResponseEntity<Veiculo> activeById(@PathVariable @NonNull Long id) {
    return new ResponseEntity<Veiculo>(service.activeById(id), HttpStatus.OK); 
  }

  @PatchMapping("/{id}/deactive")
  public ResponseEntity<Veiculo> deactiveById(@PathVariable @NonNull Long id) {
    return new ResponseEntity<Veiculo>(service.deactiveById(id), HttpStatus.OK); 
  }
}
