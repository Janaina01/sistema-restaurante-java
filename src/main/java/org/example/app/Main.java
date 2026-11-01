package org.example.app;

import org.example.cardapio.Lanche;
import org.example.pedido.Pedido;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        MenuConsole mc = new MenuConsole();

        RestauranteFacade restaurante = new RestauranteFacade();

        int opcao;

        do {
            mc.exibirMenu();
            opcao = mc.lerOpcao();
            switch (opcao) {
                case 1:

                    //Registrando pedido
                    String nomeCliente = mc.lerNomeCliente();
                    Pedido pedido = restaurante.criarPedido(nomeCliente);

                    mc.exibirMensagem("Pedido #" + pedido.getNumero() + " registrado com sucesso!");

                    int opcaoLanche;
                    do {
                        opcaoLanche = mc.lerOpcaoLanche();

                        Lanche lanche = restaurante.escolherLanche(opcaoLanche);

                        //Valida se cliente informou opção válida
                        if (lanche != null) {
                            pedido.adicionarItem(lanche);
                            mc.exibirMensagem("Lanche adicionado com sucesso!");
                        } else if (opcaoLanche != 0) {
                            mc.exibirMensagem("Opção de lanche inválida!");
                        }
                    } while (opcaoLanche != 0);

                    //Exibe valor do pedido
                    double total = pedido.calcularTotal();
                    mc.exibirMensagem(
                            String.format(Locale.forLanguageTag("pt-BR"),
                                    "Total do pedido: R$ %.2f", total)
                            );

                    break;

                case 2:
                    mc.exibirMensagem("=== PEDIDOS DO DIA ===");

                    if(restaurante.listarPedidos().isEmpty()){
                        mc.exibirMensagem("Nenhum pedido registrado!");
                    } else {
                        for (Pedido p : restaurante.listarPedidos()) {
                            mc.exibirMensagem(
                                    String.format(Locale.forLanguageTag("pt-BR"),
                                            "Pedido #%d - %s - R$ %.2f",
                                            p.getNumero(),
                                            p.getNomeCliente(),
                                            p.calcularTotal()
                                    )
                            );
                        }
                    }
                    break;

                case 3:
                    mc.exibirMensagem("=== FECHAMENTO DO DIA ===");

                    double faturamento = restaurante.calcularTotalDoDia();

                    mc.exibirMensagem(
                            String.format(Locale.forLanguageTag("pt-BR"),
                                    "Faturamento total: R$ %.2f", faturamento)
                    );

                    break;

                case 0:
                    mc.exibirMensagem("Saindo do sistema...");
                    break;

                default:
                    mc.exibirMensagem("Opção inválida!");
            }
        } while (opcao != 0 && opcao != 3);
    }
}
