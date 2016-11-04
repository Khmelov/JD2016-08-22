<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>Airport Project</title>

    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" media="screen"
          href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">


    <script src="js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <link rel="shortcut icon" href="favicon.ico"/>
</head>


<div class="container">
    <img width="100%" src="include/logo.jpg">
    <!-- Static navbar, смотрите пример тут: http://bootstrap-3.ru/examples/navbar/ -->

    <div class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/shkantau">Main</a>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <c:if test="${user.role==1}">
                        <li><a href="airport?command=ListUsers">List Users</a></li>
                        <li><a href="airport?command=NewFlight">New flight</a></li>
                        <li><a href="airport?command=StuffingCrew">Add Flight Crew</a></li>
                    </c:if>
                    <c:if test="${user.role==2}">
                        <%--<li><a href="airport?command=NewFlight">New flight</a></li>--%>
                        <li><a href="airport?command=StuffingCrew">Add Flight Crew</a></li>
                    </c:if>

                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <c:if test="${user==null}">
                            <li><a href="airport?command=Login">Login</a></li>
                            <li><a href="airport?command=SignUp">SignUp</a></li>
                        </c:if>
                        <c:if test="${user!=null}">
                            <li><a href="airport?command=Logout">Logout</a></li>
                            <li><a href="airport?command=Profile">Profile</a></li>
                        </c:if>

                    </li>

                    <%--<li><a href="airport?command=SignUp">Sign Up</a></li>--%>
                    <%--<li><a href="airport?command=Login">Login</a></li>--%>
                    <%--<li><a href="airport?command=Logout">Logout</a></li>--%>
                    <%--<li><a href="airport?command=Profile">Profile</a></li>--%>
                    <%--<li><a href="/manager/html/list">Tomcat</a></li>--%>
                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </div>


<body>