<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   <p>Актуальные счета</p>

   <div class="row">
       <b>
           <div class=col-md-2>ID/Номер счета</div>
           <div class=col-md-1>Баланс</div>


       </b>
      </div>
      <br>

      <c:forEach items="${accounts}" var="account">
           <div class="row">
           <form class="form-account-${account.ID}" action="do?command=PUTMONEY" method=POST>
               <div class=col-md-2>
                   <input id="account_id_${account.ID}" name="ID" type="text"
                   value="${account.ID}" class="form-control input-md">
               </div>
               <div class=col-md-1>
                               <input id="textinput" name="Balance" type="text"
                               value="${account.balance}" class="form-control input-md">
                           </div>

           </form>
           </div>
      <br>
      </c:forEach>

<form action="do?command=PUTMONEY" method="post">
      Какую сумму <div><input id="textinput" name="putsum" type="text" required=""></div>
      На какой счет положить деньги <div><input id="textinput" name="putfrom" type="text" required=""></div><br/>


       <input type="submit" name="button5" value="Положить деньги" />
   </form>

<%@ include file="include/end-html.jsp" %>
