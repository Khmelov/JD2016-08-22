<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Главная</title>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style>
    .jumbotron {
        background-image: url(img/back.jpg);
        color: #f2f2f2;
    }
    .jumbotron p {
        font-size: 180%;
        font-style: italic;
    }
    </style>
</head>
<body>
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/grechishnikov/index.jsp">Империя обоев</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
                      <li class="active"><a href="/grechishnikov/index.jsp">Главная</a></li>
                      <li><a href="/grechishnikov/controller/?command=catalog">Каталог</a></li>
                      <li><a href="/grechishnikov/contacts.jsp">Контакты</a></li>
          </ul>
          <c:if test="${user == null}">
          <form class="navbar-form navbar-right" role="form" action="signup.jsp">
            <button type="submit" class="btn btn-success">Зарегистрироваться</button>
          </form>
          <form class="navbar-form navbar-right" role="form" action="login.jsp">
            <button type="submit" class="btn btn-info">Войти</button>
          </form>
          </c:if>
          <c:if test="${user != null}">
          <form class="navbar-form navbar-right" role="form" action="controller/?command=order&type=logout" method="post">
            <button type="submit" class="btn btn-danger">Выйти</button>
          </form>
          <form class="navbar-form navbar-right" role="form" action="controller/?command=my" method="post">
            <button type="submit" class="btn btn-info"><c:out value="${user.getLogin()}"/></button>
          </form>
          </c:if>
        </div><!--/.navbar-collapse -->
      </div>
    </div>