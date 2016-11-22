<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=Profile" method="POST">

   <fieldset>

        <!-- Form Name -->
        <legend>Объявления ${user.login}</legend>
        <div class="row">
             <div class="col-md-3">Model</div>
             <div class="col-md-3">Car body style</div>
             <div class="col-md-3">Color</div>
             <div class="col-md-3">Price</div>
             </div>
          <c:forEach items="${ads}" var="ad">
             <br />
             <div class="row">
             <div class="col-md-3">${ad.FK_Model} </div>
             <div class="col-md-3">${ad.FK_Car_body}</div>
             <div class="col-md-3">${ad.FK_Color}</div>
             <div class="col-md-3">${ad.price}</div>
             </div>
          </c:forEach>
        <br><br>
        <t:paginator step="10" count="${adCount}" urlprefix="?command=PROFILE&startNumber="/>

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
