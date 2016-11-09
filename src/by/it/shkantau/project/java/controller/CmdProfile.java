package by.it.shkantau.project.java.controller;

import by.it.shkantau.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class CmdProfile extends Action {
    @Override
    Action execute(HttpServletRequest request, HttpServletResponse response) {
        Object o = request.getSession().getAttribute("user");
        if (o != null){
            if (o instanceof User){
                request.setAttribute("user",o);
            }
        }else {
            request.removeAttribute("user");
        }
        SessionAttrSesHelper.setRolesToAttribute(request);
        return null;
    }
}
