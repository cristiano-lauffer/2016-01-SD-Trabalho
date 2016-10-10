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
public class CardapioMenu {

    public static final int OP_LISTAR_ITENS = 1;
    public static final int OP_COMPRAR_ITEM = 2;
    public static final int OP_VOLTAR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + OP_LISTAR_ITENS + "- Exibir cardápio\n"
                + OP_COMPRAR_ITEM + "- Comprar item\n"
                + OP_VOLTAR + "- Voltar"
                + "\n--------------------------------------");
    }
}
