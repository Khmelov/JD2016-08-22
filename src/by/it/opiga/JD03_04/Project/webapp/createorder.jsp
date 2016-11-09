<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=CreateOrder" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>Оставить заявку</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="fio">ФИО </label>
            <div class="col-md-4">
                <input id="fio" name="fio" type="text" placeholder="" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="passport">Паспорт</label>
            <div class="col-md-4">
                <input id="passport" name="passport" type="text" placeholder="" class="form-control input-md" required="">

            </div>
        </div>


        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="phone">Телефон</label>
            <div class="col-md-4">
                <input id="phone" name="phone" type="text" placeholder="" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="category">Категория</label>
            <div class="col-md-4">
                <select id="category" name="category" class="form-control">
                    <option value="lux">lux</option>
                    <option value="econom">econom</option>
                </select>
            </div>
        </div>
            <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="arrive">Приезжаю</label>
            <div class="col-md-4">
                <input id="arrive" name="arrive" type="date" placeholder="" class="form-control input-md" required="">

            </div>
        </div>
        <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="leavee">Уезжаю</label>
                    <div class="col-md-4">
                        <input id="leavee" name="leavee" type="date" placeholder="" class="form-control input-md" required="">

                    </div>
                </div>
             <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="payment">Оплата</label>
                    <div class="col-md-4">
                        <input id="payment" name="payment" type="text" placeholder="" class="form-control input-md" required="">

                    </div>
                </div>

            <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="FK_user">ID пользователя</label>
                    <div class="col-md-4">
                        <input id="FK_user" name="FK_user" type="text" placeholder="" class="form-control input-md" required="">

                    </div>
                </div>

                <!-- Text input-->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="FK_status">Статус заявки</label>
                                    <div class="col-md-4">
                                        <input id="FK_status" name="FK_status" type="text" placeholder="" class="form-control input-md" required="">

                                    </div>
                                </div>

        <!-- Button -->
        <div class="form-group">
          <label class="col-md-4 control-label" for="singlebutton"></label>
          <div class="col-md-4">
            <button id="singlebutton" name="singlebutton" class="btn btn-success">Готово</button>
          </div>
        </div>

    </fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
