<%-- 
    Document   : viewUsuario
    Created on : 14/02/2022, 09:58:49 AM
    Author     : SENA
--%>
<%@page import="models.Dao"%>
<%@page import="java.sql.Connection"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="components/Bootstrap.jsp" %>
        <%@include file="components/FormStyle.jsp" %>
        <title>Lista Usuario</title>
    </head>
    <body>
        <%@include file="components/Nav.jsp" %>

        
        <div class="container mt-5">
            <div class="p-4 m-auto w-75 bg-primary bg-opacity-25 rounded">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Correo</th>
                            <th scope="col">Edad</th>
                            <th scope="col">Telefono</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><c:out value="${ub.id}"></c:out></td>
                            <td><c:out value="${ub.nombre}"></c:out></td>
                            <td><c:out value="${ub.correo}"></c:out></td>
                            <td><c:out value="${ub.edad}"></c:out></td>
                            <td><c:out value="${ub.telefono}"></c:out></td>
                        </tr>
                    </tbody>

                </table>
                <a href="listUsuario.htm" class="btn btn-danger">Regresar</a>
            </div>
        </div>
    </body>
</html>
