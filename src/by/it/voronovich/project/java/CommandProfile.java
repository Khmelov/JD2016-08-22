package by.it.voronovich.project.java;

import javax.servlet.http.HttpServletRequest;

public class CommandProfile implements ActionCommand {

    @Override
    public String execute(HttpServletRequest req) {
        String page = Action.PROFILE.inPage;
        if (FormHelper.isPost(req)) {
            req.getSession().invalidate();
            page = Action.PROFILE.okPage;
        } else{
            page = Action.PROFILE.inPage;
        }
        return page;
    }
}
