/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource.bean;

import java.util.ArrayList;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import resource.model.Conta;
import resource.model.Item;
import resource.model.Usuario;

/**
 *
 * @author Cristiano
 */
@ManagedBean
@ApplicationScoped
public class AplicassaoMB {

    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Item> listaItens;
    private ArrayList<Conta> listaContas;

    /**
     * Creates a new instance of AplicassaoMB
     */
    public AplicassaoMB() {
        listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios.add(new Usuario((new Usuario()).GenerateNewId(), "Cristiano", "01040337031", "clauffer", "123", true));
        listaUsuarios.add(new Usuario((new Usuario()).GenerateNewId(), "Leonardo", "12345678912", "ldutra", "123", false));
        listaUsuarios.add(new Usuario((new Usuario()).GenerateNewId(), "Administrador", "78912345678", "admin", "12345", false));

        listaItens = new ArrayList<Item>();
        listaItens.add(new Item((new Item()).GenerateNewId(), "Suco de laranja", 6.00));
        listaItens.add(new Item((new Item()).GenerateNewId(), "Risólis de carne", 4.00));
        listaItens.add(new Item((new Item()).GenerateNewId(), "Sanduíche natural", 8.00));

        listaContas = new ArrayList<Conta>();
        for (Usuario usuario : listaUsuarios) {
            listaContas.add(new Conta(usuario, "conta-" + usuario.getUsuarioSistema(), 20.00));
        }
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Item> getListaItens() {
        return listaItens;
    }

    public void setListaItens(ArrayList<Item> listaItens) {
        this.listaItens = listaItens;
    }

    public Usuario BuscarUsuario(String usuarioSistema, String senha) {
        Usuario objUsuario = null;

        for (Usuario user : this.listaUsuarios) {
            if (user.getUsuarioSistema().equals(usuarioSistema)) {
                if (user.getSenha().equals(senha)) {
                    objUsuario = user;
                    break;
                } else {
                    return null;
                }
            }
        }

        return objUsuario;
    }

    public Usuario BuscarUsuarioPorCpf(String cpf) {
        Usuario objUsuario = null;

        for (Usuario user : this.listaUsuarios) {
            if (user.getCpf().equals(cpf)) {
                objUsuario = user;
                break;
            }
        }

        return objUsuario;
    }
    
    public Usuario BuscarUsuarioPorId(long id) {
        Usuario objUsuario = null;

        for (Usuario user : this.listaUsuarios) {
            if (user.getId() == id) {
                objUsuario = user;
                break;
            }
        }

        return objUsuario;
    }
    
    public Item BuscarItemPorId(long id) {
        Item objItem = null;

        for (Item item : this.listaItens) {
            if (item.getId() == id) {
                objItem = item;
                break;
            }
        }

        return objItem;
    }

    public Conta BuscarContaPorUsuario(Usuario usuario) {
        Conta objConta = null;

        for (Conta conta : this.listaContas) {
            if (usuario.getId() == conta.getUsuario().getId()) {
                objConta = conta;
                break;
            }
        }

        return objConta;
    }
}
