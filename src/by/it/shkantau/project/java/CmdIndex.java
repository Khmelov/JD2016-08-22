package by.it.shkantau.project.java;

import by.it.shkantau.project.java.beans.Flight;
import by.it.shkantau.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex extends Action {
    @Override
    Action execute(HttpServletRequest request) {
        if (request.getMethod().equalsIgnoreCase("post")){

        }else {
//            if (HttpSessionAttrHelper.isAdministrator(request)) {

                HttpSessionAttrHelper.updateRole(request);
                DAO dao = DAO.getDAO((String) request.getAttribute(FrontController.CSPATH));
                List<Flight> flights = dao.flightDAO.getAll("");

                if (flights == null) {
                    request.setAttribute(AttrMessages.msgError, "Wrong data." + dao.flightDAO.lastSQL);
                    return null;
                } else {
                    request.setAttribute(AttrMessages.msgMessage, "Read flightsCount=" + flights.size());
                    request.setAttribute("flights", flights);
                    return null;
                }
//            }
        }
        return null;
    }
}
