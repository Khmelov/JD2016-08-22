<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
          <form class="navbar-form navbar-right" role="form" action="signup.jsp">
            <button type="submit" class="btn btn-danger">Зарегистрироваться</button>
          </form>
          <form class="navbar-form navbar-right" role="form" action="login.jsp">
            <button type="submit" class="btn btn-success">Войти</button>
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </div>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1>Добро пожаловать в "Империю обоев"!</h1>
        <p>Мы рады приветствовать вас на страницах нашего магазина. У нас представлен огромный выбор обоев любого класса, так что даже самый требовательный и придирчевый покупатель уйдет от нас удовлетворенным. Больше об ассартименте вы можете узнать в нашем каталоге.</p>
        <p><a class="btn btn-primary btn-lg" href="/grechishnikov/catalog.jsp" role="button">Узнать больше &raquo;</a></p>
      </div>
    </div>

    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h2>Новое поступление</h2>
          <p>Мы рады представить вам абсолютно новые коллекции обоев, с которыми вы можете ознакомиться в нашем каталоге.</p>
          <p><a class="btn btn-default" href="/grechishnikov/catalog.jsp" role="button">Узнать больше &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2>Контакты</h2>
          <p>Узнать расположение наших магазинов можно в разделе контакты.</p>
          <p><a class="btn btn-default" href="/grechishnikov/contacts.jsp" role="button">Узнать больше &raquo;</a></p>
       </div>
        <div class="col-md-4">
          <h2>Акции</h2>
          <p>Скидки, акции и специальные предложения вы можете просмотреть в нашем каталоге.</p>
          <p><a class="btn btn-default" href="/grechishnikov/catalog.jsp" role="button">Узнать больше &raquo;</a></p>
        </div>
      </div>

      <hr>

      <footer>
        <p>&copy; Империя обоев, 2016</p>
      </footer>
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
  </body>
</html>