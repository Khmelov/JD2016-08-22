package by.it.grechishnikov.jd03_03;

import by.it.grechishnikov.jd03_03.dao.DAO;

public class TaskB {
    public static void main(String[] args) {
        DAO dao = DAO.getInstance();
        System.out.println(dao.getRolesDAO().read(1));
    }
}
