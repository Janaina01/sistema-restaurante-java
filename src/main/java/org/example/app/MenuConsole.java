package org.example.app;

import org.example.cardapio.ItemCardapio;
import org.example.pedido.Pedido;

import java.util.InputMismatchException;
import java.util.Scanner;

//Exibir adicionais e ler a escolha
public class MenuConsole {

    private Scanner sc = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println("=== RESTAURANTE ===");
        System.out.println("1 - Registrar novo pedido");
        System.out.println("2 - Listar pedidos do dia");
        System.out.println("3 - Fechar restaurante");
        System.out.println("4 - Cancelar pedido");
        System.out.println("5 - Remover item de um pedido");
        System.out.println("6 - Adicionar item a um pedido");
        System.out.println("0 - Sair");
    }

    public int lerOpcao() {
        while (true) {
            try {
                int opcao = sc.nextInt();
                sc.nextLine();
                return opcao;

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número.");
                sc.nextLine();
                }
            }
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

        return lerOpcao();
    }

    public int lerOpcaoAdicional() {
        System.out.println("=== ADICIONAIS ===");
        System.out.println("1 - Cheddar (+ R$ 4,00)");
        System.out.println("2 - Bacon extra (+ R$ 6,00)");
        System.out.println("0 - Finalizar adicionais");

        return lerOpcao();
    }

    public int lerOpcaoIngrediente() {
        System.out.println("=== REMOVER INGREDIENTES ===");
        System.out.println("1 - Remover queijo");
        System.out.println("2 - Remover alface");
        System.out.println("3 - Remover tomate");
        System.out.println("4 - Remover cebola");
        System.out.println("0 - Finalizar personalização");

        return lerOpcao();
    }

    public int lerNumeroPedido() {
        System.out.println("Digite o número do pedido:");
        return lerOpcao();
    }

    public void exibirItensPedido(Pedido pedido) {
        System.out.println("=== ITENS DO PEDIDO ===");

        for (int i = 0; i < pedido.getItens().size(); i++) {
            ItemCardapio item = pedido.getItens().get(i);

            System.out.printf(
                    "%d - %s - R$ %.2f%n",
                    i + 1,
                    item.getDescricao(),
                    item.getPreco()
            );
        }
    }

    public int lerItemParaRemover() {
        System.out.println("Digite o número do item que deseja remover:");
        return lerOpcao();
    }
}
