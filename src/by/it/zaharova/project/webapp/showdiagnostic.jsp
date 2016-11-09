<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

     <div class="row">
         <b>
             <div class=col-md-1>ID</div>
             <div class=col-md-1>Диагноз</div>
                            <div class=col-md-2>Прописанные препараты</div>
                            <div class=col-md-2>Необходимость оперирования</div>
                            <div class=col-md-2>Назначенные процедуры</div>
                            <div class=col-md-1>ID пациента</div>
                            <div class=col-md-1>ID доктора</div>
         </b>
        </div>
        <br>
        <!-- Коллекцию listUser мы получаем по get из команды сервлета UserForm -->
        <c:forEach items="${diagnostics}" var="diagnostic">
             <div class="row">
             <form class="form-diagnostic-${diagnostic.ID}" action="do?command=ShowDiagnostic" method=POST>
                 <div class=col-md-1>
                     <input id="diagnostic_id_${diagnostic.ID}" name="ID" type="text"
                     value="${diagnostic.ID}" class="form-control input-md">
                 </div>
                 <div class=col-md-1>
                     <input id="textinput" name="Illness" type="text"
                     value="${diagnostic.illness}" class="form-control input-md">
                 </div>
                 <div class=col-md-2>
                     <input id="textinput" name="Drugs" type="text"
                     value="${diagnostic.drugs}" class="form-control input-md">
                 </div>
                 <div class=col-md-2>
                     <input id="textinput" name="Operations" type="text"
                     value="${diagnostic.operations}" class="form-control input-md">
                  </div>
                  <div class=col-md-2>
                                       <input id="textinput" name="Procedures" type="text"
                                       value="${diagnostic.procedures}" class="form-control input-md">
                                    </div>
                 <div class=col-md-1>

                     <input id="textinput" name="FK_patients" type="text"
                     value="${diagnostic.FK_patients}" class="form-control input-md">

                 </div>
                 <div class=col-md-1>

                     <input id="textinput" name="FK_doctors" type="text"
                     value="${diagnostic.FK_doctors}" class="form-control input-md">

                 </div>


                 <div class=col-md-1>
                     <button id="singlebutton" name="singlebutton" class="btn btn-success">
                         Обновить
                     </button>
                 </div>
     
                 <div class=col-md-1>
                     <button id="singlebutton" name="singlebutton"
                     class="btn btn-danger"
                     onclick="document.getElementById('diagnostic_id_${diagnostic.ID}').value=-document.getElementById('diagnostic_id_${diagnostic.ID}').value;"
                     >
                         Удалить
                     </button>
                 </div>
     
             </form>
             </div>
        <br>
     </c:forEach>


<%@ include file="include/end-html.jsp" %>