package by.it.prymshyts.jd03.jd03_03;

import by.it.prymshyts.jd03.jd03_03.beans.User;
import by.it.prymshyts.jd03.jd03_03.dao.DAO;

import java.util.List;

class TaskA {
    public static void main(String[] args) {
        DAO dao = DAO.getDAO();

        List<User> userList = dao.getUserDAO().getAll();

        for (User user : userList) {
            System.out.println(user.getLogin() + " - " + dao.getRoleDAO().read(user.getID()).getRole());
        }
    }
}
