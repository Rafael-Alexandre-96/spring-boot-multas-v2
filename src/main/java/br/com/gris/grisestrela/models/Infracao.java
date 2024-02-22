package br.com.gris.grisestrela.models;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gris.grisestrela.models.embeddeds.RegistroStatus;
import br.com.gris.grisestrela.models.enumerations.SituacaoInfracao;
import br.com.gris.grisestrela.models.interfaces.ControlledRegistration;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
public class Infracao implements ControlledRegistration {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private OffsetDateTime dataHora;

  @NotNull
  @Size(min = 3, max = 50)
  private String local;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "id_enquadramento", referencedColumnName = "id")
  private Enquadramento enquadramento;

  @Size(max = 30)
  private String numeroAit;

  @NotNull
  @Enumerated(EnumType.STRING)
  private SituacaoInfracao situacao = SituacaoInfracao.NORMAL;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "id_veiculo", referencedColumnName = "id")
  private Veiculo veiculo;

  @ManyToOne
  @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
  private Pessoa pessoa;

  @NotNull
  private Boolean assinado = false;

  @NotNull
  private Boolean indicado = false;

  private OffsetDateTime prazoIndicacao;

  @Size(min = 0, max = 2)
  @ManyToMany
  @JoinTable(
    name = "infracao_penalidade", 
    joinColumns = @JoinColumn(name = "id_infracao"), 
    inverseJoinColumns = @JoinColumn(name = "id_penalidade")
  )
  List<Penalidade> penalidades = new ArrayList<>();

  @Embedded
  private RegistroStatus registroStatus = new RegistroStatus();

  @Lob
  private String observacao;
  
}
