package br.com.gestor.multas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestor.multas.models.Boleto;

public interface BoletoRepository extends JpaRepository<Boleto, Long> {
  
}
