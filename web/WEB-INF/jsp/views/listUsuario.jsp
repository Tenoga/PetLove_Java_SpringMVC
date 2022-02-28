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
                <a href="formUsuario.htm" class="btn btn-primary">Crear Usuario</a>
                <table id="user" class="table table-striped table-bordered" style="width:100%">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Correo</th>
                            <th>Edad</th>
                            <th>Telefono</th>
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
                        </tr>    
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
