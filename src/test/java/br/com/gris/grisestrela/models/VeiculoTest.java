package br.com.gris.grisestrela.models;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.gris.grisestrela.exceptions.InvalidFormatException;

public class VeiculoTest {
  @Test
  void testSetPlaca() {
    Veiculo veiculo = new Veiculo();
    assertThrows(InvalidFormatException.class, () -> veiculo.setPlaca("ABCEEEE"));
    assertDoesNotThrow(() -> veiculo.setPlaca("ABC1234"));
    assertDoesNotThrow(() -> veiculo.setPlaca("ABC1C34"));
    assertEquals("ABC1C34", veiculo.getPlaca());
  }
}
