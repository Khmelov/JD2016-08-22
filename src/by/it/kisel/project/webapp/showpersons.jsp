<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

     <div class="row">
          <b>
              <div class=col-md-1>ID</div>
              <div class=col-md-2>Имя</div>
              <div class=col-md-2>Фамилия</div>
              <div class=col-md-2>Телефон</div>
              <div class=col-md-2>Email</div>
              <div class=col-md-2>Роль</div>
          </b>
         </div>
         <br>
         <!-- Коллекцию listUser мы получаем по get из команды сервлета UserForm -->
         <c:forEach items="${personss}" var="persons">
              <div class="row">
              <form class="form-persons-${persons.ID}" action="do?command=ShowPersons" method=POST>
                  <div class=col-md-1>
                      <input id="persons_id_${persons.ID}" name="ID" type="text"
                      value="${persons.ID}" class="form-control input-md">
                  </div>
                  <div class=col-md-2>
                      <input id="textinput" name="FirstName" type="text"
                      value="${persons.firstName}" class="form-control input-md">
                  </div>
                  <div class=col-md-2>
                      <input id="textinput" name="SecondName" type="text"
                      value="${persons.secondName}" class="form-control input-md">
                  </div>
                  <div class=col-md-2>
                      <input id="textinput" name="PhoneNumber" type="text"
                      value="${persons.phoneNumber}" class="form-control input-md">
                  </div>
                  <div class=col-md-2>
                      <input id="textinput" name="Email" type="text"
                      value="${persons.email}" class="form-control input-md">
                  </div>
                  <div class=col-md-1>
                      <input id="textinput" name="FK_role" type="text"
                       value="${persons.FK_role}" class="form-control input-md">
                  </div>



              <!--    <div class=col-md-2>
                      <select id="role" name="FK_role" class="form-control">
                          <c:forEach items="${roles}" var="role">
                              <option value="${role.id}" role=${role.id} ${role.id==persons.FK_role?"selected":""}>
                                  ${role.Role}
                              </option>
                          </c:forEach>
                      </select>
                  </div>
      -->
                  <div class=col-md-1>
                      <button id="singlebutton" name="singlebutton" class="btn btn-success">
                          Обновить
                      </button>
                  </div>
      
                  <div class=col-md-1>
                      <button id="singlebutton" name="singlebutton"
                      class="btn btn-danger"
                      onclick="document.getElementById('persons_id_${persons.ID}').value=-document.getElementById('persons_id_${persons.ID}').value;"
                      >
                          Удалить
                      </button>
                  </div>
      
              </form>
              </div>
         <br>
         </c:forEach>

<%@ include file="include/end-html.jsp" %>
