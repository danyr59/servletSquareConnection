/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.jsp.apiRequest.modelApi;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author danyr59
 */
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class modelApiOrder {

    Order order;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Order {

        String location_id, state, customer_id;
        List<lineItems> line_items;
        String ticket_name;
        List<Taxes> taxes;
        List<Fulfillments> fulfillments;
        String source_id;
        String reference_id;
        ExternalPaymentDetails external_details;
        String order_id;

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class lineItems {

        String quantity, catalog_object_id, item_type;
        List<Modifiers> modifiers;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Taxes {

        String catalog_object_id;
        String catalog_version;

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Modifiers {

        String catalog_object_id;
        String quantity;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Fulfillments {

        String type;
        ShipmentDetails shipment_details;

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ShipmentDetails {

        Recipient recipient;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Recipient {

        String display_name;
        String email_address;
        String phone_number;
        Address address;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Address {

        String address_line_1;
        String address_line_2;
        String address_line_3;
        String administrative_district_level_1;
        String administrative_district_level_2;
        String administrative_district_level_3;
        String country;
        String locality;
        String postal_code;
        String sublocality;
        String sublocality_2;
        String sublocality_3;

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ExternalPaymentDetails {

        String type;
        String source;
        String sourceId;
        //private Money sourceFeeMoney;
    }

    /*
    String modifierId, quantityModifier, itemVariationId, quantityOrder,  location;
    //List<String> itemVariationId; 
    
     */
}


/*

public class modelApiOrder {

    public modelApiOrder(String modifierId, String quantityModifier, String quantityOrder, String itemVariationId, String location) {
        this.modifierId = modifierId;
        this.quantityModifier = quantityModifier;
        this.quantityOrder = quantityOrder;
        this.itemVariationId = itemVariationId;
        this.location = location;
    }
    
    String modifierId, quantityModifier,  quantityOrder, itemVariationId,  location;

    public void setModifierId(String modifierId) {
        this.modifierId = modifierId;
    }

    public void setQuantityModifier(String quantityModifier) {
        this.quantityModifier = quantityModifier;
    }

    public void setQuantityOrder(String quantityOrder) {
        this.quantityOrder = quantityOrder;
    }

    public void setItemVariationId(String itemVariationId) {
        this.itemVariationId = itemVariationId;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "modelApiOrder{" + "modifierId=" + modifierId + ", quantityModifier=" + quantityModifier + ", quantityOrder=" + quantityOrder + ", itemVariationId=" + itemVariationId + ", location=" + location + '}';
    }
    
    
    public String getModifierId() {
        return modifierId;
    }

    public String getQuantityModifier() {
        return quantityModifier;
    }

    public String getQuantityOrder() {
        return quantityOrder;
    }

    public String getItemVariationId() {
        return itemVariationId;
    }

    public String getLocation() {
        return location;
    }
    
   
    
}
 */
