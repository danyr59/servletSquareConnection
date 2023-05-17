package test.jsp.model.order;





import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 *
 * @author danyr59
 */
public class Order {
    String modifierId,quantityModifier,  quantityOrder, itemVariationId,  location;
    
    public void setOrder(String m, String qm, String qo, String ivi, String l){
        this.modifierId = m;
        this.quantityModifier = qm;
        this.quantityOrder = qo;
        this.itemVariationId = ivi; 
        this.location = l;
        
        
    }
    public Order getOrder(){
        return this;
    }
}
