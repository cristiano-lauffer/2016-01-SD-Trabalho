/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import resource.bean.AplicassaoMB;
import resource.model.Conta;
import resource.model.Item;
import resource.model.Usuario;

/**
 *
 * @author Desenvolvimento
 */
@WebService(serviceName = "WebResource")
public class WebResource {

    private AplicassaoMB AplicassaoMB;

    public WebResource() {
        this.AplicassaoMB = new AplicassaoMB();
    }

    /**
     * Operação de Web service
     *
     * @return ArrayList<Usuario>
     */
    @WebMethod(operationName = "listar_usuarios")
    public List<Usuario> getListaUsuarios() {
        return this.AplicassaoMB.getListaUsuarios();
    }

    /**
     *
     * @param usuarioSistema
     * @param senha
     * @return
     */
    @WebMethod(operationName = "buscar_usuario")
    public Usuario BuscarUsuario(
            @WebParam(name = "usuario_sistema") String usuarioSistema,
            @WebParam(name = "senha") String senha
    ) {
        return this.AplicassaoMB.BuscarUsuario(usuarioSistema, senha);
    }

    /**
     * Operação de Web service
     *
     * @return ArrayList<Item>
     */
    @WebMethod(operationName = "listar_itens")
    public List<Item> getListaItens() {
        return this.AplicassaoMB.getListaItens();
    }

    /**
     * Operação de Web service
     *
     * @return String
     */
    @WebMethod(operationName = "comprar_item")
    public String comprarItem(
            @WebParam(name = "id_usuario") long idUsuario,
            @WebParam(name = "id_item") long idItem
    ) {
        String strRetorno = "Saldo Insuficiente. ";

        Usuario usuario = this.AplicassaoMB.BuscarUsuarioPorId(idUsuario);
        Item item = this.AplicassaoMB.BuscarItemPorId(idItem);
        Conta conta = this.AplicassaoMB.BuscarContaPorUsuario(usuario);

        if (item == null) {
            strRetorno = "Item não encontrado. ";
        } else {
            if (item.getValor() <= conta.getSaldo()) {
                conta.setSaldo(conta.getSaldo() - item.getValor());
                strRetorno = "Compra efetuada. ";
            }
        }

        strRetorno += "Saldo: [" + conta.getSaldo() + "]";

        return strRetorno;
    }
}
