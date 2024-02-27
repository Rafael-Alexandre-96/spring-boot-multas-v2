package br.com.gestor.multas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestor.multas.models.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
  
}
