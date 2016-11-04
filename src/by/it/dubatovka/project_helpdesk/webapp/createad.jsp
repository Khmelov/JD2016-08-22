<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal">
    <fieldset>

        <!-- Form Name -->
        <legend>Create new task</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="subject">Subject</label>
            <div class="col-md-4">
                <input id="subject" name="subject" type="text" placeholder="subject" class="form-control input-md" required="">

            </div>
        </div>

        <!-- Textarea -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="description">Description</label>
            <div class="col-md-4">
                <textarea class="form-control" id="description" name="description">Details of the task</textarea>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="zia">ЗИА</label>
            <div class="col-md-4">
                <select id="zia" name="zia" class="form-control">
                    <option value="1">Мнс:Притыцкого</option>
                    <option value="2">Мнс:Одинцова</option>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="priority">Приоритет</label>
            <div class="col-md-4">
                <select id="priority" name="priority" class="form-control">
                    <option value="1">low</option>
                    <option value="2">high</option>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="user">User</label>
            <div class="col-md-4">
                <select id="user" name="user" class="form-control">
                    <option value="1">Option one</option>
                    <option value="2">Option two</option>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="status">Status</label>
            <div class="col-md-4">
                <select id="status" name="status" class="form-control">
                    <option value="open">open</option>
                    <option value="">resolved</option>
                    <option value="">in working</option>
                </select>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
