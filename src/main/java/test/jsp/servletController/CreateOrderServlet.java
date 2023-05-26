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
import java.util.stream.Collectors;
@WebServlet(name = "create-order", value = "/create-order")
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

        /*
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
         */
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Order order = null;

//        System.out.println(location_id + " " + quantity_modifier + " " + modifier_id + " " + quantity_product + " " + catalog_object_id);
        try (PrintWriter out = response.getWriter(); BufferedReader reader = request.getReader()) {
            String location_id = request.getParameter("location-id");
            String quantity_modifier = request.getParameter("quantity-modifier");
            String modifier_id = request.getParameter("modifier-id");
            String quantity_product = request.getParameter("quantity-product");
            String catalog_object_id = request.getParameter("catalog-object-id");
            order = new Order();
            
            order.setLocation(location_id);
            order.setQuantityOrder(quantity_product);
            order.setModifierId(modifier_id);
            order.setQuantityModifier(quantity_modifier);
            order.setItemVariationId(catalog_object_id);
            Jsonb jsonb = JsonbBuilder.create();
            String orderJson =  jsonb.toJson(order);
            
            //System.out.println(reader.lines().collect(Collectors.joining(System.lineSeparator())));
            //String a = reader.lines().collect(Collectors.joining(System.lineSeparator()));
            out.print(orderJson);
        }
        /*
        try (PrintWriter out = response.getWriter()) {
            String location_id = request.getParameter("location-id");
            String quantity_modifier = request.getParameter("quantity-modifier");
            String modifier_id = request.getParameter("modifier-id");
            String quantity_product = request.getParameter("quantity-product");
            String catalog_object_id = request.getParameter("catalog-object-id");
            //out.print(location_id + idempotency_key + quantity_product + catalog_object_id + catalog_object_id);
            
            orderRequestApi orderApi = new orderRequestApi();
            modelApiOrderResponse bodyResponse = orderApi.runPromise(new modelApiOrder(modifier_id,quantity_modifier,quantity_product, catalog_object_id, location_id));
            //System.out.println("en dopost");
            JSONObject r = new JSONObject(bodyResponse);
            //System.out.println(r);
            out.print(r);
                        
        } catch (InterruptedException ex) {
            System.out.println("Error");
            Logger.getLogger(CreateOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

         */
 /*
        try (PrintWriter out = response.getWriter()) {
        String location_id = request.getParameter("location-id");
        String quantity_modifier = request.getParameter("quantity-modifier");
        String modifier_id = request.getParameter("modifier-id");
        String quantity_product = request.getParameter("quantity-product");
        String catalog_object_id = request.getParameter("catalog-object-id");
        //out.print(location_id + idempotency_key + quantity_product + catalog_object_id + catalog_object_id);
        order = new Order();
        order.setOrder("", "", quantity_product, catalog_object_id, location_id);
        orderRequestApi orderApi = new orderRequestApi();
        modelApiOrderResponse bodyResponse = orderApi.runPromise(new modelApiOrder(modifier_id,quantity_modifier,quantity_product, catalog_object_id, location_id));
        //System.out.println("en dopost");
        JSONObject r = new JSONObject(bodyResponse);
        //System.out.println(r);
        out.print(r);
        } catch (InterruptedException ex) {
        System.out.println("Error");
        Logger.getLogger(CreateOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
    }

    @Override
    public void destroy() {
    }
}
