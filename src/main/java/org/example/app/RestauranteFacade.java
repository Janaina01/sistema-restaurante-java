package org.example.app;

import org.example.cardapio.Lanche;
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
                return new Lanche("X-Burger", 16.00);
            case 2:
                return new Lanche("X-Salada", 18.00);
            case 3:
                return new Lanche("X-Bacon", 22.00);
            default:
                return null;
        }
    }
}