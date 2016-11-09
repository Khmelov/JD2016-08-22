package by.it.zaharova.JD03_03;



import by.it.zaharova.JD03_03.beans.Doctors;
import by.it.zaharova.JD03_03.custom_dao.DAO;

import java.sql.SQLException;

public class V3_DemoWithAD {
    public static void main(String[] args) throws SQLException {
        DAO dao=DAO.getDAO();
        Doctors doctors=new Doctors(3,"dfgh hjk", "dfghj", "12345", "456");
        System.out.println("All-------------------------");
        System.out.println(dao.doctors.getAll(""));

        dao.doctors.create(doctors);
        System.out.println("-------- Create ------------");
        System.out.println(dao.doctors.getAll(""));

        doctors.setCabinet("-1");
        dao.doctors.update(doctors);
        System.out.println("-------- Update ------------");
        System.out.println(dao.doctors.getAll(""));

        dao.doctors.delete(doctors);
        System.out.println("-------- Delete ------------");
        System.out.println(dao.doctors.getAll(""));

    }
}
