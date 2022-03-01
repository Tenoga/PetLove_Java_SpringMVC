<%-- 
    Document   : viewUsuario
    Created on : 14/02/2022, 09:58:49 AM
    Author     : SENA
--%>
<%@page import="models.Dao"%>
<%@page import="java.sql.Connection"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <c:catch var="errorDB">
            <sql:setDataSource driver="com.mysql.jdbc.Driver"
                               url="jdbc:mysql://localhost:3306/petlove"
                               user="root"
                               password=""/>
            <sql:update>
                INSERT INTO pet(id, petTipo, petNombre, petNacimiento, petRaza, petColor) VALUES (
                "${pet.getId()}",
                "${pet.getPetTipo()}",
                "${pet.getPetNombre()}" ,
                "${pet.getPetNacimiento()}",
                "${pet.getPetRaza()}",
                "${pet.getPetColor()}"
                );
            </sql:update>
        </c:catch>
        <c:if test="${not empty errorDB}">
            <div class="alert alert-danger">
                <strong>Se produjo un error:</strong> ${errorDB} <br>
            </div>
        </c:if>
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
                            <td><c:out value="${pet.id}"></c:out></td>
                            <td><c:out value="${pet.petTipo}"></c:out></td>
                            <td><c:out value="${pet.petNombre}"></c:out></td>
                            <td><c:out value="${pet.petNacimiento}"></c:out></td>
                            <td><c:out value="${pet.petRaza}"></c:out></td>
                            <td><c:out value="${pet.petColor}"></c:out></td>
                        </tr>
                    </tbody>
                </table>
                <a href="listPet.htm" class="btn btn-danger">Regresar</a>
            </div>
        </div>
    </body>
</html>
