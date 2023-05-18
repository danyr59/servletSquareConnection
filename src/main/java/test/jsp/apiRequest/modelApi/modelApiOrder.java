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
    
    /*
    
       String location_id = request.getParameter("location-id");
            String idempotency_key = request.getParameter("idempotency-key");
            String quantity_product = request.getParameter("quantity-product");
            String catalog_object_id = request.getParameter("catalog-object-id");
    */

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
