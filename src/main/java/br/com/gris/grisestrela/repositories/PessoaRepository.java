package br.com.gris.grisestrela.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gris.grisestrela.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
  
}
