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
import resource.model.ItemPedido;
import resource.model.Pedido;
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
     * *
     *
     * @param idUsuario
     * @return List<ItemPedido>
     */
    @WebMethod(operationName = "listar_itens_pedido")
    public List<ItemPedido> getListaItensPedido(
            @WebParam(name = "id_usuario") long idUsuario
    ) {
        return this.AplicassaoMB.BuscarPedido(this.AplicassaoMB.BuscarUsuarioPorId(idUsuario)).getListaItens();
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

    /**
     * Operação de Web service
     *
     * @return String
     */
    @WebMethod(operationName = "incluir_item")
    public String incluirItem(
            @WebParam(name = "id_usuario") long idUsuario,
            @WebParam(name = "id_item") int idItem,
            @WebParam(name = "qtd_item") int qtdItem
    ) {
        String strRetorno = "";

        Usuario usuario = this.AplicassaoMB.BuscarUsuarioPorId(idUsuario);
        Item item = this.AplicassaoMB.BuscarItemPorId(idItem);
        Pedido pedido = this.AplicassaoMB.BuscarPedido(usuario);

        if (item == null) {
            strRetorno = "Item não encontrado. ";
        } else {
            ItemPedido itemAlterar = pedido.buscarItemPedido(idItem);
            if (itemAlterar == null) {
                pedido.getListaItens().add(new ItemPedido(item, qtdItem));
            } else {
                itemAlterar.setQuantidade(qtdItem);
            }
            strRetorno = "Item incluído. ";
        }

        strRetorno += "Total parcial do pedido: [" + pedido.getTotal() + "]";

        return strRetorno;
    }

    /**
     * Operação de Web service
     *
     * @return String
     */
    @WebMethod(operationName = "remover_item")
    public String removerItem(
            @WebParam(name = "id_usuario") long idUsuario,
            @WebParam(name = "indice_item") int indiceItem
    ) {
        String strRetorno = "";

        Usuario usuario = this.AplicassaoMB.BuscarUsuarioPorId(idUsuario);
        Pedido pedido = this.AplicassaoMB.BuscarPedido(usuario);

        ItemPedido itemPedido = pedido.getListaItens().remove(indiceItem);
        if (itemPedido == null) {
            strRetorno = "Não foi possível remover o item! ";
        } else {
            strRetorno = "Item Removido! ";
        }

        strRetorno += "Total parcial do pedido: [" + pedido.getTotal() + "]";

        return strRetorno;
    }

    /**
     * Operação de Web service
     *
     * @return String
     */
    @WebMethod(operationName = "finalizar_pedido")
    public String finalizarPedido(
            @WebParam(name = "id_usuario") long idUsuario
    ) {
        String strRetorno = "";

        Usuario usuario = this.AplicassaoMB.BuscarUsuarioPorId(idUsuario);
        Pedido pedido = this.AplicassaoMB.BuscarPedido(usuario);
        Conta conta = this.AplicassaoMB.BuscarContaPorUsuario(usuario);

        //Verifica se o pedido possui itens
        if (pedido.getListaItens().size() == 0) {
            strRetorno = "Pedido não pode ser finalizado pois não possui itens!";
        } else {
            //verifica se possui saldo suficiente
            if (conta.getSaldo() < pedido.getTotal()) {
                strRetorno = "Saldo Insuficiente. Valor do pedido: "
                        + pedido.getTotal()
                        + " - Saldo da conta: " + conta.getSaldo();
            } else {
                pedido = this.AplicassaoMB.removerPedido(pedido);
                conta.setSaldo(conta.getSaldo() - pedido.getTotal());
                if (pedido != null) {
                    strRetorno = "Pedido finalizado com sucesso!";
                } else {
                    strRetorno = "Não foi possível finalizar o pedido!";
                }
            }
        }

        return strRetorno;
    }

    /**
     * *
     *
     * @param idUsuario
     * @return
     */
    @WebMethod(operationName = "buscar_pedido")
    public Pedido buscarPedido(
            @WebParam(name = "id_usuario") long idUsuario
    ) {
        return this.AplicassaoMB.BuscarPedido(this.AplicassaoMB.BuscarUsuarioPorId(idUsuario));
    }

    /**
     * Operação de Web service
     *
     * @return double
     */
    @WebMethod(operationName = "get_saldo")
    public double getSaldo(
            @WebParam(name = "id_usuario") long idUsuario
    ) {
        return this.AplicassaoMB.getSaldo(idUsuario);
    }
}
