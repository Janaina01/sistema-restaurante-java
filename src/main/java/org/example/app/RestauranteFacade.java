package org.example.app;

import org.example.cardapio.Lanche;
import org.example.cardapio.LancheFactory;
import org.example.pedido.GerenciadorPedidos;
import org.example.pedido.Pedido;

import java.util.Collection;

public class RestauranteFacade {

    private GerenciadorPedidos gerenciador =  new GerenciadorPedidos();

    //Solicita a criação de pedidos na classe GerenciadorPedidos
    //Registra nova comanda
    public Pedido criarPedido(String nomeCliente){
        return gerenciador.criarPedido(nomeCliente);
    }

    //Obtém o faturamento
    public double calcularTotalDoDia(){
        return gerenciador.calcularTotalDoDia();
    }

    //Devolve os pedidos cadastrados
    public Collection<Pedido> listarPedidos(){
        return gerenciador.getPedidos();
    }

    public Lanche escolherLanche(int opcao){
        switch(opcao) {
            case 1:
                return LancheFactory.criarXBurger();
            case 2:
                return LancheFactory.criarXSalada();
            case 3:
                return LancheFactory.criarXBacon();
            default:
                return null;
        }
    }
}