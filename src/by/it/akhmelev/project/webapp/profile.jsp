<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form class="form-horizontal" action="do?command=PROFILE" method="POST">

   <fieldset>

        <!-- Form Name -->
        <legend>Объявления ${user.login}</legend>
          <% Integer i=0; %>
          <c:forEach items="${ads}" var="ad">
             <br />
             <div class="row">
               <div class="col-md-1"><% out.print(++i); %></div>
               <div class="col-md-1">${ad.price} </div>
               <div class="col-md-3">${ad.address}</div>
               <div class="col-md-3">${ad.description}</div>
               <div class="col-md-1">${ad.roomCount}</div>
               <div class="col-md-1">${ad.area}</div>
               <div class="col-md-1">${ad.floor}</div>
               <div class="col-md-1">${ad.floors}</div>
             </div>
          </c:forEach>

        <!-- Button -->
        <br><br><br>
        <div class="form-group">
            <label class="col-md-4 control-label" for="LogoutButton"></label>
            <div class="col-md-4">
                <button id="LogoutButton" name="LogoutButton" value="1" class="btn btn-success">Завершить сеанс</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
