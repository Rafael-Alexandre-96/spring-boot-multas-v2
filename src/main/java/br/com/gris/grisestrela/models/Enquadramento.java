package br.com.gris.grisestrela.models;

import br.com.gris.grisestrela.models.enumerations.Infrator;
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
public class Enquadramento implements Entited {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(min = 6, max = 6)
  @Column(unique = true)
  private String numero;

  @NotBlank
  @Size(min = 5, max = 120)
  private String descricao;

  @Size(max = 20)
  private String baseLegal;

  @NotNull
  @Enumerated(EnumType.STRING)
  private Infrator Infrator;

  @NotNull
  private Integer pontos = 0;

  @NotNull
  private Float valor = 0F;
  
}
