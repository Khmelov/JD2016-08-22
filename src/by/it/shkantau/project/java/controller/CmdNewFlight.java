package by.it.shkantau.project.java.controller;

import by.it.shkantau.project.java.beans.*;
import by.it.shkantau.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;


class CmdNewFlight extends Action {
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {

        if (request.getMethod().equalsIgnoreCase("POST")) {
            User user = (User) request.getSession().getAttribute("user");
            if (user ==null){
                request.setAttribute(AttrMessages.msgError, "Wrong user. ");
                return Actions.LOGIN.action;
            }
            Flight flight = new Flight();

            flight.setUser(user.getId());

            try {
                flight.setFlightCode(Form.getString(request, "code", Patterns.FLIGTH_CODE));
                flight.setCompany(Form.getString(request, "company", Patterns.PASSWORD));

                String timestampStr = request.getParameter("arrivalTime")+":00";
                Timestamp timestamp1 = Timestamp.valueOf(timestampStr);
                flight.setArrival_time(timestamp1 );

                timestampStr = request.getParameter("departureTime")+":00";
                timestamp1 = Timestamp.valueOf(timestampStr);
                flight.setDeparture_time(timestamp1 );

                flight.setPlane(Integer.parseInt(Form.getString(request,"plane",Patterns.INT)));
                flight.setFrom(Integer.parseInt(Form.getString(request,"from",Patterns.INT)));
                flight.setTo(Integer.parseInt(Form.getString(request,"to",Patterns.INT)));
                flight.setCrew(Integer.parseInt(Form.getString(request, "crew", Patterns.INT)));
                if (flight.getFrom() == flight.getTo()){
                    throw new Exception("Destination can't be equals to Arrival");
                }
                if (flight.getDeparture_time().getTime()  >= flight.getArrival_time().getTime()){
                    throw new Exception("Arrival time must be more then Destination time");
                }
            }catch (Exception e) {
                e.printStackTrace();
                request.setAttribute(AttrMessages.msgError, "Invalid field format. "+e.toString());
                return null;
            }

            DAO dao = DAO.getDAO();
            if (dao.flightDAO.create(flight)>0) {
                request.setAttribute(AttrMessages.msgMessage, "New flight is created.");
                return  Actions.INDEX.action;
            } else {
                request.setAttribute(AttrMessages.msgError, "Flight does not created. " + dao.crewDAO.lastSQL);
                return  Actions.NEWFLIGHT.action;
            }
        }else{
            SessionAttrSesHelper.setAirportsToAttribute(request);
            SessionAttrSesHelper.setPlanesToAttribute(request);
            SessionAttrSesHelper.setCrewsToAttribute(request);
        }
        return null;
    }
}
