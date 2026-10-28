package org.example.cardapio;

public class Lanche {
    private String nome;
    private double preco;

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
}
