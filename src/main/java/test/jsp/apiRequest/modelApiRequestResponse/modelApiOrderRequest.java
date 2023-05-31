package test.jsp.apiRequest.modelApiRequestResponse;

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

public class modelApiOrderRequest {

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
    //@Builder
    public static class ExternalPaymentDetails {

        //@Builder.Default
        String type;
        String source;
        String sourceId;
        //private Money sourceFeeMoney;
    }

}
