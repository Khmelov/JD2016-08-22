<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Contacts</title>
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
          <a class="navbar-brand" href="/grechishnikov/index.jsp">Империя обоев</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
                      <li><a href="/grechishnikov/index.jsp">Главная</a></li>
                      <li><a href="/grechishnikov/controller/?command=catalog">Каталог</a></li>
                      <li class="active"><a href="/grechishnikov/contacts.jsp">Контакты</a></li>
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

    <br><br><br><br><br>
    <div class="navbar-collapse collapse">
      <h1>Наши контакты<br><small>Свяжитесь с нами для консультации или приобретения обоев</small></h1>
    </div>
    <br><br>
    <div class="container">
    <h3>
       Мы находимся на пересечении мкада и Партизанского пр-а. Связаться с нами можно по телефону:<br>
       +375 55 555 22 55<br>
       Приезжайте к нам, мы всегда рады видеть вас в нашем магазине :)
    </h3>
    </div>
  </body>
</html>