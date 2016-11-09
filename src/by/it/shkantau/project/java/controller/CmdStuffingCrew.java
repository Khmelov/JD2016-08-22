package by.it.shkantau.project.java.controller;

import by.it.shkantau.project.java.beans.Crew;
import by.it.shkantau.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


class CmdStuffingCrew extends Action {
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {
        if (request.getMethod().equalsIgnoreCase("GET")) {
            SessionAttrSesHelper.setPilotsToAttribute(request);
            SessionAttrSesHelper.setAirhostessToAttribute(request);
        }else{// POST

            Crew crew = new Crew();
            crew.setId(0);

            try {
                crew.setPilot1(Integer.parseInt(Form.getString(request,"pilot1", Patterns.INT)));
                crew.setPilot2(Integer.parseInt(Form.getString(request,"pilot2", Patterns.INT)));
                crew.setAirhostess1(Integer.parseInt(Form.getString(request,"airhostess1", Patterns.INT)));
                crew.setAirhostess2(Integer.parseInt(Form.getString(request,"airhostess2", Patterns.INT)));
                if (crew.getPilot1() == crew.getPilot2()){
                    throw new Exception("Select different pilots");
                }
                if (crew.getAirhostess1() == crew.getAirhostess2()){
                    throw new Exception("Select different airhostesses");
                }

            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute(AttrMessages.msgError, "Invalid field format. "+e.toString());
                return null;
            }
            DAO dao = DAO.getDAO();
            if (dao.crewDAO.create(crew)>0) {
                request.setAttribute(AttrMessages.msgMessage, "New crew is created.");
            } else {
                request.setAttribute(AttrMessages.msgError, "Crew does not created. " + dao.crewDAO.lastSQL);
            }
        }
        return null;
    }
}
