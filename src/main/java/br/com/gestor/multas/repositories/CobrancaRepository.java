package br.com.gestor.multas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestor.multas.models.Cobranca;

public interface CobrancaRepository extends JpaRepository<Cobranca, Long> {
  
}
