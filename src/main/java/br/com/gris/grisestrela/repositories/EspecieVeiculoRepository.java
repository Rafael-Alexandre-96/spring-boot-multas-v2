package br.com.gris.grisestrela.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gris.grisestrela.models.EspecieVeiculo;

public interface EspecieVeiculoRepository extends JpaRepository<EspecieVeiculo, Long> {
  
}
