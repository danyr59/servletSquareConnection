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

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import test.jsp.apiRequest.modelApi.modelApiOrder;
import test.jsp.apiRequest.orderRequestApi;
import test.jsp.model.order.Order;

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
        try (PrintWriter out = response.getWriter()) {
            String location_id = request.getParameter("location-id");
            String idempotency_key = request.getParameter("idempotency-key");
            String quantity_product = request.getParameter("quantity-product");
            String catalog_object_id = request.getParameter("catalog-object-id");
            out.print(location_id + idempotency_key + quantity_product + catalog_object_id + catalog_object_id);
            order = new Order();
            order.setOrder("", "", quantity_product, catalog_object_id, location_id);
            orderRequestApi orderApi = new orderRequestApi();
            orderApi.runPromise(new modelApiOrder("","",quantity_product, catalog_object_id, location_id));
        } catch (InterruptedException ex) {
            System.out.println("Error");
            Logger.getLogger(CreateOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void destroy() {
    }
}
