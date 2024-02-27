package br.com.gestor.multas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestor.multas.models.Penalidade;

public interface PenalidadeRepository extends JpaRepository<Penalidade, Long> {
  
}
