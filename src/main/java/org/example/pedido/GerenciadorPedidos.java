package org.example.pedido;

import org.example.cardapio.ItemCardapio;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class GerenciadorPedidos {
    private HashMap<Integer, Pedido> pedidos = new HashMap<>();
    private int contadorPedidos = 1;

    public Pedido criarPedido(String nomeCliente){

        //Pegando o número do pedido
        Pedido novo = new Pedido(contadorPedidos, nomeCliente);
        pedidos.put(novo.getNumero(), novo);
        contadorPedidos++;
        return novo;
    }

    public Pedido buscarPedido(int numeroIdentificador){
        return pedidos.get(numeroIdentificador);
    }

    //Acessando pedidos
    public Collection<Pedido> getPedidos(){
        return pedidos.values();
    }

    public double calcularTotalDoDia(){
        double total = 0;
        for (Pedido pedido : pedidos.values()){
            if(!pedido.isCancelado()){
                total += pedido.calcularTotal();
            }
        }
        return total;
    }
    public int contarCombinacoesUnicas() {
        return listarCombinacoesUnicas().size();
    }

    public HashSet<String> listarCombinacoesUnicas() {
        HashSet<String> combinacoes = new HashSet<>();

        for (Pedido pedido : pedidos.values()) {
            if (!pedido.isCancelado()) {
                for (ItemCardapio item : pedido.getItens()) {
                    combinacoes.add(item.getDescricao());
                }
            }
        }

        return combinacoes;
    }


}
