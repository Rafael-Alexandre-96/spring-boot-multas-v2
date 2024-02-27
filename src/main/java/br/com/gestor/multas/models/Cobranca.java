package br.com.gestor.multas.models;

import java.time.OffsetDateTime;

import br.com.gestor.multas.models.interfaces.Entited;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
public class Cobranca implements Entited {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private Float valor = 0F;

  @NotNull
  private Float desconto = 0F;

  @NotNull
  private OffsetDateTime dataVencimento;

  private OffsetDateTime dataPagamento;

  @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
  @JoinColumn(name = "id_boleto", referencedColumnName = "id")
  private Boleto boleto;

  public Float getValorAPagar() {
    return this.valor - this.desconto;
  }
  
}
