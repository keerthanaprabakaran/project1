<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<html>
<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
 <%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<body>

<nav class="navbar navbar-inverse">
     <div class="container-fluid">
     <div class="navbar-header">
       <a class="navbar-brand" href="#">FashionWorld</a>
     </div>
     
     
    <c:if test="${sessionScope.loggedIn}">
     
      <ul class="nav navbar-nav">
         <li class="active"><a href="Home">Home</a></li>
         <li><a href="/Cartfrontend/Category">Manage Category</a></li>
         <li><a href="/Cartfrontend/Supplier">Manage Supplier</a></li>
         <li><a href="/Cartfrontend/Product">Manage Product</a></li>
         <li><a href="/Cartfrontend/logout">Logout</a></li>
            
        </ul>
       
       <div class="nav navbar-nav navbar-right">
       <a href="#">${sessionScope.username}</a>
       </div>
    </c:if>
     
      <c:if test="${!sessionScope.loggedIn}">
     
      <ul class="nav navbar-nav">
        <li><a href="/Cartfrontend/Home">Home</a></li>
        <li><a href="/Cartfrontend/Login">Login</a></li>
        <li><a href="/Cartfrontend/AboutUs">AboutUs</a></li>
        <li><a href="/Cartfrontend/Register">Register</a></li>
        <li><a href="/Cartfrontend/ContactUs">ContactUs</a></li>
      </ul>
      </c:if>
     
  </div>
</nav>
</body>
</html>