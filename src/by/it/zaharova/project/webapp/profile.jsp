<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=PROFILE" method="POST">

   <fieldset>

         <!-- Form Name -->
                <legend>Объявления ${doctors.first_name}</legend>
                  <% Integer i=0; %>
                  <c:forEach items="${diagnostics}" var="diagnostic">
                     <br />
                     <div class="row">
                       <div class="col-md-1"><% out.print(++i); %></div>
                       <div class="col-md-2">${diagnostic.illness} </div>
                                      <div class="col-md-2">${diagnostic.drugs}</div>
                                      <div class="col-md-1">${diagnostic.operations}</div>
                                      <div class="col-md-2">${diagnostic.procedures}</div>
                                      <div class="col-md-2">${diagnostic.FK_patients}</div>
                                      <div class="col-md-2">${diagnostic.FK_doctors}</div>
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
