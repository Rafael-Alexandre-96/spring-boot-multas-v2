package br.com.gris.grisestrela.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gris.grisestrela.models.Enquadramento;

public interface EnquadramentoRepository extends JpaRepository<Enquadramento, Long> {
  
}
