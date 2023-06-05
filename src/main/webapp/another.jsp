
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.squareup.square.models.CatalogObject" %>
<%@ page import="java.util.stream.Collectors" %>

<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>
<%@ page import="java.util.List" %>
<%@ page import="com.fasterxml.jackson.core.type.TypeReference" %>
<%@ page import="java.io.IOException" %>
<%@ page import="com.squareup.square.models.CatalogObject" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>



<%
String jsonArrayString = (String) request.getAttribute("catalogo");

ObjectMapper objectMapper = new ObjectMapper();
List<CatalogObject> categorys = new ArrayList<>();
List<CatalogObject> taxes = new ArrayList<>();
List<CatalogObject> myObjects;
try {
myObjects = objectMapper.readValue(jsonArrayString, new TypeReference<List<CatalogObject>>() {});
 if (myObjects != null) {
for (CatalogObject catalogObject : myObjects) { 
    if (catalogObject.getType().equals("CATEGORY")){
        categorys.add(catalogObject);
    }
    if (catalogObject.getType().equals("TAX")){
        taxes.add(catalogObject);
    }
}
}

} catch (IOException e) {
  System.err.println(e);
e.printStackTrace();
myObjects = null;


}

%>
<!DOCTYPE html>
<html class="w-full ">
    <head>
        <meta charset="UTF-8">
        <title>Mi archivo JSP</title>
        <%@include file="includes/head.jsp" %> 
        <style>
            .table-container {
                max-width: 100%;
                overflow-x: auto;
            }
        </style>
    </head>
    <body class="bg-gray-100">
        <div class="container mx-auto px-4 py-8">
            <h1 class="text-3xl font-bold mb-6">Tabla de artículos</h1>
            <div class="table-container">
                <table class="w-full table-auto border-collapse">
                    <thead>
                        <tr>
                            <th class="border px-4 py-2">Token</th>
                            <th class="border px-4 py-2">Nombre del artículo</th>
                            <th class="border px-4 py-2">Nombre de variante</th>
                            <th class="border px-4 py-2">SKU</th>
                            <th class="border px-4 py-2">Descripción</th>
                            <th class="border px-4 py-2">Categoría</th>
                            <th class="border px-4 py-2">Precio</th>
                            <th class="border px-4 py-2">Impuesto</th>
                                <%--

                            <th class="border px-4 py-2">Para vender</th>
                            <th class="border px-4 py-2">Para almacenar en stock</th>
                            <th class="border px-4 py-2">Opción de nombre 1</th>
                            <th class="border px-4 py-2">Valor de la opción 1</th>
                            <th class="border px-4 py-2">Opción de nombre 2</th>
                            <th class="border px-4 py-2">Valor de la opción 2</th>
                            <th class="border px-4 py-2">Opción de nombre 3</th>
                            <th class="border px-4 py-2">Valor de la opción 3</th>
                                
                            <th class="border px-4 py-2">Activado My Business</th>
                            <th class="border px-4 py-2">Cantidad actual My Business</th>
                            <th class="border px-4 py-2">Nueva cantidad My Business</th>
                            <th class="border px-4 py-2">Alerta de inventario activada My Business</th>
                            <th class="border px-4 py-2">Conteo de alerta de inventario My Business</th>
                            <th class="border px-4 py-2">Precio My Business</th>
                            <th class="border px-4 py-2">Activado my bussines ny</th>
                            <th class="border px-4 py-2">Cantidad actual my bussines ny</th>
                            <th class="border px-4 py-2">Nueva cantidad my bussines ny</th>
                            <th class="border px-4 py-2">Alerta de inventario activada my bussines ny</th>
                            <th class="border px-4 py-2">Conteo de alerta de inventario my bussines ny</th>
                            <th class="border px-4 py-2">Precio my bussines ny</th>
                            <th class="border px-4 py-2">Impuesto - IVA (19%)</th>
                                --%>
                            <th class="border px-4 py-2">Seleccionar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% if (myObjects != null) { %>




                        <% for (CatalogObject catalogObject : myObjects) { %>
                        <% if (catalogObject.getType().equals("ITEM")) { %>

                        <% String nameArticulo  = catalogObject.getItemData().getName(); %>
                        <% String description  = catalogObject.getItemData().getDescriptionPlaintext(); %>
                        <% String categoryId  = catalogObject.getItemData().getCategoryId(); %>
                        <% List<String> taxes_  = catalogObject.getItemData().getTaxIds(); %>

                        <% for (CatalogObject variations : catalogObject.getItemData().getVariations()) { %>
                        <% String nombreVariante  = variations.getItemVariationData().getName(); %>
                        <% String token  = variations.getId(); %>
                        <% String sku  = variations.getItemVariationData().getSku() != null ? variations.getItemVariationData().getSku() : ""; %>
                        <% Long precio  = variations.getItemVariationData().getPriceMoney().getAmount(); %>
                        <%
                            
                            //String formattedPrecio = String.format("%,d", precio.floatValue());
                            System.out.println(precio.floatValue());
                            String nameCategory = "";
                            for(CatalogObject category :categorys){
                                if(category.getId().equals(categoryId)){
                                nameCategory = category.getCategoryData().getName();
                            }
                            }
                            String nameTaxes = "";
                            for(CatalogObject tax :taxes){
                                for( String idTaxes: taxes_){
                                if(tax.getId().equals(idTaxes)){
                                nameTaxes += tax.getTaxData().getName() + "- IVA " + tax.getTaxData().getPercentage()+"%" + ", ";
                            }
                                
                            }
                            }
                            
                            
                            

                        
                        %>
                        <tr>
                            <td class="border px-4 py-2"> <%= token %></td>
                            <td class="border px-4 py-2"><%= nameArticulo %></td>
                            <td class="border px-4 py-2"><%= nombreVariante %></td>
                            <td class="border px-4 py-2"><%= sku %></td>
                            <td class="border px-4 py-2"><%= description %></td>
                            <td class="border px-4 py-2"><%= nameCategory  %></td>
                            <td class="border px-4 py-2"><%= precio.floatValue() %></td>
                            <td class="border px-4 py-2"><%= nameTaxes %></td>
                            <%-- <td class="border px-4 py-2">Valor Para vender</td> --%>
                            <%-- <td class="border px-4 py-2">Valor Para almacenar en stock</td> --%>
                            <%--
                            <td class="border px-4 py-2">Valor Opción de nombre 1</td>
                            <td class="border px-4 py-2">Valor Valor de la opción 1</td>
                            <td class="border px-4 py-2">Valor Opción de nombre 2</td>
                            <td class="border px-4 py-2">Valor Valor de la opción 2</td>
                            <td class="border px-4 py-2">Valor Opción de nombre 3</td>
                            <td class="border px-4 py-2">Valor Valor de la opción 3</td>
                            
                            <td class="border px-4 py-2">Valor Activado My Business</td>
                            <td class="border px-4 py-2">Valor Cantidad actual My Business</td>
                            <td class="border px-4 py-2">Valor Nueva cantidad My Business</td>
                            <td class="border px-4 py-2">Valor Alerta de inventario activada My Business</td>
                            <td class="border px-4 py-2">Valor Conteo de alerta de inventario My Business</td>
                            <td class="border px-4 py-2">Valor Precio My Business</td>
                            <td class="border px-4 py-2">Valor Activado my bussines ny</td>
                            <td class="border px-4 py-2">Valor Cantidad actual my bussines ny</td>
                            <td class="border px-4 py-2">Valor Nueva cantidad my bussines ny</td>
                            <td class="border px-4 py-2">Valor Alerta de inventario activada my bussines ny</td>
                            <td class="border px-4 py-2">Valor Conteo de alerta de inventario my bussines ny</td>
                            <td class="border px-4 py-2">Valor Precio my bussines ny</td>
                            --%>
                            <td class="border px-4 py-2 center"><input type="checkbox" name="selectedItem" value="1"></td>
                        </tr>
                        <% } %>
                        <% } %>
                        <% } %>

                        <% } else { %>
                    <p>No se pudo realizar la conversión de JSON a objetos Java.</p>
                    <% } %>

                    <!-- Repite el bloque anterior para cada artículo -->
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
<%-- <% if (myObjects != null) { %> <h2>Lista de objetos Java:</h2> <ul> <% for (CatalogObject catalogObject : myObjects) { %> <li>id: <%= catalogObject.getId() %>, Name: <%= catalogObject.getType() %></li> <% } %> </ul> <% } else { %> <p>No se pudo realizar la conversión de JSON a objetos Java.</p> <% } %> --%>