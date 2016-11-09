<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

     <!-- Основное содержимое -->
           <div class="page-header">
             <h1>Список докторов</h1>

           </div>

                  <div class="row">
                    <div class="col-md-1">№</div>
                    <div class="col-md-2">Имя Фамилия</div>
                    <div class="col-md-2">Квалификация</div>
                    <div class="col-md-2">Номер телефона</div>
                    <div class="col-md-2">Кабинет</div>
                  
                  </div>
               <% Integer i=0; %>
               <c:forEach items="${doctorss}" var="doctors">
                  <br />
                  <div class="row">
                    <div class="col-md-1"><% out.print(++i); %></div>
                    <div class="col-md-2">${doctors.name_surname} </div>
                    <div class="col-md-2">${doctors.speciality}</div>
                    <div class="col-md-2">${doctors.phone_number}</div>
                    <div class="col-md-2">${doctors.cabinet}</div>


                  </div>
               </c:forEach>


<%@ include file="include/end-html.jsp" %>