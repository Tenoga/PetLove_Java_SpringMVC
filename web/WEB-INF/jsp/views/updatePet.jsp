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
        <%@include file="components/FormStyle.jsp" %>
        <title>Pet</title>
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
                                <h3 class="register-heading display-4">Actualizar Mascota</h3>
                                <div class="row register-form">
                                    <div class="col-md-6">
                                        <img class="rounded" id="fotoPetOld" name="fotoOld" width="80%" src='<c:url value="${pet.petFoto}"></c:url>'  > </img>
                                    </div>
                                    <div class="col-md-6">
                                    <form:form commandName="pet" method="POST" enctype="multipart/form-data">
                                        <form:errors path = "*" element="div" cssClass="alert alert-danger"></form:errors>
                                            <div class="form-group">
                                            <form:label path="petTipo">Tipo de Mascota</form:label>
                                            <form:select path="petTipo" class="form-control"  >
                                                <form:option value="Canino">Canino</form:option>
                                                <form:option value="Felino">Felino</form:option>
                                                <form:option value="Ave">Ave</form:option>
                                                <form:option value="Pez">Pez</form:option>
                                                <form:option value="Roedor">Roedor</form:option>
                                            </form:select>
                                        </div>                    
                                        <div class="form-group">
                                            <form:label path="petNombre">Nombre de la mascota:</form:label>
                                            <form:input path="petNombre" class="form-control" placeholder="Misifu"></form:input>
                                            </div>
                                            <div class="form-group">
                                            <form:label path="petNacimiento">Edad (a??os):</form:label>
                                            <form:input path="petNacimiento" class="form-control" placeholder="15"></form:input>
                                            </div>
                                            <div class="form-group">
                                            <form:label path="petRaza">Raza/Tipo:</form:label>
                                            <form:input path="petRaza" class="form-control" placeholder="Criollo"></form:input>
                                            </div>
                                            <div class="form-group">
                                            <form:label path="petColor">Color:</form:label>
                                            <form:input path="petColor" class="form-control" placeholder="Gris"></form:input>
                                            </div>
                                            <div class="form-group">
                                            <form:label path="petFoto">Foto:</form:label>
                                            <form:input path="petFoto" class="form-control" placeholder="Foto *" type="file"></form:input>
                                            </div>
                                            <div class="row">
                                                <div class="col">
                                                    <button type="submit" class="btnRegister">Actualizar</button>
                                                </div>
                                                <div class="col">
                                                    <a href="listPet.htm" class="btnBack btn" >Regresar</a> 
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
