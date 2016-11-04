package by.it.shkantau.project.java;

import by.it.shkantau.project.java.beans.Airhostess;
import by.it.shkantau.project.java.beans.Crew;
import by.it.shkantau.project.java.beans.Pilot;
import by.it.shkantau.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


class CmdStuffingCrew extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        if (request.getMethod().equals("GET")) {
            String path = request.getParameter(FrontController.CSPATH);
            DAO dao = DAO.getDAO(path);
            List<Pilot> pilots = dao.pilotDAO.getAll("");
            List<Airhostess> airhostesses = dao.airhostessDAO.getAll("");

            if (pilots == null || airhostesses == null) {
                request.setAttribute(AttrMessages.msgError, "Wrong data.");
                return null;
            } else {
//            request.setAttribute(AttrMessages.msgMessage,"Read PlanesCount=" + planes.size());
                request.setAttribute("pilots", pilots);
                request.setAttribute("airhostesses", airhostesses);
                return null;
            }
        }else{// POST

            Crew crew = new Crew();
            crew.setId(0);

            try {
                crew.setPilot1(Integer.parseInt(Form.getString(request,"pilot1", Patterns.INT)));
                crew.setPilot2(Integer.parseInt(Form.getString(request,"pilot2", Patterns.INT)));
                crew.setAirhostess1(Integer.parseInt(Form.getString(request,"airhostess1", Patterns.INT)));
                crew.setAirhostess2(Integer.parseInt(Form.getString(request,"airhostess2", Patterns.INT)));

            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("msgError", "Invalid field format. "+e.toString());
                return null;
            }
            DAO dao = DAO.getDAO((String) request.getAttribute(FrontController.CSPATH));
            if (dao.crewDAO.create(crew)>0) {
                request.setAttribute(AttrMessages.msgMessage, "New crew is created.");
                return Actions.INDEX.action;
            } else {
                request.setAttribute(AttrMessages.msgError, "Crew does not created. " + dao.crewDAO.lastSQL);
            }
            return null;
        }

    }
}
