<%-- 
    Document   : RegistroExitoso
    Created on : May 30, 2023, 11:25:36 AM
    Author     : danyr59
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/head.jsp" %> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validacion</title>
        <style>
            /* Estilos personalizados */
            .container {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="bg-green-500 text-white p-4 rounded-lg">
                <% String mensaje = request.getParameter("mensaje"); %>
                <% String title = request.getParameter("title"); %>
                <% String order_id = request.getParameter("order_id"); %>
                <h1 class="text-2xl mb-2"><%= title %></h1>
                <p><%= mensaje %></p>  
                <label>Order id: <p><%= order_id %></p> </label>
                


            </div>
        </div>
    </body>
</html>
