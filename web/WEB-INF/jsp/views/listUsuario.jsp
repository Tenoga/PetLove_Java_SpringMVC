<%-- 
    Document   : listUsuario
    Created on : 28/02/2022, 08:24:10 AM
    Author     : SENA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="components/Bootstrap.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Users</title>
    </head>
    <body>
        <%@include file="components/Nav.jsp" %>
        <div class="container mt-5">
            <div class="p-4 m-auto w-75 bg-primary bg-opacity-25 rounded">
                <h1 style="text-align: center;">Lista de Usuarios</h1>
                <table id="user" class="table table-striped table-bordered" style="width:100%">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Correo</th>
                            <th>Edad</th>
                            <th>Telefono</th>
                            <th>Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${user}" var="user"  >
                        <tr>
                            <td><c:out value="${user.id}"></c:out></td>
                            <td><c:out value="${user.nombre}"></c:out></td>
                            <td><c:out value="${user.correo}"></c:out></td>
                            <td><c:out value="${user.edad}"></c:out></td>
                            <td><c:out value="${user.telefono}"></c:out></td>
                            <td>
                                <a href="updateCliente.htm?id=${user.id}" class="btn btn-warning"><img src="https://img.icons8.com/ios/50/000000/pencil.png" width="25px"/></a>
                                <a href="deleteUsuario.htm?id=${user.id}" class="btn btn-danger"><img  src="https://img.icons8.com/ios/50/000000/delete--v1.png" width="25px" /></a>
                            <td>
                        </tr>    
                        </c:forEach>
                        <tr>
                            <td><a href="formUsuario.htm" class="btn btn-info"><img src="https://img.icons8.com/external-line-adri-ansyah/64/000000/external-plus-essentials-ui-line-adri-ansyah.png" width="25px" height="25px"/></a></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
