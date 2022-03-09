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
        <%@include file="components/FormStyle.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pet List</title>
    </head>
    <body>
        <%@include file="components/Nav.jsp" %>
        <div class="container listTable">
            <table class="table">
                <h1 class="display-3" style="text-align: center; padding-top: 15px;">Lista de Mascotas</h1>
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Tipo</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Edad (años)</th>
                        <th scope="col">Raza</th>
                        <th scope="col">Color</th>
                        <th scope="col">Acción</th>
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
                                    <a href="updatePet.htm?id=${pet.id}" class="btn btn-warning" style="border-radius: 13px;"><img src="https://img.icons8.com/ios/50/000000/pencil.png" width="25px"/></a>
                                    <a href="deletePet.htm?id=${pet.id}" class="btn btn-danger" style="border-radius: 13px;"><img  src="https://img.icons8.com/ios/50/000000/delete--v1.png" width="25px" /></a> 
                            </td>
                        </tr>    
                    </c:forEach>
                    <tr>
                        <td><a href="formPet.htm" class="rounded-circle"><img src="public/img/iconAdd.png"/></a></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
