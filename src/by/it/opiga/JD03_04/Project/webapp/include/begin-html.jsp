<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.io.*"%>
<%@ page import="java.lang.*"%>
<% String title= "";

		String userLogin = (String)session.getAttribute("userLogin");
        if (userLogin==null) {
                        title ="User not logged in";
                        }
                        else {
                   title = "Welcome to website " +userLogin;
                   }
%>
                  <%
                  String userName="";
                  Cookie[]cookies=request.getCookies();
                                  if(cookies!=null)
                                  {
                                      for (Cookie cookie:cookies) {
                                          if(cookie.getName().equals("user"))
                                              userName="Hello from cookie "+cookie.getValue()+"!    ";
                                              if(cookie.getName().equals("pass"))
                                                   userName=userName+"password:  "+cookie.getValue();

                                      }
                                  }

                  %>
<!DOCTYPE html>
<html>
<head lang="ru">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>Заказ номера</title>
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
            <a class="navbar-brand" href="do?command=Index">Главная</a>
          </div>
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><a href="do?command=CreateOrder">Оставить заявку</a></li>
              <li><a href="do?command=ShowUsers">Список пользователей</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="do?command=SignUp">Зарегистрироваться</a></li>

             <!-- если есть юзер (не налл, будет печптпться профиль, если нгдд то юзер-->

              <li><a href="do?command=Login">Войти</a></li>
              <li><a href="do?command=Logout">Выйти</a></li>
              <li><a href="/manager/html/list">Tomcat</a></li>
            </ul>
          </div><!--/.nav-collapse -->
          <div>
                      <%
                      out.print(title);
                      %>
                    <br>
                  <%
                        out.print(userName);
                       %>

                  </div>

        </div><!--/.container-fluid -->


      </div>



