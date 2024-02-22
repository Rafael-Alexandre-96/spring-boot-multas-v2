package br.com.gris.grisestrela.models;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.gris.grisestrela.exceptions.InvalidFormatException;

public class PessoaTest {
  @Test
  void testSetCpf() {
    Pessoa pessoa = new Pessoa();
    assertThrows(InvalidFormatException.class, () -> pessoa.setCpf("1234567890A"));
    assertDoesNotThrow(() -> pessoa.setCpf("12345678901"));
    assertEquals("12345678901", pessoa.getCpf());
  }
}
