
package resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de comprar_item complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="comprar_item">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_usuario" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="id_item" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "comprar_item", propOrder = {
    "idUsuario",
    "idItem"
})
public class ComprarItem {

    @XmlElement(name = "id_usuario")
    protected long idUsuario;
    @XmlElement(name = "id_item")
    protected long idItem;

    /**
     * Obtém o valor da propriedade idUsuario.
     * 
     */
    public long getIdUsuario() {
        return idUsuario;
    }

    /**
     * Define o valor da propriedade idUsuario.
     * 
     */
    public void setIdUsuario(long value) {
        this.idUsuario = value;
    }

    /**
     * Obtém o valor da propriedade idItem.
     * 
     */
    public long getIdItem() {
        return idItem;
    }

    /**
     * Define o valor da propriedade idItem.
     * 
     */
    public void setIdItem(long value) {
        this.idItem = value;
    }

}
