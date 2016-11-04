package by.it.shkantau.project.java;

import by.it.shkantau.project.java.beans.*;
import by.it.shkantau.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;


class CmdNewFlight extends Action {
    @Override
    public Action execute(HttpServletRequest request) {

        if (request.getMethod().equals("POST")) {
            Flight flight = new Flight();
            try {
                flight.setFlightCode(Form.getString(request, "code", Patterns.FLIGTH_CODE));
                flight.setCompany(Form.getString(request, "company", Patterns.PASSWORD));

                String timestampStr = request.getParameter("departureTime")+":00";
                Timestamp timestamp1 = Timestamp.valueOf(timestampStr);
                flight.setArrival_time(timestamp1 );

                timestampStr = request.getParameter("arrivalTime")+":00";
                timestamp1 = Timestamp.valueOf(timestampStr);
                flight.setDeparture_time(timestamp1 );

                flight.setPlane(Integer.parseInt(Form.getString(request,"plane",Patterns.INT)));
                flight.setFrom(Integer.parseInt(Form.getString(request,"from",Patterns.INT)));
                flight.setTo(Integer.parseInt(Form.getString(request,"to",Patterns.INT)));
                flight.setCrew(Integer.parseInt(Form.getString(request, "crew", Patterns.INT)));
                User user = (User) request.getSession().getAttribute("user");
                if (user !=null){
                    flight.setUser(user.getId());
                }else {
                    flight.setUser(1);
                }

            }catch (Exception e) {
                e.printStackTrace();
            }

            DAO dao = DAO.getDAO((String) request.getAttribute(FrontController.CSPATH));
            if (dao.flightDAO.create(flight)>0) {
                request.setAttribute(AttrMessages.msgMessage, "New flight is created.");
//                return  null;
            } else {
                request.setAttribute(AttrMessages.msgError, "Flight does not created. " + dao.crewDAO.lastSQL);
            }
            return  Actions.INDEX.action;
        }else{
            DAO dao = DAO.getDAO((String) request.getAttribute(FrontController.CSPATH));
            List<Plane> planes = dao.planeDAO.getAll("");
            List<Airport> airports = dao.airportsDAO.getAll("");
            List<Crew> crews = dao.crewDAO.getAll("");

            if (planes == null || airports == null || crews==null) {
                request.setAttribute(AttrMessages.msgError, "Wrong data." + dao.userDAO.lastSQL);

            } else {
                request.setAttribute("planes", planes);
                request.setAttribute("airports", airports);
                request.setAttribute("crews",crews);
//                return null;
            }
        }
        return null;
    }
}
