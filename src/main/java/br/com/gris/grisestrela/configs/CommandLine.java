package br.com.gris.grisestrela.configs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.gris.grisestrela.models.EspecieVeiculo;
import br.com.gris.grisestrela.models.Veiculo;
import br.com.gris.grisestrela.models.enumerations.TipoRodado;
import br.com.gris.grisestrela.repositories.EspecieVeiculoRepository;
import br.com.gris.grisestrela.repositories.VeiculoRepository;

@Configuration
public class CommandLine implements CommandLineRunner {

  @Autowired
  EspecieVeiculoRepository especieRepository;

  @Autowired
  VeiculoRepository veiculoRepository;

  @Override
  public void run(String... args) {
    System.out.println("EXECUTING : command line runner");

    this.populateEspecieVeiculo();
  }

  private void populateEspecieVeiculo() {
    List<EspecieVeiculo> especies = new ArrayList<>();
    especies.add(new EspecieVeiculo(null, TipoRodado.UNITARIO, "Passeio"));
    especies.add(new EspecieVeiculo(null, TipoRodado.UNITARIO, "Baú"));
    especies.add(new EspecieVeiculo(null, TipoRodado.UNITARIO, "Truck"));
    especies.add(new EspecieVeiculo(null, TipoRodado.TRACAO, "Cavalo L"));
    especies.add(new EspecieVeiculo(null, TipoRodado.TRACAO, "Cavalo LS"));
    especies.add(new EspecieVeiculo(null, TipoRodado.REBOQUE, "Porta Container 20'"));
    especies.add(new EspecieVeiculo(null, TipoRodado.REBOQUE, "Porta Container 40'"));
    especies.add(new EspecieVeiculo(null, TipoRodado.REBOQUE, "Carreta"));
    especies.add(new EspecieVeiculo(null, TipoRodado.REBOQUE, "Sider"));
    especies.add(new EspecieVeiculo(null, TipoRodado.REBOQUE, "Prancha"));
    especieRepository.saveAll(especies);

    Veiculo veiculo = new Veiculo();
    veiculo.setPlaca("CUA6122");
    veiculo.setEspecie(especies.get(3));
    veiculo = veiculoRepository.save(veiculo);

    veiculo.setPlaca("CUA6422");
    veiculoRepository.save(veiculo);
  }
}
