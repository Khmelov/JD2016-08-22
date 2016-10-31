<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<<%@ include file="include/author.jsp" %>

    <br><br><br><br>
    <div class="navbar-collapse collapse">

    <form class="navbar-form navbar-right" role="form" action="controller/?command=search" method="post">
       <div class="form-group">
        <input type="search" placeholder="Немецкие обои" class="form-control">
       </div>
       <button type="submit" class="btn btn-success">Поиск</button>
    </form>
    <h1>Каталог обоев:<br><small>Выберите понравившиеся вам обои и нажмите "Оформить заказ".</small></h1>
    </div>

    <table class="table table-hover table-bordered">
      <tr>
        <th>#</th>
        <th>Название</th>
        <th>Описание</th>
        <th>Цена</th>
        <th>Заказать</th>
      </tr>
      <tr>
        <td>1</td>
        <td>Первые обои</td>
        <td>Немецкие обои</td>
        <td>100</td>
        <td class="col-md-2"><button type="button" class="btn btn-success">Оформить заказ</button></td>
      </tr>
      <tr>
        <td>2</td>
        <td>Вторые обои</td>
        <td>Итальянские обои</td>
        <td>200</td>
        <td class="col-md-2"><button type="button" class="btn btn-success">Оформить заказ</button></td>
        </tr>
      <tr>
        <td>3</td>
        <td>Третьи обои</td>
        <td>Российские обои</td>
        <td>300</td>
        <td class="col-md-2"><button type="button" class="btn btn-success">Оформить заказ</button></td>
      </tr>
    </table>

<%@ include file="include/footer.jsp" %>