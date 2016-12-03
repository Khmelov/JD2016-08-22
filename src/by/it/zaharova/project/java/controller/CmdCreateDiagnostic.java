package by.it.zaharova.project.java.controller;

import by.it.zaharova.project.java.beans.Diagnostic;
import by.it.zaharova.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateDiagnostic extends Action{
    @Override
    Action execute(HttpServletRequest req) {
        Diagnostic diagnostic = new Diagnostic();
        if (Form.isPost(req)) {
            try {
                diagnostic.setID(0);
                diagnostic.setIllness(req.getParameter("Illness"));
                diagnostic.setDrugs(req.getParameter("Drugs"));
                diagnostic.setOperations(req.getParameter("Operations"));
                diagnostic.setProcedures(req.getParameter("Procedures"));
                diagnostic.setFK_patients(Form.getInt(req,"FK_patients"));
                diagnostic.setFK_doctors(Form.getInt(req,"FK_doctors"));
            } catch (Exception e) {
                req.setAttribute(Messages.msgError, "NO VALID FIELDS");
                return null;
            }
            DAO dao = DAO.getDAO();
            if (dao.diagnostic.create(diagnostic)) {
                req.setAttribute(Messages.msgMessage, "DIAGNOSTIC ADDED");
                return Actions.INDEX.action;
            } else
                req.setAttribute(Messages.msgError, "FILL ERROR");
        }
        return null;
    }
}
