package by.it.aborisenok.project.java.dao;

import by.it.aborisenok.project.java.beans.Doctor;

import by.it.aborisenok.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aborisenok on 26.10.2016.
 */
public class DoctorDAO extends AbstractDAO implements InterfaceDAO<Doctor> {
    @Override
    public Doctor read(int id) {
    List<Doctor>  doctors = getAll("WHERE ID=" + id + " LIMIT 0,1");
    if (doctors.size() > 0) {
        return doctors.get(0);
    } else
            return null;
}
    @Override
    public boolean create(Doctor entity) {
        return false;
    }

    @Override
    public boolean update(Doctor entity) {
        return false;
    }

    @Override
    public boolean delete(Doctor entity) {
        return false;
    }

    @Override
    public List<Doctor> getAll(String WHERE) {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctor " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setID(rs.getInt("ID"));
                doctor.setName(rs.getString("Name"));
                doctor.setSurname(rs.getString("Surname"));
                doctor.setSpecialization(rs.getString("Specialization"));
                doctor.setCategory(rs.getString("Category"));
                doctor.setCabinet(rs.getInt("Cabinet"));
                doctor.setFK_Policlinic(rs.getInt("FK_Policlinic"));

                doctors.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }
}
