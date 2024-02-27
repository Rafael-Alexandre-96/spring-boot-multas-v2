package br.com.gestor.multas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestor.multas.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
  
}
