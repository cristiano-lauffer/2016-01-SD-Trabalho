/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource.model;

import java.io.Serializable;

/**
 *
 * @author Cristiano
 */
public class ItemPedido implements Serializable {

    private Item item;
    private int quantidade;

    public ItemPedido(Item item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    }

    public ItemPedido() {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotalItem() {
        return this.item.getValor() * quantidade;
    }

    @Override
    public String toString() {
        return this.item.getNome() + " - " + quantidade;
    }
}
