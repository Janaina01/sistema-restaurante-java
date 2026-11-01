package org.example.app;

import java.util.Scanner;

public class MenuConsole {

    private Scanner sc = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println("=== RESTAURANTE ===");
        System.out.println("1 - Registrar novo pedido");
        System.out.println("2 - Listar pedidos do dia");
        System.out.println("3 - Fechar restaurante");
        System.out.println("0 - Sair");
    }

    public int lerOpcao() {
        int opcao = sc.nextInt();
        sc.nextLine();
        return opcao;
    }

    public String lerNomeCliente() {
        System.out.println("Digite o nome do cliente: ");;
        return sc.nextLine();
    }
    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public int lerOpcaoLanche(){
        System.out.println("1 - X-Burger - R$ 16,00");
        System.out.println("2 - X-Salada - R$ 18,00");
        System.out.println("3 - X-Bacon - R$ 22,00");
        System.out.println("0 - Finalizar pedido");

        int opcaoLanche = sc.nextInt();
        sc.nextLine();

        return opcaoLanche;
    }
}
