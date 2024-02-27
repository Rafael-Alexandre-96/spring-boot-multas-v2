package br.com.gestor.multas.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.gestor.multas.repositories.BoletoRepository;
import br.com.gestor.multas.repositories.CobrancaRepository;
import br.com.gestor.multas.repositories.EnquadramentoRepository;
import br.com.gestor.multas.repositories.InfracaoRepository;
import br.com.gestor.multas.repositories.PenalidadeRepository;
import br.com.gestor.multas.repositories.VeiculoRepository;
import br.com.gestor.multas.services.EspecieVeiculoService;

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
