
package test.jsp.apiRequest.modelApi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.squareup.square.models.Money;
import com.squareup.square.models.OrderLineItemAppliedDiscount;
import com.squareup.square.models.OrderLineItemAppliedServiceCharge;
import com.squareup.square.models.OrderLineItemAppliedTax;
import com.squareup.square.models.OrderLineItemModifier;
import com.squareup.square.models.OrderLineItemPricingBlocklists;
import com.squareup.square.models.OrderQuantityUnit;
import java.util.List;
import java.util.Map;
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
public class OrderLineItem {

    Money basePriceMoney;
    String catalogObjectId;
    Long catalogVersion;
    Money grossSalesMoney;
    String itemType;
    String name;
    String quantity;
    Money totalDiscountMoney;
    Money totalMoney;
    Money totalServiceChargeMoney;
    Money totalTaxMoney;
    String uid;
    String variationName;
    Money variationTotalPriceMoney;

    @JsonIgnore
    OrderQuantityUnit quantityUnit;
    @JsonIgnore
    String note;

    @JsonIgnore
    Map<String, String> metadata;

    @JsonIgnore
    List<OrderLineItemModifier> modifiers;
    @JsonIgnore
    List<OrderLineItemAppliedTax> appliedTaxes;
    @JsonIgnore
    List<OrderLineItemAppliedDiscount> appliedDiscounts;
    @JsonIgnore
    List<OrderLineItemAppliedServiceCharge> appliedServiceCharges;
    @JsonIgnore
    OrderLineItemPricingBlocklists pricingBlocklists;

}
