<%-- 
    Document   : viewUsuario
    Created on : 14/02/2022, 09:58:49 AM
    Author     : SENA
--%>
<%@page import="models.Dao"%>
<%@page import="java.sql.Connection"%>
<%@taglib prefix="u" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="components/Bootstrap.jsp" %>
        <title>Lista Usuario</title>
    </head>
    <body>
        <%@include file="components/Nav.jsp" %>
        <%
                try {
                    if (Dao.conecta() != null) {
                        Connection con = Dao.conecta();
                        out.print("Conexion a Base de datos exitosa.");
                    }
                } catch (Exception ex) {
                    out.print("Conexion a Base de datos fallida: " + ex.getMessage());
                }
            %>
        <div class="container mt-5">
            <div class="p-4 m-auto w-75 bg-primary bg-opacity-25 rounded">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Tipo</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Edad (años)</th>
                            <th scope="col">Raza</th>
                            <th scope="col">Color</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><u:out value="${id}"></u:out></td>
                            <td><u:out value="${petTipo}"></u:out></td>
                            <td><u:out value="${petNombre}"></u:out></td>
                            <td><u:out value="${petNacimiento}"></u:out></td>
                            <td><u:out value="${petRaza}"></u:out></td>
                            <td><u:out value="${petColor}"></u:out></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
