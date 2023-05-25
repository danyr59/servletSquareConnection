/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.jsp.apiRequest.modelApi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.squareup.square.models.Fulfillment;
import com.squareup.square.models.Money;
//import com.squareup.square.models.OrderLineItem;
import com.squareup.square.models.OrderLineItemAppliedDiscount;
import com.squareup.square.models.OrderLineItemAppliedServiceCharge;
import com.squareup.square.models.OrderLineItemAppliedTax;
import com.squareup.square.models.OrderLineItemDiscount;
import com.squareup.square.models.OrderLineItemModifier;
import com.squareup.square.models.OrderLineItemPricingBlocklists;
import com.squareup.square.models.OrderLineItemTax;
//import com.squareup.square.models.OrderMoneyAmounts;
import com.squareup.square.models.OrderPricingOptions;
import com.squareup.square.models.OrderQuantityUnit;
import com.squareup.square.models.OrderReturn;
import com.squareup.square.models.OrderReward;
import com.squareup.square.models.OrderRoundingAdjustment;
import com.squareup.square.models.OrderServiceCharge;
import com.squareup.square.models.OrderSource;
import com.squareup.square.models.Refund;
import com.squareup.square.models.Tender;
import io.apimatic.core.types.OptionalNullable;
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
public class modelApiOrderResponse {

    public String createdAt;
    public String id;
    public List<OrderLineItem> lineItems;
    public String locationId;
    public OrderMoneyAmounts netAmounts;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class OrderMoneyAmounts {

        Money totalMoney;
        Money taxMoney;
        Money discountMoney;
        Money tipMoney;
        Money serviceChargeMoney;
    }
    public Money netAmountDueMoney;
    public OrderSource source;
    public String state;
    public Money totalDiscountMoney;
    public Money totalMoney;
    public Money totalServiceChargeMoney;
    public Money totalTaxMoney;
    public Money totalTipMoney;
    public String updatedAt;
    public Integer version;

    public void setModelApiOrderResponse(modelApiOrderResponse r) {
        this.createdAt = r.getCreatedAt();
        this.id = r.getId();
        this.lineItems = r.getLineItems();
        this.locationId = r.getLocationId();
        this.netAmounts = r.getNetAmounts();
        this.netAmountDueMoney = r.getNetAmountDueMoney();
        this.source = r.getSource();
        this.state = r.getState();
        this.totalDiscountMoney = r.getTotalDiscountMoney();
        this.totalMoney = r.getTotalMoney();
        this.totalServiceChargeMoney = this.getTotalServiceChargeMoney();
        this.totalTaxMoney = r.getTotalTaxMoney();
        this.totalTipMoney = r.getTotalTipMoney();
        this.updatedAt = r.getUpdatedAt();
        this.version = r.getVersion();

    }

}
