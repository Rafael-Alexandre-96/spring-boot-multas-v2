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
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
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
public class Pessoa implements ControlledRegistration {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(min = 3, max = 75)
  @Column(unique = true)
  private String nome;

  @NotBlank
  @Size(min = 11, max = 11)
  @Column(unique = true)
  private String cpf;

  @Embedded
  private RegistroStatus registroStatus = new RegistroStatus();

  @Lob
  private String observacao;

  public void setCpf(String cpf) {
    if (cpf == null || !cpf.matches("[0-9]{11}")) {
      throw new InvalidFormatException("cpf");
    } else {
      this.cpf = cpf;
    }
  }
  
}