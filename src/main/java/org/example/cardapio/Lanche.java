package org.example.cardapio;

public class Lanche implements ItemCardapio {
    private String nome;
    private double preco;
    private boolean queijo = true;
    private boolean alface = true;
    private boolean tomate = true;
    private boolean cebola = true;

    public Lanche(String nome, double preco) {
        setNome(nome);
        setPreco(preco);
    }

    public String getNome() {
        return nome;
    }

    //Impede não informar valor, texto vazio ou texto contendo apenas espaços
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Por favor, informe um nome.");
        }
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    //Garante que o valor informado não pode ser negativo
    public void setPreco(double preco) {

        if (preco < 0) {
            throw new IllegalArgumentException("Preço inválido.");
        }
        this.preco = preco;
    }
    @Override
    public String getDescricao() {
        String descricao = nome;

        if(!cebola){
            descricao += " sem cebola";
        }
        if(!tomate){
            descricao += " sem tomate";
        }
        if(!alface){
            descricao += " sem alface";
        }
        if(!queijo){
            descricao += " sem queijo";
        }
        return descricao;
    }

    public void setQueijo(boolean queijo) {
        this.queijo = queijo;
    }

    public void  setAlface(boolean alface) {
        this.alface = alface;
    }

    public void  setTomate(boolean tomate) {
        this.tomate = tomate;
    }

    public void  setCebola(boolean cebola) {
        this.cebola = cebola;
    }
}
