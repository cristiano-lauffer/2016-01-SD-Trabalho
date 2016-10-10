
package resource;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the resource package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BuscarUsuario_QNAME = new QName("http://resource/", "buscar_usuario");
    private final static QName _ListarUsuarios_QNAME = new QName("http://resource/", "listar_usuarios");
    private final static QName _BuscarUsuarioResponse_QNAME = new QName("http://resource/", "buscar_usuarioResponse");
    private final static QName _ListarUsuariosResponse_QNAME = new QName("http://resource/", "listar_usuariosResponse");
    private final static QName _ListarItens_QNAME = new QName("http://resource/", "listar_itens");
    private final static QName _ComprarItemResponse_QNAME = new QName("http://resource/", "comprar_itemResponse");
    private final static QName _ListarItensResponse_QNAME = new QName("http://resource/", "listar_itensResponse");
    private final static QName _ComprarItem_QNAME = new QName("http://resource/", "comprar_item");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: resource
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ComprarItemResponse }
     * 
     */
    public ComprarItemResponse createComprarItemResponse() {
        return new ComprarItemResponse();
    }

    /**
     * Create an instance of {@link ListarItensResponse }
     * 
     */
    public ListarItensResponse createListarItensResponse() {
        return new ListarItensResponse();
    }

    /**
     * Create an instance of {@link ComprarItem }
     * 
     */
    public ComprarItem createComprarItem() {
        return new ComprarItem();
    }

    /**
     * Create an instance of {@link BuscarUsuarioResponse }
     * 
     */
    public BuscarUsuarioResponse createBuscarUsuarioResponse() {
        return new BuscarUsuarioResponse();
    }

    /**
     * Create an instance of {@link ListarUsuariosResponse }
     * 
     */
    public ListarUsuariosResponse createListarUsuariosResponse() {
        return new ListarUsuariosResponse();
    }

    /**
     * Create an instance of {@link BuscarUsuario }
     * 
     */
    public BuscarUsuario createBuscarUsuario() {
        return new BuscarUsuario();
    }

    /**
     * Create an instance of {@link ListarUsuarios }
     * 
     */
    public ListarUsuarios createListarUsuarios() {
        return new ListarUsuarios();
    }

    /**
     * Create an instance of {@link ListarItens }
     * 
     */
    public ListarItens createListarItens() {
        return new ListarItens();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://resource/", name = "buscar_usuario")
    public JAXBElement<BuscarUsuario> createBuscarUsuario(BuscarUsuario value) {
        return new JAXBElement<BuscarUsuario>(_BuscarUsuario_QNAME, BuscarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarUsuarios }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://resource/", name = "listar_usuarios")
    public JAXBElement<ListarUsuarios> createListarUsuarios(ListarUsuarios value) {
        return new JAXBElement<ListarUsuarios>(_ListarUsuarios_QNAME, ListarUsuarios.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuscarUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://resource/", name = "buscar_usuarioResponse")
    public JAXBElement<BuscarUsuarioResponse> createBuscarUsuarioResponse(BuscarUsuarioResponse value) {
        return new JAXBElement<BuscarUsuarioResponse>(_BuscarUsuarioResponse_QNAME, BuscarUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarUsuariosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://resource/", name = "listar_usuariosResponse")
    public JAXBElement<ListarUsuariosResponse> createListarUsuariosResponse(ListarUsuariosResponse value) {
        return new JAXBElement<ListarUsuariosResponse>(_ListarUsuariosResponse_QNAME, ListarUsuariosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarItens }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://resource/", name = "listar_itens")
    public JAXBElement<ListarItens> createListarItens(ListarItens value) {
        return new JAXBElement<ListarItens>(_ListarItens_QNAME, ListarItens.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComprarItemResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://resource/", name = "comprar_itemResponse")
    public JAXBElement<ComprarItemResponse> createComprarItemResponse(ComprarItemResponse value) {
        return new JAXBElement<ComprarItemResponse>(_ComprarItemResponse_QNAME, ComprarItemResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarItensResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://resource/", name = "listar_itensResponse")
    public JAXBElement<ListarItensResponse> createListarItensResponse(ListarItensResponse value) {
        return new JAXBElement<ListarItensResponse>(_ListarItensResponse_QNAME, ListarItensResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComprarItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://resource/", name = "comprar_item")
    public JAXBElement<ComprarItem> createComprarItem(ComprarItem value) {
        return new JAXBElement<ComprarItem>(_ComprarItem_QNAME, ComprarItem.class, null, value);
    }

}
