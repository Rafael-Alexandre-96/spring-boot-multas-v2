package br.com.gris.grisestrela.models;

import br.com.gris.grisestrela.models.enumerations.TipoRodado;
import br.com.gris.grisestrela.models.interfaces.Entited;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class EspecieVeiculo implements Entited {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Enumerated(EnumType.STRING)
  private TipoRodado tipoRodado;

  @NotBlank
  @Size(min = 3, max = 50)
  @Column(unique = true)
  private String descricao;

}
