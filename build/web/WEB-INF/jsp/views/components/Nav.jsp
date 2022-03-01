<%-- 
    Document   : Nav
    Created on : 3/02/2022, 08:02:36 AM
    Author     : SENA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


         <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand p-3" href="#">PetLove</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="index.htm">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="listUsuario.htm">Usuarios</a>
                </li>
                <li class="nav-item">
                     <a class="nav-link" href="listPet.htm">Mascotas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Adoptar</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">#</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">#</a>
                </li>
                
              </ul>
            </div>
          </nav>

