<%-- 
    Document   : listAdopcion
    Created on : 7/03/2022, 09:01:24 AM
    Author     : SENA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="components/Bootstrap.jsp" %>
        <%@include file="components/FormStyle.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Adopcion</title>
    </head>
    <body>
        <%@include file="components/Nav.jsp" %>
        <div class="container listTable">
            <table class="table">
                <h1 class="display-3" style="text-align: center; padding-top: 15px;">Lista de Adopciones</h1>
                <thead>
                    <tr>
                        <th scope="col">ID Adopcion</th>
                        <th scope="col">ID Usuario</th>
                        <th scope="col">ID Mascota</th>
                        <th scope="col">Fecha de Adopcion</th>
                        <th scope="col">Acción</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${adopt}" var="datos">
                        <tr>
                            <th><c:out value="${datos.id}"></c:out></th>
                            <td><c:out value="${datos.nombre}"></c:out></td>
                            <td><c:out value="${datos.petNombre}"></c:out></td>
                            <td><c:out value="${datos.adopt_date}"></c:out></td>
                                <td>
                                    <a href="updateAdopcion.htm?id=${datos.id}" class="btn btn-warning" style="border-radius: 13px;"><img src="https://img.icons8.com/ios/50/000000/pencil.png" width="25px"/></a>
                                    <a href="deleteAdopcion.htm?id=${datos.id}" class="btn btn-danger" style="border-radius: 13px;"><img  src="https://img.icons8.com/ios/50/000000/delete--v1.png" width="25px" /></a>
                            </td>
                        </tr>    
                    </c:forEach>
                    <tr>
                        <td><a href="formAdopcion.htm" class="rounded-circle"><img src="public/img/iconAdd.png"/></a></td>
                    </tr>
                </tbody>
            </table>
        </div>     
    </body>
</html>
