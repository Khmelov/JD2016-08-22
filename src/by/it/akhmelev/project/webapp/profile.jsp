<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=PROFILE" method="POST">

   <fieldset>

        <!-- Form Name -->
        <legend>Объявления ${user.login}</legend>
          <c:forEach items="${ads}" var="ad">
             <br />
             <div class="row">
               <div class="col-md-1">${ad.viewNumber}</div>
               <div class="col-md-1">${ad.price} </div>
               <div class="col-md-3">${ad.address}</div>
               <div class="col-md-3">${ad.description}</div>
               <div class="col-md-1">${ad.roomCount}</div>
               <div class="col-md-1">${ad.area}</div>
               <div class="col-md-1">${ad.floor}</div>
               <div class="col-md-1">${ad.floors}</div>
             </div>
          </c:forEach>
        <br><br>
        <t:paginator step="5" count="${adCount}" urlprefix="?command=PROFILE&startNumber="/>

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
