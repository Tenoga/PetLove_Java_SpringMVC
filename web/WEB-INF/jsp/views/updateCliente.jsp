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
        <title>Crear Usuario</title>
    </head>
    <body>
        <%@include file="components/Nav.jsp" %>
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
                            <form:button name="Enviar" value="Crear Usuario" class="btn btn-success" >Actualizar</form:button>                         
                            </div>
                            <div class="col">
                                <a href="listUsuario.htm" class="btn btn-danger">Cancelar</a>                     
                            </div>
                        </div>
                </form:form>
                </body>
                </html>
