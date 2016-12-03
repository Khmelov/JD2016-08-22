<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

     <div class="row">
          <b>
              <div class=col-md-1>ID</div>
              <div class=col-md-2>Имя</div>
              <div class=col-md-2>Фамилия</div>
              <div class=col-md-2>Адрес</div>
              <div class=col-md-2>Телефон</div>
              <div class=col-md-1>ID доктора</div>
          </b>
         </div>
         <br>
         <!-- Коллекцию listUser мы получаем по get из команды сервлета UserForm -->
         <c:forEach items="${patientss}" var="patients">
              <div class="row">
              <form class="form-patients-${patients.ID}" action="do?command=ShowPatients" method=POST>
                  <div class=col-md-1>
                      <input id="patients_id_${patients.ID}" name="ID" type="text"
                      value="${patients.ID}" class="form-control input-md">
                  </div>
                  <div class=col-md-2>
                      <input id="textinput" name="First_name" type="text"
                      value="${patients.first_name}" class="form-control input-md">
                  </div>
                  <div class=col-md-2>
                      <input id="textinput" name="Second_name" type="text"
                      value="${patients.second_name}" class="form-control input-md">
                  </div>
                  <div class=col-md-2>
                                        <input id="textinput" name="Address" type="text"
                                        value="${patients.address}" class="form-control input-md">
                                    </div>
                  <div class=col-md-2>
                      <input id="textinput" name="Phone_number" type="text"
                      value="${patients.phone_number}" class="form-control input-md">
                  </div>

                  <div class=col-md-1>
                      <input id="textinput" name="FK_doctors" type="text"
                       value="${patients.FK_doctors}" class="form-control input-md">
                  </div>



              <!--    <div class=col-md-2>
                      <select id="role" name="FK_role" class="form-control">
                          <c:forEach items="${roles}" var="role">
                              <option value="${role.id}" role=${role.id} ${role.id==patients.FK_role?"selected":""}>
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
                      onclick="document.getElementById('patients_id_${patients.ID}').value=-document.getElementById('patients_id_${patients.ID}').value;"
                      >
                          Удалить
                      </button>
                  </div>
      
              </form>
              </div>
         <br>
         </c:forEach>


<%@ include file="include/end-html.jsp" %>
