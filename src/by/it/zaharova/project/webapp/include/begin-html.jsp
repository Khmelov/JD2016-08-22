<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="ru">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>Hospital</title>
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
<c:if test = "${patients!=null}">
              <li><a href="do?command=ShowDoctorsForPatients">Доктора</a></li>
</c:if>
<c:if test = "${doctors!=null}">
                  <li><a href="do?command=ShowPatients">Список пациентов</a></li>
                  <li><a href="do?command=CreateDiagnostic">Поставить диагноз</a></li>

              <li><a href="do?command=ShowDiagnostic">Диагнозы</a></li>
</c:if>

            </ul>
            <ul class="nav navbar-nav navbar-right">


               ${patients==null?
                              "<li><a href='do?command=Signup'>Регистрация пациентов</a></li>"
                                 :
                              "<li><a href='do?command=LogOut'>Выход</a></li>"
                            }
              ${doctors==null?
                "<li><a href='do?command=Login'>Вход</a></li>"
                    :
                "<li><a href='do?command=Profile'>Профиль</a></li>"
              }
               <li><a href="/manager/html/list">Tomcat</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
<img width = "100%" src="include/housemd.jpg">
      </div>



