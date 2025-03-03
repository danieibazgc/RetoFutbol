<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Usuario" %>
<%
     Usuario usuario2 = (Usuario) session.getAttribute("usuario");
    String rol = null;

    if (usuario2 != null) {
        rol = usuario2.getRol();
    } else {
        // Redirigir al usuario a la página de inicio de sesión o manejar el error
        response.sendRedirect("login.jsp"); // Asumiendo que "login.jsp" es tu página de inicio de sesión
        return; // Asegura que el resto del código JSP no se ejecute
    }
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="css/navegadorCSS.css" rel="stylesheet" type="text/css"/>
        <link href="css/indexCSS.css" rel="stylesheet" type="text/css"/>
        <title>Futbol Retro</title>
        <style>
            body {
                margin: 0;
                padding: 0;
                font-family: Arial, sans-serif;
                background-color: #F5F5DC; /* Color crema */
                background-image: linear-gradient(to right, red 50%, #F5F5DC 50%); /* Patrón alternado de colores */
                background-size: 200% 100%; /* Doble del tamaño necesario para repetir la secuencia */
                animation: gradient 4s linear infinite; /* Animación de desplazamiento */
            }

            @keyframes gradient {
                0% {
                    background-position: 0% 50%; /* Comienza con rojo */
                }
                12.5% {
                    background-position: 100% 50%; /* Cambia a crema */
                }
                25% {
                    background-position: 0% 50%; /* Vuelve a rojo */
                }
                37.5% {
                    background-position: 100% 50%; /* Cambia a crema */
                }
                50% {
                    background-position: 0% 50%; /* Vuelve a rojo */
                }
                62.5% {
                    background-position: 100% 50%; /* Cambia a crema */
                }
                75% {
                    background-position: 0% 50%; /* Vuelve a rojo */
                }
                87.5% {
                    background-position: 100% 50%; /* Cambia a crema */
                }
                100% {
                    background-position: 0% 50%; /* Vuelve a rojo */
                }
            }

            .info {
                text-align: center;
                padding: 50px 0;
            }
            .container {
                max-width: 800px;
                margin: 0 auto;
                padding: 20px; /* Añadido un espacio interno al contenedor */
            }
            img {
                max-width: 100%;
                height: auto;
                margin-top: 20px;
            }
            .img-center {
                display: block;
                margin: 0 auto;
            }
        </style>
    </head>
    <body>
        <div class="container-fuera">
            <div class="container-dentro">

                <!-- Esto es el encabezado (navegador y el boton salir) -->
                <div class="navegador">
                    <%
                        if (rol.equals("administrador")) {
                    %>
                    <!-- Esto es el menu de administrador -->
                    <%@ include file="navegador/menuAdmin.jsp" %>
                    <!-- -->
                    <%
                    } else {
                    %>
                    <!-- Esto es el menu de empleado -->
                    <%@ include file="navegador/menuEmpleado.jsp" %>
                    <!-- -->
                    <%
                        }
                    %>

                    <div class="exit">
                        <a href="srvLogin?accion=cerrar">
                            <i class="fa-solid fa-arrow-right-from-bracket fa-flip-horizontal"></i>
                            <p>SALIR</p>
                        </a>
                    </div>
                </div>
                <!-- -->


                <!-- Aqui irán las diferentes ventanas (solo es copiar el mismo formato, crear un jsp con nombre "Productos" y aqui empezar a programar-->
                <div class="info">
                    <div class="container">
                        <h1>Bienvenidos a la plataforma Futbol Retro</h1>
                        <p>Este aplicativo se creó con la finalidad de solucionar sus problemas y que no tenga estrés al realizar diversas tareas.</p>
                        <img src="img/daleu.gif" alt="" class="img-center"/> <!-- Daleu centrado -->
                    </div>
                </div>


            </div>
        </div>
    </body>
</html>
