package test.jsp.model.order;





import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 *
 * @author danyr59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    String modifierId,quantityModifier,  quantityOrder, itemVariationId,  location;
    
    
}
