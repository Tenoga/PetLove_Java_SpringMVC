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
        <title>Pet List</title>
    </head>
    <body>
        <%@include file="components/Nav.jsp" %>
        <div class="container mt-5">
            <div class="p-4 m-auto w-75 bg-primary bg-opacity-25 rounded">
                <h1 style="text-align: center;">Lista de Usuarios</h1>
                <a href="formPet.htm" class="btn btn-primary">Crear Mascota</a>
                <table id="user" class="table table-striped table-bordered" style="width:100%">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Tipo</th>
                            <th>Nombre</th>
                            <th>Edad (años)</th>
                            <th>Raza</th>
                            <th>Color</th>
                            <th>Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${pet}" var="pet">
                        <tr>
                            <td><c:out value="${pet.id}"></c:out></td>
                            <td><c:out value="${pet.petTipo}"></c:out></td>
                            <td><c:out value="${pet.petNombre}"></c:out></td>
                            <td><c:out value="${pet.petNacimiento}"></c:out></td>
                            <td><c:out value="${pet.petRaza}"></c:out></td>
                            <td><c:out value="${pet.petColor}"></c:out></td>
                            <td>
                                <a href="updatePet.htm?id=${pet.id}" class="btn btn-warning">Actualizar</a>
                                <a href="deletePet.htm?id=${pet.id}" class="btn btn-danger">Borrar</a> 
                            <td>
                        </tr>    
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
