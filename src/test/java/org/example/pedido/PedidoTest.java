package org.example.pedido;

import org.example.cardapio.Lanche;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PedidoTest {
    private Pedido pedido;

    @BeforeEach
    void criarObjeto() {
        pedido = new Pedido(1, "Maria");
    }

    @Test
    void deveCalcularTotalDoPedido(){

        Lanche burger = new Lanche("X-Burger", 16.00);
        Lanche salada = new Lanche("X-Salada", 18.00);

        pedido.adicionarItem(burger);
        pedido.adicionarItem(salada);

        assertEquals(34.00, pedido.calcularTotal());
    }

    @Test
    void deveRetornarZeroQuandoPedidoEstiverVazio(){

        assertEquals(0.0, pedido.calcularTotal());

    }

    @Test
    void deveAdicionarLancheAoPedido() {
        Lanche burger = new Lanche("X-Burger", 16.00);

        pedido.adicionarItem(burger);

        // Verificar se existe exatamente 1 item
        assertEquals(1, pedido.getItens().size());
    }

    @Test
    void deveAdicionarMultiplosLanches() {

        Lanche burger = new Lanche("X-Burger", 16.00);
        Lanche salada = new Lanche("X-Salada", 18.00);

        pedido.adicionarItem(burger);
        pedido.adicionarItem(salada);

        // Verificar a quantidade de itens
        assertEquals(2, pedido.getItens().size());
    }

    @Test
    void deveRemoverItemEAtualizarTotal() {
        Lanche burger = new Lanche("X-Burger", 16.00);
        Lanche salada = new Lanche("X-Bacon", 22.00);

        pedido.adicionarItem(burger);
        pedido.adicionarItem(salada);

        assertTrue(pedido.removerItem(0));

        assertEquals(22.00, pedido.calcularTotal());

    }


}
