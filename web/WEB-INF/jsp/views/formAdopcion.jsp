<%-- 
    Document   : formAdopcion
    Created on : 3/03/2022, 07:24:03 AM
    Author     : SENA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="components/Bootstrap.jsp" %>
        <link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' rel='stylesheet'>
        <script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
        <script type='text/javascript' src='https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js'></script>
        <script type='text/javascript' src='https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js'></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="components/FormStyle.jsp" %>
        <title>Adopt</title>
    </head>
    <body>
        <%@include file="components/Nav.jsp" %>
        <div class=" register">
            <div class="row">
                <div class="col-md-3 register-left">
                    <img src='<c:url value="public/img/petIcon.png"></c:url>'> </img>
                        <h3>Usuario</h3>
                        <p>Estas a unos cuantos clicks de crear tu usuario!</p>
                    </div>
                    <div class="col-md-9 register-right">
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <h3 class="register-heading display-4">Adopta una mascota</h3>
                                <div class="row register-form">
                                    <div class="col-md-6">
                                        <img src='<c:url value="public/img/usuarioPet.png"></c:url>'  > </img>
                                    </div>
                                    <div class="col-md-6">
                                    <form:form commandName="adopt" method="POST">
                                        <form:errors path = "*" element="div" cssClass="alert alert-danger"></form:errors>
                                            <div class="form-group">
                                            <form:label path="adopt_id">Codigo de Adopcion:</form:label>                      
                                            <form:input path="adopt_id" disabled="true" class="form-control"></form:input>   
                                            </div>
                                            <div class="form-group">
                                            <form:label path="user_id">Nombre de Usuario:</form:label>
                                            <form:select path="user_id" class="form-select">
                                                <c:forEach items="${user}" var="user">
                                                    <option value="${user.id}">${user.nombre}</option>
                                                </c:forEach>
                                            </form:select>
                                        </div>
                                        <div class="form-group">
                                            <form:label path="adopt_date">Fecha de Adopción</form:label>
                                            <form:input path="adopt_date" type="date" class="form-control"></form:input>
                                            </div>
                                            <div class="form-group">
                                            <form:label path="pet_id">Mascota</form:label>
                                            <form:select path="pet_id" class="form-select">
                                                <c:forEach  items="${pet}" var="pet">
                                                    <option value="${pet.id}">${pet.petNombre}</option>
                                                </c:forEach>
                                            </form:select>
                                        </div>
                                        <div class="row">
                                            <div class="col">
                                                <button type="submit" class="btnRegister">Crear</button>
                                            </div>
                                            <div class="col">
                                                    <a href="listAdopcion.htm" class="btnBack btn">Regresar</a> 
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
