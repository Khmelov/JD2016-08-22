<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="ru">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>Заказ талонов</title>
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
            
          </div>
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><a href="do?command=INDEX">Главная</a></li>

              ${user==null?
                             "<li><a href='do?command=SIGNIN'>Заказать талон</a></li>"
                                  :
                             "<li><a href='do?command=TAKETALON'>Заказать талон</a></li>"
                             }

            </ul>
            <ul class="nav navbar-nav navbar-right">

              <li><a href="do?command=SIGNUP">Зарегистрироваться</a></li>
              ${user==null?
                              "<li><a href='do?command=SIGNIN'>Войти</a></li>"
                                  :
                              "<li><a href='do?command=MYTALON'>Мои талоны</a></li>"
                            }
               ${user==null?
                              ""
                                  :
                              "<li><a href='do?command=SIGNOUT'>Выйти</a></li>"
                            }
              <li><a href="/manager/html/list">Tomcat</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </div>


