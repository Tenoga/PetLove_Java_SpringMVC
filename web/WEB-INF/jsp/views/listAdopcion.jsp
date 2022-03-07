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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Adopcion</title>
    </head>
    <body>
        <%@include file="components/Nav.jsp" %>
        <div class="container mt-5">
            <div class="p-4 m-auto w-75 bg-primary bg-opacity-25 rounded">
                <h1 style="text-align: center;">Lista de Adopciones</h1>
                <table id="user" class="table table-striped table-bordered" style="width:100%">
                    <thead>
                        <tr>
                            <th>ID Adopcion</th>
                            <th>ID Usuario</th>
                            <th>ID Mascota</th>
                            <th>Fecha de Adopcion</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${adopt}" var="datos">
                        <tr>
                            <td><c:out value="${datos.adopt_id}"></c:out></td>
                            <td><c:out value="${datos.user_id}"></c:out></td>
                            <td><c:out value="${datos.pet_id}"></c:out></td>
                            <td><c:out value="${datos.adopt_date}"></c:out></td>
                            <td>
                                <a href="updateAdopt.htm?id=${datos.id}" class="btn btn-warning"><img src="https://img.icons8.com/ios/50/000000/pencil.png" width="25px"/></a>
                                <a href="deleteAdopt.htm?id=${datos.adopt_id}" class="btn btn-danger"><img  src="https://img.icons8.com/ios/50/000000/delete--v1.png" width="25px" /></a>
                            <td>
                        </tr>    
                        </c:forEach>
                        <tr>
                            <td><a href="formAdopcion.htm" class="btn btn-info"><img src="https://img.icons8.com/external-line-adri-ansyah/64/000000/external-plus-essentials-ui-line-adri-ansyah.png" width="25px" height="25px"/></a></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
