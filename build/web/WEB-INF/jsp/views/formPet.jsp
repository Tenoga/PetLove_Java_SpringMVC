<%-- 
    Document   : formPet
    Created on : 14/02/2022, 08:24:10 AM
    Author     : SENA
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pet</title>
    </head>
    <body>
        <%@include file="components/Nav.jsp" %>
        <div class="container mt-5">
            <div class="p-4 m-auto w-75 bg-primary bg-opacity-25 rounded">
                <h1 style="text-align: center;">Crear Mascota</h1>
                <form:errors path ="*" element="div" cssClass="alert alert-danger"></form:errors>
                <form:form commandName="pet">
                    <div class="form-group">
                        <form:label path="petTipo">Tipo de Mascota</form:label>
                        <form:select path="petTipo">
                            <form:option value="Canino">Canino</form:option>
                            <form:option value="Felino">Felino</form:option>
                            <form:option value="Ave">Ave</form:option>
                            <form:option value="Pez">Pez</form:option>
                            <form:option value="Roedor">Roedor</form:option>
                        </form:select>
                    </div>                    
                    <div class="form-group">
                        <form:label path="petNombre" cssClass="label-input100">Nombre de la mascota:</form:label>
                        <form:input path="petNombre" cssClass="input100"></form:input>
                        </div>
                        <div class="form-group">
                        <form:label path="petNacimiento">Fecha de Nacimiento:</form:label>
                        <form:input path="petNacimiento"></form:input>
                        </div>
                        <div class="form-group">
                        <form:label path="petRaza">Raza/Tipo:</form:label>
                        <form:input path="petRaza"></form:input>
                        </div>
                        <div class="form-group">
                        <form:label path="petColor">Color:</form:label>
                        <form:input path="petColor"></form:input>
                        </div>
                        <div class="row">
                            <div class="col">
                            <form:button name="enviar" Class="btn btn-success">Enviar</form:button> 
                            </div>
                            <div class="col">
                                <a href="index.htm" class="btn btn-danger">Regresar</a>                     
                            </div>
                        </div>
                </form:form>
            </div>
        </div>
    </body>
</html>
