/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Desenvolvimento
 */
public class Conta implements Serializable {

    private Usuario usuario;
    private String nome;
    private double saldo;

    public Conta(Usuario usuario, String nome, double saldo) {
        this.usuario = usuario;
        this.nome = nome;
        this.saldo = saldo;
    }

    public Conta() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
