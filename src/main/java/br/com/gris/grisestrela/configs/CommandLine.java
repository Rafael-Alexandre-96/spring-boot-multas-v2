package br.com.gris.grisestrela.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.gris.grisestrela.repositories.BoletoRepository;
import br.com.gris.grisestrela.repositories.CobrancaRepository;
import br.com.gris.grisestrela.repositories.EnquadramentoRepository;
import br.com.gris.grisestrela.repositories.InfracaoRepository;
import br.com.gris.grisestrela.repositories.PenalidadeRepository;
import br.com.gris.grisestrela.repositories.VeiculoRepository;
import br.com.gris.grisestrela.services.EspecieVeiculoService;

@Configuration
public class CommandLine implements CommandLineRunner {

  @Autowired
  EspecieVeiculoService especieVeiculoService;

  @Autowired
  VeiculoRepository veiculoRepository;

  @Autowired
  BoletoRepository boletoRepository;

  @Autowired
  CobrancaRepository cobrancaRepository;

  @Autowired
  PenalidadeRepository penalidadeRepository;

  @Autowired
  EnquadramentoRepository enquadramentoRepository;

  @Autowired
  InfracaoRepository infracaoRepository;

  @Override
  public void run(String... args) {
    System.out.println("EXECUTING : command line runner");
  }
}
