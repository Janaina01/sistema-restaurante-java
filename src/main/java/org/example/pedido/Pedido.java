package org.example.pedido;

import org.example.cardapio.Lanche;

import java.util.ArrayList;

public class Pedido {
    private int numeroIdentificador;
    private String nomeCliente;

    private ArrayList<Lanche> itens = new ArrayList<>();

    //Adiciona o lanche na lista itens
    public void adicionarItem(Lanche lanche){
        itens.add(lanche);
    }

    public Pedido(int numeroIdentificador, String nomeCliente){
        this.numeroIdentificador = numeroIdentificador;
        setNomeCliente(nomeCliente);
    }
    public int getNumero() {
        return numeroIdentificador;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente){
        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        this.nomeCliente = nomeCliente;
    }
    public ArrayList<Lanche> getItens(){
        return itens;
    }

    //Percorre a lista de lanches e soma seus preços
    public double calcularTotal(){
        double total = 0;
        for (Lanche lanche : itens) {
            total += lanche.getPreco();
        }
        return total;
    }
}
