<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags/menu" prefix="menu" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Duch Airlines</title>
    <meta charset="utf-8">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        /* Set black background color, white text and some padding */
        footer {
            background-color: #555;
            color: white;
            padding: 15px;
        }
    </style>


</head>
<body>
<%--<img width="100%" height="50%" src="include/logo.jpg">--%>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <div class="navbar-header">
                <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-send"></span>  Duch Airlines</a>
            </div>


        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <%--<li><a href="/airport"><span class="glyphicon glyphicon-home"></span>  Home</a></li>--%>
                <menu:li command="Index" glyphicon="glyphicon glyphicon-home" text="  Home"/>


                <c:if test="${user.role==1}">
                    <menu:li command="ListUsers" glyphicon="glyphicon glyphicon-list-alt" text="  List Users"/>
                    <menu:li command="NewFlight" glyphicon="glyphicon glyphicon-plane" text="  New flight"/>
                    <menu:li command="StuffingCrew" glyphicon="glyphicon glyphicon-bullhorn" text="  Add Flight Crew"/>
                </c:if>
                <c:if test="${user.role==2}">
                    <menu:li command="StuffingCrew" glyphicon="glyphicon glyphicon-bullhorn" text="  Add Flight Crew"/>
                </c:if>

                <%--<li><a href="#"> ${jsp_error}</a></li>--%>


            </ul>

            <ul class="nav navbar-nav navbar-right">
                <c:if test="${user==null}">
                    <menu:li command="Login" glyphicon="glyphicon glyphicon-log-in" text=" Login"/>
                    <menu:li command="SignUp" glyphicon="glyphicon glyphicon-user" text=" SignUp"/>
                    <%--<li><a href="airport?command=Login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>--%>
                    <%--<li><a href="airport?command=SignUp"><span class="glyphicon glyphicon-user"></span> SignUp</a></li>--%>
                </c:if>
                <c:if test="${user!=null}">
                    <li><a href="#" data-toggle="tooltip" data-placement="bottom" title="${curUser}"><span class="glyphicon glyphicon-check"></span>  user=${user.login}</a></li>
                    <menu:li command="Logout" glyphicon="glyphicon glyphicon-log-out" text=" Logout"/>
                    <menu:li command="Profile" glyphicon="glyphicon glyphicon-user" text=" Profile"/>
                    <%--<li><a href="airport?command=Logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>--%>
                    <%--<li><a href="airport?command=Profile"><span class="glyphicon glyphicon-user"></span> Profile</a></li>--%>
                </c:if>
            </ul>
        </div>
    </div>
</nav>

<div class="row content">
    <div class="col-sm-1 sidenav"></div>
    <div class="col-sm-8 text-left">