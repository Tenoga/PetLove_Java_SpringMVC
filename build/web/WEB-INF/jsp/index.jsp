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
            <div class="col-5 register-left" style="margin-top: -0.5rem;">
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
        <!-- Footer -->
    <footer class="bg-dark text-center text-white">
        <!-- Grid container -->
        <div class="container p-4">
            <!-- Section: Social media -->
            <section class="mb-4">
                <!-- Facebook -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                   ><i class="fab fa-facebook-f"></i
                    ></a>

                <!-- Twitter -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                   ><i class="fab fa-twitter"></i
                    ></a>

                <!-- Google -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                   ><i class="fab fa-google"></i
                    ></a>

                <!-- Instagram -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                   ><i class="fab fa-instagram"></i
                    ></a>

                <!-- Linkedin -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                   ><i class="fab fa-linkedin-in"></i
                    ></a>

                <!-- Github -->
                <a class="btn btn-outline-light btn-floating m-1" href="#!" role="button"
                   ><i class="fab fa-github"></i
                    ></a>
            </section>
            <!-- Section: Social media -->

            <!-- Section: Form -->
            <section class="">
                <form action="">
                    <!--Grid row-->
                    <div class="row d-flex justify-content-center">
                        <!--Grid column-->
                        <div class="col-auto">
                            <p class="pt-2">
                                <strong>Sign up for our newsletter</strong>
                            </p>
                        </div>
                        <!--Grid column-->

                        <!--Grid column-->
                        <div class="col-md-5 col-12">
                            <!-- Email input -->
                            <div class="form-outline form-white mb-4">
                                <input type="email" id="form5Example21" class="form-control" />
                                <label class="form-label" for="form5Example21">Email address</label>
                            </div>
                        </div>
                        <!--Grid column-->

                        <!--Grid column-->
                        <div class="col-auto">
                            <!-- Submit button -->
                            <button type="submit" class="btn btn-outline-light mb-4">
                                Subscribe
                            </button>
                        </div>
                        <!--Grid column-->
                    </div>
                    <!--Grid row-->
                </form>
            </section>
            <!-- Section: Form -->

            <!-- Section: Text -->
            <section class="mb-4">
                <p>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Sunt distinctio earum
                    repellat quaerat voluptatibus placeat nam, commodi optio pariatur est quia magnam
                    eum harum corrupti dicta, aliquam sequi voluptate quas.
                </p>
            </section>
            <!-- Section: Text -->

            <!-- Section: Links -->
            <section class="">
                <!--Grid row-->
                <div class="row">
                    <!--Grid column-->
                    <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
                        <h5 class="text-uppercase">Links</h5>

                        <ul class="list-unstyled mb-0">
                            <li>
                                <a href="#!" class="text-white">Link 1</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Link 2</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Link 3</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Link 4</a>
                            </li>
                        </ul>
                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
                        <h5 class="text-uppercase">Links</h5>

                        <ul class="list-unstyled mb-0">
                            <li>
                                <a href="#!" class="text-white">Link 1</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Link 2</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Link 3</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Link 4</a>
                            </li>
                        </ul>
                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
                        <h5 class="text-uppercase">Links</h5>

                        <ul class="list-unstyled mb-0">
                            <li>
                                <a href="#!" class="text-white">Link 1</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Link 2</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Link 3</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Link 4</a>
                            </li>
                        </ul>
                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
                        <h5 class="text-uppercase">Links</h5>

                        <ul class="list-unstyled mb-0">
                            <li>
                                <a href="#!" class="text-white">Link 1</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Link 2</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Link 3</a>
                            </li>
                            <li>
                                <a href="#!" class="text-white">Link 4</a>
                            </li>
                        </ul>
                    </div>
                    <!--Grid column-->
                </div>
                <!--Grid row-->
            </section>
            <!-- Section: Links -->
        </div>
        <!-- Grid container -->

        <!-- Copyright -->
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
            © 2020 Copyright:
            <a class="text-white" href="https://mdbootstrap.com/">MDBootstrap.com</a>
        </div>
        <!-- Copyright -->
    </footer>
    <!-- Footer -->
</html>



