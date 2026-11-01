package org.example.app;

import org.example.cardapio.ComBaconExtra;
import org.example.cardapio.ComCheddar;
import org.example.cardapio.ItemCardapio;
import org.example.cardapio.Lanche;
import org.example.pedido.Pedido;

import java.util.Locale;

//Controlar a repetição das escolhas
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

                        if (opcaoLanche != 0) {
                            ItemCardapio item = montarLanche(
                                    mc,
                                    restaurante,
                                    opcaoLanche
                            );

                            if (item != null) {
                                pedido.adicionarItem(item);

                                mc.exibirMensagem(
                                        String.format(
                                                Locale.forLanguageTag("pt-BR"),
                                                "Adicionado: %s - R$ %.2f",
                                                item.getDescricao(),
                                                item.getPreco()
                                        )
                                );
                            } else {
                                mc.exibirMensagem("Opção de lanche inválida!");
                            }
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

                            String status = p.isCancelado() ? "CANCELADO" : "ATIVO";

                            mc.exibirMensagem(
                                    String.format(Locale.forLanguageTag("pt-BR"),
                                            "Pedido #%d - %s - R$ %.2f - %s",
                                            p.getNumero(),
                                            p.getNomeCliente(),
                                            p.calcularTotal(),
                                            status
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

                    mc.exibirMensagem(
                            "Combinações únicas vendidas: "
                                    + restaurante.contarCombinacoesUnicas()
                    );

                    for (String combinacao : restaurante.listarCombinacoesUnicas()) {
                        mc.exibirMensagem("- " + combinacao);
                    }

                    break;

                case 4:
                    int numeroPedido = mc.lerNumeroPedido();

                    boolean cancelado = restaurante.cancelarPedido(numeroPedido);

                    if (cancelado) {
                        mc.exibirMensagem("Pedido cancelado com sucesso!");
                    } else {
                        mc.exibirMensagem("Pedido não encontrado!");
                    }

                    break;

                case 5:
                    int numero = mc.lerNumeroPedido();

                    Pedido pedidoExistente = restaurante.buscarPedido(numero);

                    if (pedidoExistente == null) {
                        mc.exibirMensagem("Pedido não encontrado!");

                    } else if (pedidoExistente.isCancelado()) {
                        mc.exibirMensagem("Não é possível alterar um pedido cancelado!");

                    } else if (pedidoExistente.getItens().isEmpty()) {
                        mc.exibirMensagem("Este pedido não possui itens!");

                    } else {
                        mc.exibirItensPedido(pedidoExistente);

                        int numeroItem = mc.lerItemParaRemover();

                        boolean removido = restaurante.removerItemPedido(
                                numero,
                                numeroItem - 1
                        );

                        if (removido) {
                            mc.exibirMensagem("Item removido com sucesso!");
                        } else {
                            mc.exibirMensagem("Item inválido!");
                        }
                    }

                    break;

                case 6:
                    int numeroPedidoAdicionar = mc.lerNumeroPedido();

                    Pedido pedidoParaAdicionar = restaurante.buscarPedido(numeroPedidoAdicionar);

                    if (pedidoParaAdicionar == null) {
                        mc.exibirMensagem("Pedido não encontrado!");

                    } else if (pedidoParaAdicionar.isCancelado()) {
                        mc.exibirMensagem("Não é possível alterar um pedido cancelado!");

                    } else {
                        int opcaoLancheAdicionar;

                        do {
                            opcaoLancheAdicionar = mc.lerOpcaoLanche();

                            ItemCardapio novoItem = montarLanche(
                                    mc,
                                    restaurante,
                                    opcaoLancheAdicionar
                            );

                            if (novoItem != null) {
                                boolean adicionado = restaurante.adicionarItemPedido(
                                        numeroPedidoAdicionar,
                                        novoItem
                                );

                                if (adicionado) {
                                    mc.exibirMensagem("Item adicionado ao pedido!");
                                }

                            } else if (opcaoLancheAdicionar != 0) {
                                mc.exibirMensagem("Opção de lanche inválida!");
                            }

                        } while (opcaoLancheAdicionar != 0);

                        double totalAdd = pedidoParaAdicionar.calcularTotal();
                        mc.exibirMensagem(
                                String.format(Locale.forLanguageTag("pt-BR"),
                                        "Total do pedido: R$ %.2f", totalAdd)
                        );
                    }

                    break;

                case 0:
                    mc.exibirMensagem("Saindo do sistema...");
                    break;

                default:
                    mc.exibirMensagem("Opção inválida!");
            }
        } while (opcao != 0 && opcao != 3);
    }


    private static ItemCardapio montarLanche(
            MenuConsole mc,
            RestauranteFacade restaurante,
            int opcaoLanche) {

        Lanche lanche = restaurante.escolherLanche(opcaoLanche);

        if (lanche == null) {
            return null;
        }

        int opcaoIngrediente;

        do {
            opcaoIngrediente = mc.lerOpcaoIngrediente();

            if (opcaoIngrediente >= 1 && opcaoIngrediente <= 4) {
                restaurante.removerIngrediente(lanche, opcaoIngrediente);
            } else if (opcaoIngrediente != 0) {
                mc.exibirMensagem("Ingrediente inválido!");
            }

        } while (opcaoIngrediente != 0);

        ItemCardapio itemPersonalizado = lanche;

        int opcaoAdicional;

        do {
            opcaoAdicional = mc.lerOpcaoAdicional();

            if (opcaoAdicional == 1 || opcaoAdicional == 2) {
                itemPersonalizado = restaurante.adicionarExtra(
                        itemPersonalizado, opcaoAdicional
                );
            } else if (opcaoAdicional != 0) {
                mc.exibirMensagem("Adicional inválido!");
            }

        } while (opcaoAdicional != 0);

        return itemPersonalizado;
    }
}
