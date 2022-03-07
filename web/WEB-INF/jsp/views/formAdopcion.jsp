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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adopt</title>
    </head>
    <body>
        <%@include file="components/Nav.jsp" %>
        <div class="container mt-5">
            <div class="p-4 m-auto w-50 bg-primary bg-opacity-25 rounded">
                <h1 style="text-align: center;">Adoptar Mascota ${datos.pet_id}</h1>
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
            </div>
        </div>
    </body>
</html>
