package by.it.shkantau.project.java;

import by.it.shkantau.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;

class CmdProfile extends Action {
    @Override
    Action execute(HttpServletRequest request) {
        Object o = request.getSession().getAttribute("user");
        if (o != null){
            if (o instanceof User){
                request.setAttribute("user",o);
            }
        }else {
            request.removeAttribute("user");
        }
        HttpSessionAttrHelper.updateRole(request);
        return null;
    }
}
