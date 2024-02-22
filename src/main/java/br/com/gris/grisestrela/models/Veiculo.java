package br.com.gris.grisestrela.models;

import br.com.gris.grisestrela.exceptions.InvalidFormatException;
import br.com.gris.grisestrela.models.embeddeds.RegistroStatus;
import br.com.gris.grisestrela.models.interfaces.ControlledRegistration;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Veiculo implements ControlledRegistration {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(min = 7, max = 7)
  @Column(unique = true)
  private String placa;

  @Size(max = 50)
  private String frota;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "id_especie_veiculo", referencedColumnName = "id")
  private EspecieVeiculo especie;

  @Embedded
  private RegistroStatus registroStatus = new RegistroStatus();

  @Lob
  private String observacao;
  
  public void setPlaca(String placa) {
    if (placa == null || !placa.matches("[A-Z]{3}[0-9]{1}[A-Z]{1}[0-9]{2}|[A-Z]{3}[0-9]{4}")) {
      throw new InvalidFormatException("placa");
    } else {
      this.placa = placa;
    }
  }

}
