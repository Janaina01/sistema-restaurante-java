package org.example.cardapio;

public class LancheFactory {

    public static Lanche criarXBurger(){
        return new Lanche ("X-Burger", 16.00);
    }

    public static Lanche criarXSalada(){
        return new Lanche ("X-Salada", 18.00);
    }

    public static Lanche criarXBacon(){
        return new Lanche ("X-Bacon", 22.00);
    }
}
