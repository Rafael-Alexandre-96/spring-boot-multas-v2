package br.com.gris.grisestrela.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gris.grisestrela.models.Penalidade;

public interface PenalidadeRepository extends JpaRepository<Penalidade, Long> {
  
}
