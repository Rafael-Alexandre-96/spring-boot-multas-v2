package br.com.gestor.multas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestor.multas.models.Infracao;

public interface InfracaoRepository extends JpaRepository<Infracao, Long> {
  
}
