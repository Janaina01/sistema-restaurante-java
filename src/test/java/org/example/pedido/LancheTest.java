package org.example.pedido;

import org.example.cardapio.Lanche;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LancheTest {
    @Test
    void deveRejeitarPrecoNegativo() {
        Lanche lanche = new Lanche("X-Burger", 16.00);

        assertThrows(IllegalArgumentException.class, () -> {
            lanche.setPreco(-5.00);
        });
    }
    @Test
    void deveRejeitarPrecoNegativoNoConstrutor() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Lanche("X-Burger", -5.00);
        });
    }
}
