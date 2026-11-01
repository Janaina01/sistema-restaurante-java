package org.example.pedido;

import org.example.cardapio.ComBaconExtra;
import org.example.cardapio.ComCheddar;
import org.example.cardapio.ItemCardapio;
import org.example.cardapio.LancheFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComBaconExtraTest {
    @Test
    void deveSomarPrecoDosAdicionais() {
        ItemCardapio lanche = LancheFactory.criarXBurger();

        ItemCardapio comCheddar = new ComCheddar(lanche);

        ItemCardapio completo = new ComBaconExtra(comCheddar);

        assertEquals(26.00, completo.getPreco(), 0.001);

        assertEquals(
                "X-Burger + cheddar + bacon extra",
                completo.getDescricao()
        );

    }
}
