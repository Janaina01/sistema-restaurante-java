package org.example.app;

import org.example.cardapio.*;
import org.example.pedido.GerenciadorPedidos;
import org.example.pedido.Pedido;

import java.util.Collection;

//Aplicar o Decorator correspondente
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
                return LancheFactory.criarXBurger();
            case 2:
                return LancheFactory.criarXSalada();
            case 3:
                return LancheFactory.criarXBacon();
            default:
                return null;
        }
    }

    public ItemCardapio adicionarExtra(ItemCardapio item, int opcao){
        switch (opcao) {
            case 1:
                return new ComCheddar(item);

            case 2:
                return new ComBaconExtra(item);

            case 0:
                return item;

            default:
                return item;
        }
    }
    public void removerIngrediente(Lanche lanche, int opcao) {
        switch (opcao) {
            case 1:
                lanche.setQueijo(false);
                break;
                case 2:
                    lanche.setAlface(false);
                    break;
                    case 3:
                        lanche.setTomate(false);
                        break;
                        case 4:
                        lanche.setCebola(false);
                        break;
            case 0:
                break;
                default:
                    break;

        }
    }

    public boolean cancelarPedido(int numero) {
        Pedido pedido = gerenciador.buscarPedido(numero);

        if (pedido == null) {
            return false;
        }

        pedido.cancelar();
        return true;
    }

    public boolean removerItemPedido(int numeroPedido, int indiceItem) {
        Pedido pedido = gerenciador.buscarPedido(numeroPedido);

        if (pedido == null || pedido.isCancelado()) {
            return false;
        }

        return pedido.removerItem(indiceItem);
    }

    public Pedido buscarPedido(int numero) {
        return gerenciador.buscarPedido(numero);
    }

    public boolean adicionarItemPedido(int numeroPedido, ItemCardapio item) {
        Pedido pedido = gerenciador.buscarPedido(numeroPedido);

            //Impede alteração caso o pedido não exista ou esteja cancelado
        if (pedido == null || pedido.isCancelado()) {
            return false;
        }

        pedido.adicionarItem(item);
        return true;
    }
    public int contarCombinacoesUnicas() {
        return gerenciador.contarCombinacoesUnicas();
    }

}