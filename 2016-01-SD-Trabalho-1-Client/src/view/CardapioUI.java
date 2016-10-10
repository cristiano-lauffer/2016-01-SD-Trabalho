/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import resource.Item;
import util.Console;
import view.menu.CardapioMenu;

/**
 *
 * @author Cristiano
 */
public class CardapioUI {

    public CardapioUI() {
    }

    public void executar(long idUsuario) {
        int opcao = 0;

        do {
            System.out.println(CardapioMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção:");
            switch (opcao) {
                case CardapioMenu.OP_LISTAR_ITENS:
                    listarItens();
                    break;
                case CardapioMenu.OP_COMPRAR_ITEM:
                    comprarItem(idUsuario);
                    break;
                case CardapioMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != CardapioMenu.OP_VOLTAR);
    }

    private void listarItens() {
        resource.WebResource_Service service = new resource.WebResource_Service();
        resource.WebResource port = service.getWebResourcePort();
        List<Item> listaItens = port.listarItens();
        System.out.println("================");
        System.out.println("Lista de itens: ");
        for (Item item : listaItens) {
            System.out.println(item.getId() + " - " + item.getNome() + "[" + item.getValor() + "]");
        }
        System.out.println("================");
    }

    private void comprarItem(long idUsuario) {
        long idItem = Console.scanInt("Item: ");
        System.out.println("Efetuando compra...");
        resource.WebResource_Service service = new resource.WebResource_Service();
        resource.WebResource port = service.getWebResourcePort();
        String strRetorno = port.comprarItem(idUsuario, idItem);
        System.out.println(strRetorno);
    }
}
