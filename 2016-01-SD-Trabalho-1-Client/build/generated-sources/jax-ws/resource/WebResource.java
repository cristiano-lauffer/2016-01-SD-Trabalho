
package resource;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WebResource", targetNamespace = "http://resource/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WebResource {


    /**
     * 
     * @return
     *     returns java.util.List<resource.Item>
     */
    @WebMethod(operationName = "listar_itens")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listar_itens", targetNamespace = "http://resource/", className = "resource.ListarItens")
    @ResponseWrapper(localName = "listar_itensResponse", targetNamespace = "http://resource/", className = "resource.ListarItensResponse")
    @Action(input = "http://resource/WebResource/listar_itensRequest", output = "http://resource/WebResource/listar_itensResponse")
    public List<Item> listarItens();

    /**
     * 
     * @param idUsuario
     * @param idItem
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "comprar_item")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "comprar_item", targetNamespace = "http://resource/", className = "resource.ComprarItem")
    @ResponseWrapper(localName = "comprar_itemResponse", targetNamespace = "http://resource/", className = "resource.ComprarItemResponse")
    @Action(input = "http://resource/WebResource/comprar_itemRequest", output = "http://resource/WebResource/comprar_itemResponse")
    public String comprarItem(
        @WebParam(name = "id_usuario", targetNamespace = "")
        long idUsuario,
        @WebParam(name = "id_item", targetNamespace = "")
        long idItem);

    /**
     * 
     * @return
     *     returns java.util.List<resource.Usuario>
     */
    @WebMethod(operationName = "listar_usuarios")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listar_usuarios", targetNamespace = "http://resource/", className = "resource.ListarUsuarios")
    @ResponseWrapper(localName = "listar_usuariosResponse", targetNamespace = "http://resource/", className = "resource.ListarUsuariosResponse")
    @Action(input = "http://resource/WebResource/listar_usuariosRequest", output = "http://resource/WebResource/listar_usuariosResponse")
    public List<Usuario> listarUsuarios();

    /**
     * 
     * @param senha
     * @param usuarioSistema
     * @return
     *     returns resource.Usuario
     */
    @WebMethod(operationName = "buscar_usuario")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscar_usuario", targetNamespace = "http://resource/", className = "resource.BuscarUsuario")
    @ResponseWrapper(localName = "buscar_usuarioResponse", targetNamespace = "http://resource/", className = "resource.BuscarUsuarioResponse")
    @Action(input = "http://resource/WebResource/buscar_usuarioRequest", output = "http://resource/WebResource/buscar_usuarioResponse")
    public Usuario buscarUsuario(
        @WebParam(name = "usuario_sistema", targetNamespace = "")
        String usuarioSistema,
        @WebParam(name = "senha", targetNamespace = "")
        String senha);

}