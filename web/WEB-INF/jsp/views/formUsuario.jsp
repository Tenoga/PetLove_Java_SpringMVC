<%-- 
    Document   : formUsuario
    Created on : 14/02/2022, 08:40:36 AM
    Author     : SENA
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="components/Bootstrap.jsp" %>
        <%@include file="components/FormStyle.jsp" %>
        <title>Crear Usuario</title>
    </head>
    <body>
        <%@include file="components/Nav.jsp" %>
        <div class=" register">
            <div class="row">
                <div class="col-md-3 register-left">


                    <img src='<c:url value="public/img/petIcon.png"></c:url>'> </img>
                        <h3>Adopción</h3>
                        <p>Estas a unos cuantos clicks de adoptar tu mascota!</p>
                        <!--Boton de login sin usar-->
                        <!--<input type="submit" name="" value="Login"/><br/>-->
                    </div>
                    <div class="col-md-9 register-right">
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <h3 class="register-heading">Adopta tu Mascota</h3>
                                <div class="row register-form">
                                    <div class="col-md-6">
                                        <img src='<c:url value="public/img/pets.png"></c:url>' width="450px"> </img>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Nombre de Usuario *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Correo *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="email" class="form-control" placeholder="Correo *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" minlength="10" maxlength="10" name="txtEmpPhone" class="form-control" placeholder="Telefono *" value="" />
                                        </div>
                                        <input type="submit" class="btnRegister"  value="Adoptar"/>
                                        
                                        
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container mt-5">
                <div class="p-4 m-auto w-50 bg-primary bg-opacity-25 rounded">
                    <h1 style="text-align: center;">Crear Usuario</h1>
                <form:form commandName="usuario" method="POST">
                    <form:errors path = "*" element="div" cssClass="alert alert-danger"></form:errors>
                        <div class="form-group">
                        <form:label path="nombre" >Nombre de usuario</form:label>                      
                        <form:input path="nombre" class="form-control" placeholder="Juan Carallo" ></form:input>                     
                        </div>
                        <div class="form-group">
                        <form:label path="correo">Correo:</form:label>
                        <form:input path="correo" class="form-control" placeholder="juancorreo@correo.com" ></form:input>
                        </div>
                        <div class="form-group">
                        <form:label path="edad">Edad:</form:label>
                        <form:input path="edad" class="form-control" placeholder="25" ></form:input>
                        </div>
                        <div class="form-group">
                        <form:label path="telefono">Telefono:</form:label>
                        <form:input path="telefono" class="form-control" placeholder="315-458-67-34" ></form:input>
                        </div>
                        <div class="row m-4">
                            <div class="col">
                            <form:button name="Enviar" value="Crear Usuario" class="btn btn-success" >Crear</form:button>                         
                            </div>
                            <div class="col">
                                <a href="listUsuario.htm" class="btn btn-danger">Regresar</a>                     
                            </div>
                        </div>
                </form:form>
                </body>
                </html>
