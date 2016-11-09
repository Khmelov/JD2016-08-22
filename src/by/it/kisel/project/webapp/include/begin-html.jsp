<%@ taglib tagdir="/WEB-INF/tags/menu" prefix="menu" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="ru">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>Hotels</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <script src="js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head>
<body>

<div class="container">

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
            <a class="navbar-brand" href=".">Главная</a>
          </div>
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <c:if test = "${persons.FK_role==2}">
               <menu:li command="CreateOrder" text="Сделать заказ"/>
               <menu:li command="ShowOrdersForUsers" text="Заказы"/>
               <menu:li command="ShowStatus" text="Статус"/>
              </c:if>
               <c:if test = "${persons.FK_role==1}">
               <menu:li command="CreateRoom" text="Добавить комнату"/>
               <menu:li command="ShowPersons" text="Список пользователей"/>
               <menu:li command="ShowOrders" text="Заказы"/>
               <menu:li command="ShowStatus" text="Статус"/>
               <menu:li command="CreateStatus" text="Обновить статус"/>
               </c:if>

            </ul>
            <ul class="nav navbar-nav navbar-right">

               ${persons==null?
               "<li><a href='do?command=SignUp'>Зарегистрироваться</a></li>"
               :
               "<li></li>"
               }
              <!--
              <li><a href='do?command=Login'>Вход</a></li>
              <li><a href='do?command=Profile'>Профиль</a></li>
              Эти две команды можно показать как одну:
              -->
              <c:choose>
                 <c:when test="${persons==null}"><menu:li command="Login" text="Вход"/></c:when>
                 <c:otherwise><menu:li command="Profile" text="Профиль"/></c:otherwise>
              </c:choose>
              <li><a href="/manager/html/list">Tomcat</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
<img width = "100%" src="include/reception.jpg">
      </div>



