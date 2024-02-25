package br.com.gris.grisestrela.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gris.grisestrela.models.Infracao;

public interface InfracaoRepository extends JpaRepository<Infracao, Long> {
  
}
