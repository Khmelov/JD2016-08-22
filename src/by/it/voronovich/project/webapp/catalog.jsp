<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/begin-html.jsp" %>
<div>
<div class="row">
    <div class="col-md-1"><b><h4>№_</b></h4></div>
    <div class="col-md-1"><b><h4>Бренд</b></h4></div>
    <div class="col-md-2"><b><h4>Модель</b></h4></div>
    <div class="col-md-2"><b><h4>Цена(BYN)</b></h4></div>
    <div class="col-md-2"><b><h4>Дата выхода на рынок</b></h4></div>
    <div class="col-md-1"><b><h4>Вес(кг)</b></h4></div>
    <div class="col-md-1" style="color: #FFFFFF;"><b><h4></b></h4></div>
    <div class="col-md-2"><b><h4>Заказать</b></h4></div>
</div>
    <hr align="left" width="850" size="9" color="#ff9900" />
    <c:forEach var="good" items="${listCatalog}">
        <form class="form-horizontal" action="do?command=CATALOG" method="post">
            <fieldset>
                <div class="row">
                    <div class="col-md-1"><h4><c:out value="${good.getIdCatalog()}" /></h4></div>
                    <div class="col-md-1"><h4><c:out value="${good.getBrand()}" /></h4></div>
                    <div class="col-md-2"><h4><c:out value="${good.getModel()}" /></h4></div>
                    <div class="col-md-2"><h4><c:out value="${good.getPrice()}" /></h4></div>
                    <div class="col-md-2"><h4><c:out value="${good.getReleaseDate()}" /></h4></div>
                    <div class="col-md-1"><h4><c:out value="${good.getWeight()}" /></h4></div>
                    <div class="col-md-1" style="display: none"> <input id="idCatalog" name="idCatalog" value="${good.getIdCatalog()}" type="text"
                    placeholder="" class="form-control input-md" required=""></div>
                    <div class="col-md-2">
                        <!-- Button -->
                            <label class="col-md-2 control-label" for="singlebutton"></label>
                                 <div class="col-md-2">
                                     <button id="singlebutton" name="singlebutton" class="btn btn-success">Добавить в корзину</button>
                                 </div>
                    </div>
                </div>
                    <hr align="left" width="850" size="9" color="#ff9900" />
             </fieldset>
        </form>
     </c:forEach>
</div>
<%@ include file="include/end-html.jsp" %>
