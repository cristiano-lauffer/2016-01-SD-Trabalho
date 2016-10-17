/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desenvolvimento
 */
public class Pedido implements Serializable {

    private static int idGenerated = 0;
    private int id;
    private Usuario usuario;
    private List<ItemPedido> listaItens;

    public Pedido(Usuario usuario) {
        this.id = GenerateNewId();
        this.usuario = usuario;
        this.listaItens = new ArrayList<ItemPedido>();
    }

    private int GenerateNewId() {
        return ++idGenerated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ItemPedido> getListaItens() {
        return listaItens;
    }

    public void setListaItens(List<ItemPedido> listaItens) {
        this.listaItens = listaItens;
    }

    public double getTotal() {
        double total = 0;

        for (ItemPedido item : listaItens) {
            total += item.getValorTotalItem();
        }

        return total;
    }

    public ItemPedido buscarItemPedido(int idItem) {
        for (ItemPedido itemPedido : this.listaItens) {
            if (itemPedido.getItem().getId() == idItem) {
                return itemPedido;
            }
        }
        return null;
    }

}
