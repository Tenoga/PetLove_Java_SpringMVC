<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <!--Importacion de Bootstrap-->
        <%@include file="views/components/Bootstrap.jsp" %>
        <!--Importacion de Estilos-->
        <%@include file="views/components/FormStyle.jsp" %>
        <!---------------------------->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pet Love</title>
    </head>
    <body>
        <!--Importacion de navegador-->
        <%@include file="views/components/Nav.jsp" %>
        <!---------------------------->
        <div class="parallax">
            <div class="col-5 register-left">
                <img src='<c:url value="public/img/petIcon.png"></c:url>'> </img>
                <h3 class="display-4">¡Bienvenido a PetLove!</h3>
                <h5>El mejor website para adoptar tu mascota</h5>
                <!--Boton de login sin usar-->
                <input class="indexInput" type="submit" name="" value="Ingresar"/>
                <input class="indexInput" type="submit" name="" value="Registrar"/>
            </div>
        </div>
        <!------------------Cards Section------------------->
        <div class="container">
            <h1 class="display-4 text-center m-4">Nuestros servicios</h1>
            <p class="text-justify m-4">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</p>
        </div>
        <div class="row py-5 d-flex justify-content-center">
            <div class="col-2">
                <div class="indexCard" style="width: 18rem;">
                    <img class="my-5 mx-auto d-block" src="public/img/petIcon2.png" width="40%">
                    <h4 class="text-center">Acerca de nosotros</h4>
                    <div class="card-body">
                        <p class="card-text text-center mx-3">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                    </div>
                    <a href="#" class="pb-4 d-flex justify-content-center"><button class="btnRegister">Ver Más</button></a>
                </div>
            </div>
            <div class="col-2">
                <div class="indexCard" style="width: 18rem;">
                    <img class="my-5 mx-auto d-block" src="public/img/petServices.png" width="40%">
                    <h4 class="text-center">Nuestros Servicios</h4>
                    <div class="card-body">
                        <p class="card-text text-center mx-3">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                    </div>
                    <a href="#" class="pb-4 d-flex justify-content-center"><button class="btnRegister">Ver Más</button></a>
                </div>
            </div>
            <div class="col-2">
                <div class="indexCard" style="width: 18rem;">
                    <img class="my-5 mx-auto d-block" src="public/img/login.png" width="40%">
                    <h4 class="text-center">Ingresar</h4>
                    <div class="card-body">
                        <p class="card-text text-center mx-3">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                    </div>
                    <a href="#" class="pb-4 d-flex justify-content-center"><button class="btnRegister">Ver Más</button></a>
                </div>
            </div>
            <div class="col-2">
                <div class="indexCard" style="width: 18rem;">
                    <img class="my-5 mx-auto d-block" src="public/img/login.png" width="40%">
                    <h4 class="text-center">Ingresar</h4>
                    <div class="card-body">
                        <p class="card-text text-center mx-3">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                    </div>
                    <a href="#" class="pb-4 d-flex justify-content-center"><button class="btnRegister">Ver Más</button></a>
                </div>
            </div>
        </div>       

        <div class="parallax2"></div>
</html>



