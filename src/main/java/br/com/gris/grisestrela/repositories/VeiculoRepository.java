package br.com.gris.grisestrela.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gris.grisestrela.models.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
  
}
