package br.com.gris.grisestrela.models.embeddeds;

import java.time.OffsetDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegistroStatus {

  @CreationTimestamp
  @NotNull
  @Column(updatable = false)
  private OffsetDateTime createdAt;

  @UpdateTimestamp
  private OffsetDateTime updatedAt;

  @NotNull
  private Boolean actived = true;
}
