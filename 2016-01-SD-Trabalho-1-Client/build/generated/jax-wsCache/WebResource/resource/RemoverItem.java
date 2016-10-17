
package resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de remover_item complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="remover_item">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_usuario" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="indice_item" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "remover_item", propOrder = {
    "idUsuario",
    "indiceItem"
})
public class RemoverItem {

    @XmlElement(name = "id_usuario")
    protected long idUsuario;
    @XmlElement(name = "indice_item")
    protected int indiceItem;

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
     * Obtém o valor da propriedade indiceItem.
     * 
     */
    public int getIndiceItem() {
        return indiceItem;
    }

    /**
     * Define o valor da propriedade indiceItem.
     * 
     */
    public void setIndiceItem(int value) {
        this.indiceItem = value;
    }

}
