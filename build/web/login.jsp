<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/loginCSS.css" rel="stylesheet" type="text/css"/>
           <title>Futbol Retro - Login</title>
           <style>
        body {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
    background-color: #FFFFFF; /* Color blanco */
    background-image: linear-gradient(to right, blue 25%, #FFFFFF 25%, #FFFFFF 50%, green 50%, #FFFFFF 75%, yellow 75%); /* Patrón alternado de colores */
    background-size: 400% 100%; /* Cuatro veces el tamaño necesario para repetir la secuencia */
    animation: gradient 8s linear infinite; /* Animación de desplazamiento */
}

@keyframes gradient {
    0% {
        background-position: 0% 50%; /* Comienza con blanco */
    }
    25% {
        background-position: 100% 50%; /* Cambia a azul */
    }
    50% {
        background-position: 0% 50%; /* Cambia a verde */
    }
    75% {
        background-position: 100% 50%; /* Cambia a amarillo */
    }
    100% {
        background-position: 0% 50%; /* Vuelve a blanco */
    }
}

        </style>
    </head>
    <body>
        <div class="container">
            <div class="login">
                <h2>LOGIN</h2>
                <div class="logo">
                    <img src="img/logo2.png" alt="logo.png"/>
                </div>
                <form action="srvLogin" method="post">
                    <h3>User</h3>
                    <input class="controls" type="text" name="txtusuario" placeholder="Usuario" required>
                    <h3>Password</h3>
                    <input class="controls" type="password" name="txtclave" placeholder="Contraseña" required>
                    <input class="buttons" type="submit" name="accion" value="INGRESAR">
                    <br>
                    <%
                        String mensaje = (String) request.getAttribute("mensaje");
                        if (mensaje != null) {
                            out.print(mensaje);
                        }
                    %>
                </form>
            </div>
            <div class="publicidad">
                <img src="img/loginFondo.jpg" alt="loginFondo.jpg"/>
            </div>
        </div>
    </body>
</html>

