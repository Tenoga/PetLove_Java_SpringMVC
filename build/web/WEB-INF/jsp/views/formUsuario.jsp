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
                        <h3>Usuario</h3>
                        <p>Estas a unos cuantos clicks de crear tu usuario!</p>
                        <!--Boton de login sin usar-->
                        <!--<input type="submit" name="" value="Login"/><br/>-->
                    </div>
                    <div class="col-md-9 register-right">
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <h3 class="register-heading display-4">Crear Usuario</h3>
                                <div class="row register-form">
                                    <div class="col-md-6">
                                        <img src='<c:url value="public/img/usuarioPet.png"></c:url>'  > </img>
                                    </div>
                                    <div class="col-md-6">
                                    <form:form commandName="usuario" method="POST" enctype="multipart/form-data">
                                        <form:errors path = "*" element="div" cssClass="alert alert-danger"></form:errors>


                                            <div class="form-group">
                                            <form:label path="nombre" >Nombre de usuario:</form:label>                      
                                            <form:input path="nombre" class="form-control" placeholder="Nombre de Usuario *" value="" required="required"></form:input>   
                                            </div>
                                            <div class="form-group">
                                            <form:label path="correo">Correo:</form:label>
                                            <form:input path="correo" class="form-control"  placeholder="Correo *" value="" required="required"></form:input>
                                            </div>
                                            <div class="form-group">
                                            <form:label path="edad">Edad:</form:label>
                                            <form:input path="edad" class="form-control" placeholder="Edad *" value="" required="required"></form:input>
                                            </div>
                                            <div class="form-group">
                                            <form:label path="telefono">Telefono:</form:label>
                                            <form:input path="telefono" class="form-control" placeholder="Telefono *" value=""  required="required"></form:input>
                                            </div>
                                            <div class="form-group">
                                            <form:label path="foto">Foto:</form:label>
                                            <form:input path="foto" class="form-control" placeholder="Foto *" type="file" required="required"></form:input>
                                            </div>
                                            <div class="row">
                                                <div class="col">
                                                    <button type="submit" class="btnRegister">Crear</button>
                                                </div>
                                                <div class="col">
                                                    <a href="listUsuario.htm" class="btnBack btn" >Regresar</a> 
                                                </div>
                                            </div>
                                        </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>