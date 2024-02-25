package br.com.gris.grisestrela.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gris.grisestrela.models.Cobranca;

public interface CobrancaRepository extends JpaRepository<Cobranca, Long> {
  
}
