package br.com.gris.grisestrela.models;

import java.time.OffsetDateTime;

import br.com.gris.grisestrela.models.enumerations.TipoPenalidade;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
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
public class Penalidade {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Enumerated(EnumType.STRING)
  private TipoPenalidade tipo = TipoPenalidade.NORMAL;

  @NotNull
  @OneToOne
  @JoinColumn(name = "id_cobranca", referencedColumnName = "id")
  private Cobranca cobranca;

  @NotNull
  private OffsetDateTime dataRecebimento = OffsetDateTime.now();

  private OffsetDateTime dataEnvio;
  
}
