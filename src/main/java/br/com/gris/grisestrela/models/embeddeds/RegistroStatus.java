package br.com.gris.grisestrela.models.embeddeds;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
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

  @NotNull
  @Column(updatable = false)
  @Setter(AccessLevel.NONE)
  private OffsetDateTime createdAt;

  @Setter(AccessLevel.NONE)
  private OffsetDateTime updatedAt;

  @NotNull
  private Boolean actived = true;

  @PrePersist
  private void prePersist() {
    this.createdAt = OffsetDateTime.now();
    this.updatedAt = null;
  }

  @PreUpdate
  private void preUpdate() {
    this.updatedAt = OffsetDateTime.now();
  }
}
