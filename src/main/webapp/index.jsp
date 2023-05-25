<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html class="w-full h-full">
    <head>
        <title>Probar apis</title>
        <%@include file="includes/head.jsp" %>        
    </head>
    <body class=" w-full h-full">
        <header class="h-16 bg-white sticky top-0">
            <div id="img-container" class="absolute left-2 top-2 h-12 w-12">
                <img src="https://vinti7.com/wp-content/uploads/2016/06/logos-de-flechas-10.jpg" alt="avatar" class="h-full w-full">
            </div>

            <div id="nav-container" class="bg-white p-2 flex flex-col items-end">
                <div id="nav-icon" class="h-12 w-12 p-2 group">
                    <svg xmlns="<http://www.w3.org/2000/svg>" viewBox="0 0 20 20" fill="currentColor" class="h-full w-full group-hover:fill-blue-500">
                    <path fill-rule="evenodd" d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z" clip-rule="evenodd" />
                    </svg>
                </div>

                <ul id="nav-menu" class="hidden w-full space-y-2 pr-3 font-semibold text-xl text-right">
                    <li> <a href="create_order.jsp">Create Order</a> </li>
                    
                </ul>
            </div>
        </header>
        <main class="flex flex-col  w-full h-full  justify-center justify-items-center items-center">
           
            <br/>
            <a class="text-3xl font-bold underline" href="hello-servlet">Hi</a>
            <br/>
            <a class="text-3xl font-bold underline" href="create_order.jsp">Crear Orden</a>
            
            
        </main>
        <script type="text/javascript">
            document.getElementById("nav-icon").addEventListener('click',
                    () => document.getElementById("nav-menu").classList.toggle("hidden")
            );
        </script>
    </body>
</html>