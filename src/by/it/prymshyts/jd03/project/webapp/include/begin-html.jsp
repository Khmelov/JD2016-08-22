<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="ru">
    <title>InfoPortal</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Cache-Control" content="no-cache">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<!-- Static navbar, смотрите пример тут: http://bootstrap-3.ru/examples/navbar/ -->

<nav class="navbar navbar-default navbar-top" role="navigation">
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
                <li><a href="do?command=CreateArticle">Создать статью</a></li>
                <li><a href="do?command=ShowArticles">Список статей</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                ${user == null ?
                "
                <li><a href='do?command=SignUp'>Зарегистрироваться</a>
                </li><li><a href='do?command=Login'>Войти</a></li>
                "
                :
                "
                <li><a href='do?command=ShowUsers'>Список пользователей</a></li>
                <li><a href='do?command=Profile'>Профиль</a></li>
                <li><a href='do?command=LogOut'>Выйти</a></li>
                "
                }
                <li><a href="/manager/html/list">Tomcat</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>

<div class="container main">
    <div class="row">
        <div class="col-ns-12">