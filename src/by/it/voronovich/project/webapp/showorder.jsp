<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<div class="row">
    <div class="col-md-2"><b><h4>Номер заказа</b></h4></div>
    <div class="col-md-3"><b><h4>Номер продукции в каталоге</b></h4></div>
    <div class="col-md-1" style="color: #FFFFFF;"><b><h4></b></h4></div>
    <div class="col-md-3"><b><h4>Удалить из корзины</b></h4></div>
</div>
          <hr align="left" width="800" size="9" color="#ff9900" />
              <c:forEach var="order" items="${listOrder}">
                  <form class="form-horizontal" action="do?command=SHOWORDER" method="post">
                      <fieldset>
                          <div class="row">
                              <div class="col-md-2"><h4><c:out value="${order.getIdShoppingCart()}" /></h4></div>
                              <div class="col-md-3"><h4><c:out value="${order.getFK_Catalog()}" /></h4></div>
                              <div class="col-md-1" style="display: none"> <input id="idShoppingCart" name="idShoppingCart" value="${order.getIdShoppingCart()}" type="text"
                                                     placeholder="" class="form-control input-md" required=""></div>
                              <div class="col-md-3">
                                  <!-- Button -->
                                      <label class="col-md-3 control-label" for="singlebutton"></label>
                                           <div class="col-md-3">
                                               <button id="singlebutton" name="singlebutton" class="btn btn-success">Отменить заказ</button>
                                           </div>
                              </div>
                          </div>
                              <hr align="left" width="800" size="9" color="#ff9900" />
                       </fieldset>
                  </form>
               </c:forEach>
                <c:set var="count" value="${count}"/>
                    <h3>Товаров на сумму: ${count} BYN</3>
<%@ include file="include/end-html.jsp" %>

