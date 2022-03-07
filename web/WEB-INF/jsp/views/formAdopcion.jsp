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
        <%@include file="components/FormStyle.jsp" %>
        <link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' rel='stylesheet'>
        <script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
        <script type='text/javascript' src='https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js'></script>
        <script type='text/javascript' src='https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js'></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adopt</title>
    </head>
    <body>
        <%@include file="components/Nav.jsp" %>
        <form:form commandName="adopt"  method="post">
                    <form:errors path ="*" element="div" cssClass="alert alert-danger"></form:errors>

                        <!--------------------------------------------------------------------->


                    <form:label path="adopt_id">Codigo de Adopción:</form:label>
                    <form:input path="adopt_id" class="form-control"></form:input>                    


                        <!--------------------------------------------------------------------->

                    <form:label path="user_id">Nombre de Usuario</form:label>
                    <form:select path="user_id" class="form-control">
                        <c:forEach items="${user}" var="user">
                            <option value="${user.id}">${user.nombre}</option>
                        </c:forEach>
                    </form:select>


                        <!--------------------------------------------------------------------->

                    <form:label path="adopt_date">Fecha de venta:</form:label>
                    <form:input path="adopt_date" type="date" class="form-control"></form:input>

                        <!--------------------------------------------------------------------->  

                    <form:label path="pet_id">Mascota</form:label>
                    <form:select path="pet_id" class="form-control">
                        <c:forEach  items="${pet}" var="datos">
                            <option value="${pet.id}">${pet.petNombre}</option>
                        </c:forEach>
                    </form:select>
                            
                        <!--------------------------------------------------------------------->
                    <form:button name="Submit" value="" class="btn btn-success" >Adoptar</form:button>
                </form:form>
    </body>
</html>
