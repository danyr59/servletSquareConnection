/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.jsp.apiRequest.modelApi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.squareup.square.models.Fulfillment;
import com.squareup.square.models.Money;
import com.squareup.square.models.OrderLineItem;
import com.squareup.square.models.OrderLineItemDiscount;
import com.squareup.square.models.OrderLineItemTax;
import com.squareup.square.models.OrderMoneyAmounts;
import com.squareup.square.models.OrderPricingOptions;
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

    @JsonIgnore

    public String createdAt;
    public String id;

    @JsonIgnore
    private OptionalNullable<List<OrderLineItem>> lineItems;
    @JsonIgnore
    public String locationId;
    @JsonIgnore
    public OrderMoneyAmounts netAmounts;
    @JsonIgnore
    public Money netAmountDueMoney;

    public OrderSource source;
    @JsonIgnore
    public String state;
    @JsonIgnore

    private Money totalDiscountMoney;
    @JsonIgnore

    public Money totalMoney;
    @JsonIgnore

    public Money totalServiceChargeMoney;
    @JsonIgnore

    public Money totalTaxMoney;
    @JsonIgnore

    public Money totalTipMoney;
    @JsonIgnore

    public String updatedAt;
    @JsonIgnore

    public Integer version;

}
