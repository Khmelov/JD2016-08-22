<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
        <script src="js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head>
<body>
    <form class="form-horizontal" action="controller/?command=signup" method="post">
    <fieldset>

    <!-- Form Name -->
    <legend>Регистрация</legend>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Login">Логин</label>
      <div class="col-md-4">
      <input id="Login" name="Login" type="Login" placeholder="Masha" class="form-control input-md">

      </div>
    </div>

    <!-- Password input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Password">Пароль</label>
      <div class="col-md-4">
        <input id="Password" name="Password" type="Password" placeholder="123" class="form-control input-md">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="Email">Email</label>
      <div class="col-md-4">
      <input id="Email" name="Email" type="Email" placeholder="masha@mail.ru" class="form-control input-md">

      </div>
    </div>

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="b1"></label>
      <div class="col-md-4">
        <button id="b1" name="b1" class="btn btn-primary">Ok</button>
      </div>
    </div>

    </fieldset>
    </form>

</body>
</html>