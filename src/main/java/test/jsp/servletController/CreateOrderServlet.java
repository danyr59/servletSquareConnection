/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package test.jsp.servletController;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import test.jsp.apiRequest.modelApiRequestResponse.modelApiOrderRequest;
import test.jsp.apiRequest.modelApiRequestResponse.modelApiOrderResponse;
import test.jsp.apiRequest.orderRequestApi;
import java.io.BufferedReader;
import java.util.stream.Collectors;
import test.jsp.utils.Utils;
// Definición de la función lambda

@WebServlet(name = "create-order", urlPatterns = "/create-order")
public class CreateOrderServlet extends HttpServlet {

    @Inject
    private Utils utils;

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
        modelApiOrderRequest orderRequest = new modelApiOrderRequest();
        

        try (PrintWriter out = response.getWriter(); BufferedReader reader = request.getReader()) {

            //obtenemos el json del formulario
            JSONObject jsonb = new JSONObject(reader.lines().collect(Collectors.joining(System.lineSeparator())));

            //inicializacion de la orden 
            orderRequest.setOrder(utils.inicializarObj(jsonb).getOrder());

            //creacion de peticiones
            orderRequestApi orderApi = new orderRequestApi();
            modelApiOrderResponse bodyResponse = orderApi.runCallAllApis(orderRequest);
            
            
            //creamos las repuestas, si es exitoso o no 
            JSONObject respuesta = new JSONObject();
            respuesta.put("title", bodyResponse.getTitle());
            respuesta.put("mensaje", bodyResponse.getTitle().equals("SUCCESS") ? "creado con exito": "algo fallo intenta nuevamente");
            respuesta.put("order_id", bodyResponse.getOrderId());

            //mandamos el json que se renderiza en el jsp
            out.print(respuesta.toString());

        } catch (IOException | RuntimeException | InterruptedException ex) {
           
            Logger.getLogger(CreateOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        // request.setAttribute("mensaje", "ha sido creado");
        //request.getRequestDispatcher("RegistroExitoso.jsp").forward(request, response);
    }

    @Override
    public void destroy() {

    }
}
