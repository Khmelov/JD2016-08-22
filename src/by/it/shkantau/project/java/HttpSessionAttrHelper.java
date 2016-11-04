package by.it.shkantau.project.java;

import by.it.shkantau.project.java.beans.Role;
import by.it.shkantau.project.java.beans.User;
import by.it.shkantau.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

class HttpSessionAttrHelper {

    static void updateRole(HttpServletRequest request){
        Object o = request.getSession().getAttribute("roles");
        if (o != null) {
            if (o instanceof List) {
                List<Role> roleList = (List<Role>) o;
                request.setAttribute("roles", roleList);
                request.getSession().setAttribute("roles",roleList);
            }
        }else {
            DAO dao = DAO.getDAO((String) request.getAttribute(FrontController.CSPATH));
            List<Role> roles = dao.roleDAO.getAll("");
            request.setAttribute("roles",roles);
            request.getSession().setAttribute("roles",roles);
        }
    }

    static boolean isAdministrator(HttpServletRequest request){
        HttpSession session = request.getSession();
        Object o = session.getAttribute("user");
        if (o != null){
            if (o instanceof User){
                if (((User) o).getRole() == Role.ADMINISTRATOR_ROLE){
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }

    static boolean isLogined(HttpServletRequest request){
        HttpSession session = request.getSession();
        Object o = session.getAttribute("user");
        if (o != null){
            if (o instanceof User){
                    return true;
            }
        }
        return false;
    }
    
}
