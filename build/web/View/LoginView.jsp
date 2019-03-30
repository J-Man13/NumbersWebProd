<%-- 
    Document   : LoginView
    Created on : Oct 15, 2018, 9:37:59 AM
    Author     : jafar.j
--%>

<%@page import="Controllers.LoginViewController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include  file="header.html" %>
    <link href="../CSS/LoginView.css" rel="stylesheet">
    <script src="../JS/jquery-3.3.1.js"></script>
    <script src="../JS/LoginViewValidateJS.js"></script>
    
    <div class="container-login">
        <%
            if(LoginViewController.IsLogged(request.getSession()))
                response.sendRedirect("./AdminPanelView.jsp");
        %>   
        <div class="container-secret-form">
            <spawn class="container-secret-form-fraze">Input the secret</spawn><br/>  
            <input id="container-secret-input-id"type="password" name="adminpass" onkeydown="validateSecret(event)"/> 
        </div>
        <div class="container-invalid-secret">
            <spawn id="container-secret-form-error">Invalid Secret</spawn>
        </div>
        <div class="container-load-image">
            <img id="container-secret-form-load-image" src="..\Images\blue_balls.gif">
        </div>
    </div>
    
<%@include  file="footer.html"%>