package by.it.shkantau.project.java.controller;

import by.it.shkantau.project.java.beans.FlightStr;
import by.it.shkantau.project.java.dao.DAO;
import by.it.shkantau.project.java.dao.FlightQueryStrBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;

class CmdIndex extends Action {
    @Override
    Action execute(HttpServletRequest request, HttpServletResponse response) {
        DAO dao = DAO.getDAO();
        int startNumber = 0;
        String flightQuery ="";


        if (request.getMethod().equalsIgnoreCase("post")) {
            try {
                FlightQueryStrBuilder queryStrBuilder = new FlightQueryStrBuilder();
                queryStrBuilder.appendIntParam("fromPort", "=", request.getParameter("from"));
                queryStrBuilder.appendIntParam("toPort", "=", request.getParameter("to"));
                queryStrBuilder.appendStrParam("DATE(departure_time)", "=", request.getParameter("departureTime"));
                queryStrBuilder.appendStrParam("DATE(arrival_time)", "=", request.getParameter("arrivalTime"));
                flightQuery = queryStrBuilder.getQuery();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        try {
            startNumber = Form.getInt(request, "startNumber");
        } catch (ParseException e) {
            startNumber = 0;
        }
        String limit = String.format(" LIMIT %s,%s", startNumber, 10);
        List<FlightStr> flightStrs = dao.fligthStrDAO.getAll(flightQuery + limit);
        request.setAttribute("adCount", dao.fligthStrDAO.getCount(flightQuery));
        for (FlightStr flight : flightStrs) {
            flight.setViewNumber(++startNumber);
        }
        request.setAttribute("flights", flightStrs);
        SessionAttrSesHelper.setAirportsToAttribute(request);
        return null;
    }
}
