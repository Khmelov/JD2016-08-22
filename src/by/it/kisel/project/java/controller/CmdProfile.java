package by.it.kisel.project.java.controller;

import by.it.kisel.project.java.beans.Rooms;
import by.it.kisel.project.java.beans.Persons;
import by.it.kisel.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

class CmdProfile extends Action {
    @Override
    Action execute(HttpServletRequest req) {
        if (Form.isPost(req)) {
            req.getSession().invalidate();
            return Actions.LOGIN.action;
        }
        else
        {
            Persons persons=(Persons)req.getSession().getAttribute("persons");
            DAO dao=DAO.getDAO();
            int startNumber=0;
            try {
                startNumber=Form.getInt(req,"startNumber");
            } catch (ParseException e) {
                startNumber=0;
            }
            String limit=String.format("where FK_persons=%d LIMIT %s,%s",persons.getID(),startNumber,5);
            List<Rooms> roomss = dao.rooms.getAll(limit);
            req.setAttribute("roomsCount", dao.rooms.getCount(""));
            for (Rooms rooms : roomss) {
                rooms.setViewNumber(++startNumber);
            }
            req.setAttribute("roomss", roomss);
        }
        
        
        
        
//        else
//        {
//            Persons persons=(Persons)req.getSession().getAttribute("persons");
//            List<Rooms> roomss= DAO.getDAO().rooms.getAll("where FK_persons="+persons.getID());
//            req.setAttribute("roomss",roomss);
//        }
        return null;
    }
}
