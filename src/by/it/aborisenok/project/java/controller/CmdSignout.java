package by.it.aborisenok.project.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Лёша on 01.11.2016.
 */
public class CmdSignout extends Action {
    @Override
    public Action execute(HttpServletRequest req) {
        if (Form.isPost(req)){
        req.getSession().invalidate();
        return Actions.SIGNIN.action;
    }
    else {

    }
    return Actions.SIGNOUT.action;
    }
}
