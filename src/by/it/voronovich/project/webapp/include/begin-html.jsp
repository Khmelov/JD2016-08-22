<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
    <html>
        <head lang="ru">
            <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
            <meta http-equiv="Cache-Control" content="no-cache">
            <title>Магазин холодильников</title>
            <link href="css/bootstrap.min.css" rel="stylesheet" />
            <script src="js/bootstrap.min.js"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
            <script src="https://code.jquery.com/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        </head>
    <body>
        <div class="container">
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
                    <li><a href="do?command=Catalog">Каталог</a></li>
                    <li><a href="do?command=ShowOrder">Корзина</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="do?command=SignUp">Зарегистрироваться</a></li>
                    ${user==null?
                    "<li><a href='do?command=Login'>Войти</a></li>"
                    :
                    "<li><a href='do?command=Profile'>Личный кабинет</a></li>"
                    }
                    <c:if test="${user.getFK_Role()==1}">
                    <li class="dropdown">
                        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><h5>Кабинет администратора</h5>
                        </button>
                    <ul class="dropdown-menu">
                        <li><a href='do?command=Admincab'>Пользователи</a></li>
                        <li><a href='do?command=AdmincabGood'>Товары</a></li>
                    </ul>
                    </li>
                     </c:if>
                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </div>


