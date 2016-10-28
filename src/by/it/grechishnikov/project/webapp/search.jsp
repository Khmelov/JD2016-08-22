<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Search</title>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
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
          <a class="navbar-brand" href="http://localhost:8080/grechishnikov/index.jsp">Империя обоев</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
                      <li><a href="http://localhost:8080/grechishnikov/index.jsp">Главная</a></li>
                      <li class="active"><a href="http://localhost:8080/grechishnikov/controller/?command=catalog">Каталог</a></li>
                      <li><a href="http://localhost:8080/grechishnikov/contacts.jsp">Контакты</a></li>
                    </ul>
          <form class="navbar-form navbar-right" role="form" action="signup.jsp">
            <button type="submit" class="btn btn-danger">Зарегистрироваться</button>
          </form>
          <form class="navbar-form navbar-right" role="form" action="login.jsp">
            <button type="submit" class="btn btn-success">Войти</button>
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </div>
    <br><br><br><br>
    <div class="navbar-collapse collapse">

    <form class="navbar-form navbar-right" role="form" action="controller/?command=search" method="post">
       <div class="form-group">
        <input type="search" placeholder="Немецкие обои" class="form-control">
       </div>
       <button type="submit" class="btn btn-success">Поиск</button>
    </form>
    <h1>Результаты поиска:<br><small>Выберите понравившиеся вам обои и нажмите "Оформить заказ".</small></h1>
    </div>

    <table class="table table-hover table-bordered">
      <tr>
        <th>#</th>
        <th>Название</th>
        <th>Описание</th>
        <th>Цена</th>
        <th>Заказать</th>
      </tr>
      <tr>
        <td>1</td>
        <td>Первые обои</td>
        <td>Немецкие обои</td>
        <td>100</td>
        <td class="col-md-2"><button type="button" class="btn btn-success">Оформить заказ</button></td>
      </tr>
      <tr>
        <td>2</td>
        <td>Вторые обои</td>
        <td>Итальянские обои</td>
        <td>200</td>
        <td class="col-md-2"><button type="button" class="btn btn-success">Оформить заказ</button></td>
        </tr>
      <tr>
        <td>3</td>
        <td>Третьи обои</td>
        <td>Российские обои</td>
        <td>300</td>
        <td class="col-md-2"><button type="button" class="btn btn-success">Оформить заказ</button></td>
      </tr>
    </table>
  </body>
</html>