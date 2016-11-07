<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/begin-html.jsp" %>
<div class="row">
    <div class="col-md-1"><b><h4>ID</b></h4></div>
    <div class="col-md-1"><b><h4>Brand</b></h4></div>
    <div class="col-md-2"><b><h4>Model</b></h4></div>
    <div class="col-md-1"><b><h4>Price</b></h4></div>
    <div class="col-md-2"><b><h4>ReleaseDate</b></h4></div>
    <div class="col-md-1"><b><h4>Weight</b></h4></div>
    <div class="col-md-2"></div>
    <div class="col-md-2"></div>
</div>
<hr align="left" width="1100" size="9" color="#ff9900" />
    <c:forEach var="good" items="${goodList}">
        <form class="form-horizontal" action="do?command=ADMINCABGOOD" method="post">
            <fieldset>
                <div class="row">
                    <div class="col-md-1"><input id="idCatalog${good.getIdCatalog()}" name="idCatalog" value="${good.getIdCatalog()}"
                     type="text" placeholder="" class="form-control input-md" required=""></div>
                    <div class="col-md-1"><input id="Brand" name="Brand" value="${good.getBrand()}"
                     type="text" placeholder="" class="form-control input-md" required=""></div>
                    <div class="col-md-2"><input id="Model" name="Model" value="${good.getModel()}"
                     type="text" placeholder="" class="form-control input-md" required=""></div>
                    <div class="col-md-1"><input id="Price" name="Price" value="${good.getPrice()}"
                     type="text" placeholder="" class="form-control input-md" required=""></div>
                    <div class="col-md-2"><input id="ReleaseDate" name="ReleaseDate" value="${good.getReleaseDate()}"
                     type="text" placeholder="" class="form-control input-md" required=""></div>
                    <div class="col-md-1"><input id="Weight" name="Weight" value="${good.getWeight()}"
                     type="text" placeholder="" class="form-control input-md" required=""></div>
                    <div class="col-md-2">
                        <!-- Button -->
                            <label class="col-md-2 control-label" for="singlebutton"></label>
                                <div class="col-md-2">
                                    <button id="singlebutton" name="singlebutton" class="btn btn-success">Обновить</button>
                                </div>
                    </div>
                    <div class="col-md-2">
                        <!-- Button -->
                            <label class="col-md-2 control-label" for="singlebutton"></label>
                                <div class="col-md-2">
                                    <button id="singlebutton" name="singlebutton" class="btn btn-danger"
                                     onclick="document.getElementById('idCatalog${good.getIdCatalog()}').value=-document.getElementById('idCatalog${good.getIdCatalog()}').value;"
                                    >Удаалить</button>
                                </div>
                    </div>
                </div>
                <hr align="left" width="1100" size="9" color="#ff9900" />
            </fieldset>
        </form>
    </c:forEach>
<%@ include file="include/end-html.jsp" %>