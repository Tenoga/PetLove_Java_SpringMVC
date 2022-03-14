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
        <title>List Users</title>

    </head>
    <body>
        <%@include file="components/Nav.jsp" %>
        <div class="container listTable">
            <table class="table">
                <h1 class="display-3" style="text-align: center; padding-top: 15px;">Lista de Usuarios</h1>
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Correo</th>
                        <th scope="col">Edad</th>
                        <th scope="col">Telefono</th>
                        <th scope="col">Foto</th>
                        <th scope="col">Acción</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${user}" var="user"  >
                        <tr>
                            <th scope="row"><c:out value="${user.id}"></c:out></th>
                            <td><c:out value="${user.nombre}"></c:out></td>
                            <td><c:out value="${user.correo}"></c:out></td>
                            <td><c:out value="${user.edad}"></c:out></td>
                            <td><c:out value="${user.telefono}"></c:out></td>
                            <td><img class="rounded-circle" style="" height="84px" width="84px" src='<c:url value="${user.foto}" ></c:url>'/></td>
                                <td>
                                    <a href="updateCliente.htm?id=${user.id}" class="btn btn-warning" style="border-radius: 13px;"><img src="https://img.icons8.com/ios/50/000000/pencil.png" width="25px"/></a>
                                    <a href="deleteUsuario.htm?id=${user.id}&foto=${user.foto}" class="btn btn-danger" style="border-radius: 13px;"><img  src="https://img.icons8.com/ios/50/000000/delete--v1.png" width="25px" /></a>
                            </td>
                        </tr>    
                    </c:forEach>
                    <tr>
                        <td><a href="formUsuario.htm" class="rounded-circle"><img src="public/img/iconAdd.png"/></a></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>