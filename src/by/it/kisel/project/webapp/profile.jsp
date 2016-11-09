<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=PROFILE" method="POST">

   <fieldset>

         <!-- Form Name -->
                <legend>Объявления ${persons.firstName}</legend>
                  <% Integer i=0; %>
                  <c:forEach items="${roomss}" var="rooms">
                     <br />
                     <div class="row">
                       <div class="col-md-1"><% out.print(++i); %></div>
                       <div class="col-md-1">${rooms.roomCount} </div>
                       <div class="col-md-2">${rooms.quality}</div>
                       <div class="col-md-3">${rooms.priceForDay}</div>
                       <div class="col-md-2">${rooms.conditioner}</div>
                       <div class="col-md-3">${rooms.description}</div>
                     </div>
                  </c:forEach>


        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="LogoutButton"></label>
            <div class="col-md-4">
                <button id="LogoutButton" name="LogoutButton" value="1" class="btn btn-inverse">Завершить сеанс</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
