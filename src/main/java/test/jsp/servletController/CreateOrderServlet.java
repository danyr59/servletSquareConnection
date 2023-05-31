/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package test.jsp.servletController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.Jsonb;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import test.jsp.apiRequest.modelApi.modelApiOrder;
import test.jsp.apiRequest.modelApi.modelApiOrderResponse;
import test.jsp.apiRequest.orderRequestApi;
import test.jsp.model.order.Order;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import jdk.nashorn.api.scripting.JSObject;
import org.json.JSONArray;
// Definición de la función lambda

@WebServlet(name = "create-order", urlPatterns = "/create-order")
public class CreateOrderServlet extends HttpServlet {

    private String message;

    @Override
    public void init() {
        message = "Hello World from Servlet!";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //response.setContentType("text/html");

        response.sendRedirect("create_order.jsp");

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        modelApiOrder order = null;

//        System.out.println(location_id + " " + quantity_modifier + " " + modifier_id + " " + quantity_product + " " + catalog_object_id);
        JSONObject jsonb = null;

        
        try (PrintWriter out = response.getWriter(); BufferedReader reader = request.getReader()) {

            jsonb = new JSONObject(request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));

            order = this.inicializarObj(jsonb);

            orderRequestApi orderApi = new orderRequestApi();
            modelApiOrderResponse bodyResponse = orderApi.runPromise(order);
            //System.out.println("en dopost");
            //JSONObject r = new JSONObject(bodyResponse);
            JSONObject respuesta = new JSONObject();
            respuesta.put("title", bodyResponse.getTitle());
            respuesta.put("mensaje", "creado con exito");
            respuesta.put("order_id", bodyResponse.getOrderId());

            out.print(respuesta.toString());

            //out.print(order);
        } catch (InterruptedException ex) {
            Logger.getLogger(CreateOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        // request.setAttribute("mensaje", "ha sido creado");
        //request.getRequestDispatcher("RegistroExitoso.jsp").forward(request, response);
    }

    public modelApiOrder inicializarObj(JSONObject jsonb) {
        //FuncionVerificar check = (key, obj) -> obj.has(key) ? obj.getString(key) : "";

        // Llamada a la función lambda
        //String resultado = check.operar("2"); // resultado será 5
        modelApiOrder order = new modelApiOrder();

        List<modelApiOrder.Modifiers> aux_modifier = new ArrayList<>();
        modelApiOrder.Modifiers m = new modelApiOrder.Modifiers();
        modelApiOrder.lineItems li = new modelApiOrder.lineItems();
        List<modelApiOrder.Taxes> taxes = new ArrayList<>();

        String location = jsonb.getString("location_id");
        String state = jsonb.getString("state");
        String customer_id = jsonb.getString("customer_id");
        String ticket_name = jsonb.getString("ticket_name");
        List<modelApiOrder.lineItems> aux_list_items = new ArrayList<>();
        if (jsonb.has("line_items")) {
            for (int i = 0; i < jsonb.getJSONArray("line_items").length(); i++) {
                JSONObject line_items = jsonb.getJSONArray("line_items").getJSONObject(i);

                if (line_items.has("modifiers")) {
                    JSONArray modi = line_items.getJSONArray("modifiers");

                    for (int j = 0; j < modi.length(); j++) {

                        JSONObject modiObj = modi.getJSONObject(j);

                        String catalog_object_id = modiObj.getString("catalog_object_id");
                        String quantity = modiObj.getString("quantity");

                        m.setCatalog_object_id(catalog_object_id);
                        m.setQuantity(quantity);

                        aux_modifier.add(m);
                    }

                }
                String quantity = line_items.getString("quantity");
                String catalog_object_id = line_items.getString("catalog_object_id");
                String item_type = line_items.getString("item_type");

                li.setCatalog_object_id(catalog_object_id);
                li.setQuantity(quantity);
                li.setItem_type(item_type);
                li.setModifiers(aux_modifier);
                aux_list_items.add(li);

            }
        }

        if (jsonb.has("taxes")) {
            JSONArray taxesArray = jsonb.getJSONArray("taxes");
            for (int i = 0; i < jsonb.getJSONArray("taxes").length(); i++) {
                modelApiOrder.Taxes t = new modelApiOrder.Taxes();
                JSONObject objTaxes = taxesArray.getJSONObject(i);
                String catalog_object_id = objTaxes.getString("catalog_object_id");
                String catalog_version = objTaxes.getString("catalog_version");

                t.setCatalog_object_id(catalog_object_id);
                t.setCatalog_version(catalog_version);
                taxes.add(t);
            }
        }

        //set part of fulfillment - update
        List<modelApiOrder.Fulfillments> f = new ArrayList<>();

        for (int i = 0; i < jsonb.getJSONArray("fulfillments").length(); i++) {
            JSONObject fulfillment
                    = jsonb.getJSONArray("fulfillments").getJSONObject(i);
            String type = fulfillment.getString("type");
            JSONObject shipment_details = fulfillment.getJSONObject("shipment_details");
            JSONObject recipient = shipment_details.getJSONObject("recipient");

            modelApiOrder.Recipient r = new modelApiOrder.Recipient();

            String display_name = recipient.getString("display_name");
            String email_address = recipient.getString("email_address");
            String phone_number = recipient.getString("phone_number");
            JSONObject address = recipient.getJSONObject("address");

            modelApiOrder.Address a = new modelApiOrder.Address();
            String address_line_1 = address.getString("address_line_1");
            String address_line_2 = address.getString("address_line_2");
            String address_line_3 = address.getString("address_line_3");
            String administrative_district_level_1 = address.getString("administrative_district_level_1");
            String administrative_district_level_2 = address.getString("administrative_district_level_2");
            String administrative_district_level_3 = address.getString("administrative_district_level_3");
            String country = address.getString("country");
            String locality = address.getString("locality");
            String postal_code = address.getString("postal_code");
            String sublocality = address.getString("sublocality");
            String sublocality_2 = address.getString("sublocality_2");
            String sublocality_3 = address.getString("sublocality_3");
            a.setAddress_line_1(address_line_1);
            a.setAddress_line_2(address_line_2);
            a.setAddress_line_3(address_line_3);
            a.setAdministrative_district_level_1(administrative_district_level_1);
            a.setAdministrative_district_level_2(administrative_district_level_2);
            a.setAdministrative_district_level_3(administrative_district_level_3);
            a.setCountry(country);
            a.setLocality(locality);
            a.setPostal_code(postal_code);
            a.setSublocality(sublocality);
            a.setSublocality_2(sublocality_2);
            a.setSublocality_3(sublocality_3);

            r.setDisplay_name(display_name);
            r.setEmail_address(email_address);
            r.setPhone_number(phone_number);
            r.setAddress(a);

            modelApiOrder.ShipmentDetails sd = new modelApiOrder.ShipmentDetails();
            sd.setRecipient(r);

            modelApiOrder.Fulfillments f_ = new modelApiOrder.Fulfillments();
            f_.setShipment_details(sd);
            f_.setType(type);
            f.add(f_);

        }

        //order 
        String reference_id = jsonb.getString("reference_id");
        String source_id = jsonb.getString("source_id");
        JSONObject external_deta = jsonb.getJSONObject("external_details");
        String source = external_deta.getString("source");
        String type = external_deta.getString("type");
        String source_id_external = external_deta.getString("source_id");
        modelApiOrder.ExternalPaymentDetails e = new modelApiOrder.ExternalPaymentDetails();
        e.setSource(source);
        e.setType(type);
        e.setSourceId(source_id_external);

        modelApiOrder.Order o = new modelApiOrder.Order();
        o.setLine_items(aux_list_items);
        o.setCustomer_id(customer_id);
        o.setLocation_id(location);
        o.setState(state);
        o.setTicket_name(ticket_name);
        o.setTaxes(taxes);
        o.setFulfillments(f);
        o.setSource_id(source_id);
        o.setReference_id(reference_id);
        o.setExternal_details(e);

        order.setOrder(o);

        return order;

    }

    @Override
    public void destroy() {

    }
}
