package by.it.zaharova.project.java.dao;

import by.it.zaharova.project.java.beans.Doctors;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoctorsDAO extends AbstractDAO implements InterfaceDAO<Doctors> {
    @Override
    public List<Doctors> getAll(String WHERE) {
        List<Doctors> doctorss = new ArrayList<>();
        String sql = "SELECT * FROM doctors " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Doctors doctors = new Doctors();
                doctors.setID(rs.getInt("ID"));
                doctors.setName_surname(rs.getString("Name_surname"));
                doctors.setSpeciality(rs.getString("Speciality"));
                doctors.setPhone_number(rs.getString("Phone_number"));
                doctors.setCabinet(rs.getString("Cabinet"));
                doctorss.add(doctors);
            }
        } catch (SQLException e) {
            //тут нужно логгирование SQLException(e);
        }
        return doctorss;
    }

    @Override
    public Doctors read(int id) {
        List<Doctors> doctors = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (doctors.size() > 0) {
            return doctors.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(Doctors doctors) {
        String sql = String.format(
                "insert into doctors(Name_surname,Speciality,Phone_number, Cabinet) values('%s','%s','%s',%s);",
                doctors.getName_surname(), doctors.getSpeciality(),  doctors.getPhone_number(), doctors.getCabinet()
        );
        doctors.setID(executeUpdate(sql));
        return (doctors.getID()>0);
    }
    @Override
    public boolean update(Doctors doctors) {
        String sql = String.format(
                "UPDATE doctors SET Name_surname = '%s', Speciality = '%s',  Phone_number = '%s', Cabinet=%s WHERE doctors.ID = %d",
                doctors.getName_surname(), doctors.getSpeciality(),  doctors.getPhone_number(), doctors.getCabinet(), doctors.getID()
        );
        return (0 < executeUpdate(sql));
    }
    @Override
    public boolean delete(Doctors doctors) {
        String sql = String.format(
                "DELETE FROM `doctors` WHERE `doctors`.`ID` = %d;", doctors.getID()
        );
        return (0 < executeUpdate(sql));
    }


}
