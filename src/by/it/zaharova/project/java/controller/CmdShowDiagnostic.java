package by.it.zaharova.project.java.controller;


import by.it.zaharova.project.java.beans.Diagnostic;
import by.it.zaharova.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

import java.text.ParseException;


class CmdShowDiagnostic extends Action {
    
    @Override
    Action execute(HttpServletRequest req) {
       
        DAO dao=DAO.getDAO();

        if (Form.isPost(req)){
            Diagnostic diagnostic = new Diagnostic();
            try {
                diagnostic.setID(Form.getInt(req,"ID"));
                diagnostic.setIllness(req.getParameter("Illness"));
                diagnostic.setDrugs(req.getParameter("Drugs"));
                diagnostic.setOperations(req.getParameter("Operations"));
                diagnostic.setProcedures(req.getParameter("Procedures"));
                diagnostic.setFK_patients(Form.getInt(req,"FK_patients"));
                diagnostic.setFK_doctors(Form.getInt(req,"FK_doctors"));
                req.setAttribute(Messages.msgMessage,diagnostic);
                if (diagnostic.getID()>0){
                    dao.diagnostic.update(diagnostic);
                }
                if (diagnostic.getID()<0){
                    diagnostic.setID(diagnostic.getID()*(-1));
                    dao.diagnostic.delete(diagnostic);
                }
                if (diagnostic.getID()==0){
                    dao.diagnostic.create(diagnostic);
                }

            } catch (ParseException e) {
                e.printStackTrace();
                req.setAttribute(Messages.msgMessage,"Ошибка!!");
            }
        }
        req.setAttribute("diagnostics",dao.diagnostic.getAll(""));
        return null;
    }
}
