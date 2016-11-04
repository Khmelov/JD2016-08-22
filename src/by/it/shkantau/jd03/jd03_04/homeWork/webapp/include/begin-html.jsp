<%@ page language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>Airport Project</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <script src="js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <link rel="shortcut icon" href="favicon.ico"/>
</head>

<a href=/shkantau>
<img width="100%" src="include/logo.jpg">
</a>

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
                <a class="navbar-brand" href="/shkantau">Main</a>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="airport?command=ADDFLIGHT">Add flight</a></li>
                    <li><a href="airport?command=STUFFINGCREW">list users</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="airport?command=SignUp">Sign In</a></li>
                    <li><a href="airport?command=Login">Login</a></li>
                    <li><a href="airport?command=Logout">Logout</a></li>
                    <li><a href="/manager/html/list">Tomcat</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </div>


<body>