package org.example.pedido;

import org.example.cardapio.ComCheddar;
import org.example.cardapio.ItemCardapio;
import org.example.cardapio.Lanche;
import org.example.cardapio.LancheFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GerenciadorPedidosTest {
    private GerenciadorPedidos gerenciador;

    @BeforeEach
    void preparar() {
        gerenciador = new GerenciadorPedidos();
    }

    @Test
    void deveGerarNumerosDiferentesParaPedidos() {

        Pedido pedido1 = gerenciador.criarPedido("Maria");
        Pedido pedido2 = gerenciador.criarPedido("João");

        assertEquals(1, pedido1.getNumero());
        assertEquals(2, pedido2.getNumero());
    }

    @Test
    void deveBuscarPedidoPeloNumero() {

        Pedido pedidoCriado = gerenciador.criarPedido("Maria");

        Pedido pedidoEncontrado = gerenciador.buscarPedido(1);

        // Verificar se encontramos o pedido correto
        assertSame(pedidoCriado, pedidoEncontrado);
    }
    @Test
    void deveRetornarNullParaPedidoInexistente() {

        Pedido pedidoEncontrado = gerenciador.buscarPedido(99);

        assertNull(pedidoEncontrado);
    }

    @Test
    void deveCalcularFaturamentoDoDia() {

        Pedido maria = gerenciador.criarPedido("Maria");
        Pedido joao = gerenciador.criarPedido("João");

        maria.adicionarItem(new Lanche("X-Burger", 16.00));
        joao.adicionarItem(new Lanche("X-Bacon", 22.00));

        // Verificar o faturamento total
        assertEquals(38.00, gerenciador.calcularTotalDoDia());
    }
    @Test
    void deveRetornarZeroQuandoNaoExistiremPedidos() {
        assertEquals(0.0, gerenciador.calcularTotalDoDia());

    }

    @Test
    void deveIgnorarPedidosCanceladosNoFaturamento() {

        Pedido maria = gerenciador.criarPedido("Maria");
        Pedido joao = gerenciador.criarPedido("João");

        maria.adicionarItem(new Lanche("X-Burger", 16.00));
        joao.adicionarItem(new Lanche("X-Bacon", 22.00));

        joao.cancelar();

        assertEquals(16.0, gerenciador.calcularTotalDoDia());
        assertTrue(joao.isCancelado());
    }

    @Test
    void deveContarCombinacoesUnicas() {
        Pedido maria = gerenciador.criarPedido("Maria");
        Pedido joao = gerenciador.criarPedido("João");

        maria.adicionarItem(new Lanche("X-Burger", 16.00));
        joao.adicionarItem(new Lanche("X-Burger", 16.00));

        ItemCardapio lancheComCheddar =
                new ComCheddar(LancheFactory.criarXBurger());

        joao.adicionarItem(lancheComCheddar);

        assertEquals(2, gerenciador.contarCombinacoesUnicas());

        joao.cancelar();

        assertEquals(1, gerenciador.contarCombinacoesUnicas());

    }

}
