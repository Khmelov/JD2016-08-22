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
           <form class="form-account-${account.ID}" action="do?command=MAINUSER" method=POST>
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

<form action="do?command=NEWPAY" method="post">
      С какого счета делать платеж <div><input id="textinput" name="in" type="text" required=""></div>
      Какую сумму <div><input id="textinput" name="sum" type="text" required=""></div>
      На какой счет делать платеж <div><input id="textinput" name="from" type="text" required=""></div><br/>


       <input type="submit" name="button3" value="Совершите платеж" />
   </form>

<%@ include file="include/end-html.jsp" %>
