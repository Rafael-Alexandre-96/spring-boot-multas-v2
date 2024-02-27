package br.com.gestor.multas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gestor.multas.models.Enquadramento;

public interface EnquadramentoRepository extends JpaRepository<Enquadramento, Long> {
  
}
