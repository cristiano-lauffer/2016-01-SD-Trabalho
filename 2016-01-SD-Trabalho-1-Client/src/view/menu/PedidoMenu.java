/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.menu;

/**
 *
 * @author Cristiano
 */
public class PedidoMenu {

    public static final int OP_LISTAR_ITENS = 1;
    public static final int OP_INCLUIR_ITEM = 2;
    public static final int OP_REMOVER_ITEM = 3;
    public static final int OP_LISTAR_PEDIDO = 4;
    public static final int OP_FINALIZAR_PEDIDO = 5;
    public static final int OP_VOLTAR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + OP_LISTAR_ITENS + "- Exibir cadápio\n"
                + OP_INCLUIR_ITEM + "- Incluir item\n"
                + OP_REMOVER_ITEM + "- Remover item\n"
                + OP_LISTAR_PEDIDO + "- Listar itens do pedido\n"
                + OP_FINALIZAR_PEDIDO + "- Finalizar pedido\n"
                + OP_VOLTAR + "- Voltar"
                + "\n--------------------------------------");
    }
}
