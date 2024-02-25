package br.com.gris.grisestrela.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gris.grisestrela.models.Boleto;

public interface BoletoRepository extends JpaRepository<Boleto, Long> {
  
}
