package br.com.gestor.multas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestor.multas.models.EspecieVeiculo;

public interface EspecieVeiculoRepository extends JpaRepository<EspecieVeiculo, Long> {
  
}
