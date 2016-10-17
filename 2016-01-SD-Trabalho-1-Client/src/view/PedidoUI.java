/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import resource.Item;
import resource.ItemPedido;
import resource.Pedido;
import util.Console;
import view.menu.PedidoMenu;

/**
 *
 * @author Cristiano
 */
public class PedidoUI {

    public PedidoUI() {
    }

    public void executar(long idUsuario) {
        int opcao = 0;

        do {
            System.out.println(PedidoMenu.getOpcoes());
            this.exibirSaldo(idUsuario);
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case PedidoMenu.OP_LISTAR_ITENS:
                    exibirCardapio();
                    break;
                case PedidoMenu.OP_INCLUIR_ITEM:
                    incluirItem(idUsuario);
                    break;
                case PedidoMenu.OP_REMOVER_ITEM:
                    removerItem(idUsuario);
                    break;
                case PedidoMenu.OP_LISTAR_PEDIDO:
                    listarItensPedido(idUsuario);
                    break;
                case PedidoMenu.OP_FINALIZAR_PEDIDO:
                    finalizarPedido(idUsuario);
                    break;
                case PedidoMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != PedidoMenu.OP_VOLTAR);
    }

    private void exibirCardapio() {
        resource.WebResource_Service service = new resource.WebResource_Service();
        resource.WebResource port = service.getWebResourcePort();
        List<Item> listaItens = port.listarItens();
        System.out.println("================");
        System.out.println("Cardápio: ");
        for (Item item : listaItens) {
            System.out.println(item.getId() + " - " + item.getNome() + "[" + item.getValor() + "]");
        }
        System.out.println("================");
    }

    private void listarItensPedido(long idUsuario) {
        resource.WebResource_Service service = new resource.WebResource_Service();
        resource.WebResource port = service.getWebResourcePort();
        Pedido pedido = port.buscarPedido(idUsuario);
        System.out.println("================");
        System.out.println("Pedido: " + pedido.getId());
        double valorTotalPedido = 0;
        System.out.println(String.format("%-30s", "ITEM") + "\t"
                + String.format("%-30s", "|Codigo") + "\t"
                + String.format("%-30s", "|Item") + "\t"
                + String.format("%-30s", "|Quantidade") + "\t"
                + String.format("%-30s", "|Preço") + "\t"
                + String.format("%-30s", "|Total"));
        int indice = 0;
        for (ItemPedido itemPedido : pedido.getListaItens()) {
            valorTotalPedido += (itemPedido.getItem().getValor() * itemPedido.getQuantidade());
            System.out.println(String.format("%-30s", indice) + "\t"
                    + String.format("%-30s", "|" + itemPedido.getItem().getId()) + "\t"
                    + String.format("%-30s", "|" + itemPedido.getItem().getNome()) + "\t"
                    + String.format("%-30s", "|" + itemPedido.getQuantidade()) + "\t"
                    + String.format("%-30s", "|" + itemPedido.getItem().getValor()) + "\t"
                    + String.format("%-30s", "|" + (itemPedido.getItem().getValor() * itemPedido.getQuantidade())));
            indice++;
        }
        System.out.println("================");
        System.out.println("Total pedido: " + valorTotalPedido);
        System.out.println("================");
    }

    private void incluirItem(long idUsuario) {
        this.exibirCardapio();
        int idItem = Console.scanInt("Item: ");
        int quantidade = Console.scanInt("Quantidade do item: ");
        if (quantidade <= 0) {
            System.out.println("A quantidade deve ser maior zero!");
        } else {
            System.out.println("Incluindo Item...");
            resource.WebResource_Service service = new resource.WebResource_Service();
            resource.WebResource port = service.getWebResourcePort();
            String strRetorno = port.incluirItem(idUsuario, idItem, quantidade);
            System.out.println(strRetorno);
        }
    }

    private void removerItem(long idUsuario) {
        this.listarItensPedido(idUsuario);

        int indiceItem = Console.scanInt("Item a ser removido: ");
        System.out.println("Removendo Item...");
        resource.WebResource_Service service = new resource.WebResource_Service();
        resource.WebResource port = service.getWebResourcePort();
        String strRetorno = port.removerItem(idUsuario, indiceItem);
        System.out.println(strRetorno);
    }

    private void exibirSaldo(long idUsuario) {
        double dblSaldo = 0;
        resource.WebResource_Service service = new resource.WebResource_Service();
        resource.WebResource port = service.getWebResourcePort();
        dblSaldo = port.getSaldo(idUsuario);
        System.out.println("Saldo [" + dblSaldo + "]");
        System.out.println("--------------------------------------");
    }

    private void finalizarPedido(long idUsuario) {
        this.listarItensPedido(idUsuario);
        String opcao = Console.scanString("Finalizar pedido? (S/N): ");
        if (opcao.trim().toUpperCase().equals("S")) {
            resource.WebResource_Service service = new resource.WebResource_Service();
            resource.WebResource port = service.getWebResourcePort();
            String strRetorno = port.finalizarPedido(idUsuario);
            System.out.println(strRetorno);
        }
    }
}
