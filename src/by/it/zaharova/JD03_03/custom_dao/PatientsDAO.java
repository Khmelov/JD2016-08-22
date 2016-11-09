package by.it.zaharova.JD03_03.custom_dao;

import by.it.zaharova.JD03_03.beans.Patients;
import by.it.zaharova.JD03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PatientsDAO extends AbstractDAO implements InterfaceDAO<Patients> {
    @Override
    public List<Patients> getAll(String WHERE) {
        List<Patients> patientss = new ArrayList<>();
        String sql = "SELECT * FROM patients " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Patients patients = new Patients();
                patients.setID(rs.getInt("ID"));
                patients.setFirst_name(rs.getString("First_name"));
                patients.setSecond_name(rs.getString("Second_name"));
                patients.setAddress(rs.getString("Address"));
                patients.setPhone_number(rs.getString("Phone_number"));
                patients.setFK_doctors(rs.getInt("FK_doctors"));
                patientss.add(patients);
            }
        } catch (SQLException e) {
            //тут нужно логгирование SQLException(e);
        }
        return patientss;
    }

    @Override
    public Patients read(int id) {
        List<Patients> patients = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (patients.size() > 0) {
            return patients.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(Patients patients) {
        String sql = String.format(
                "insert into patients(First_name,Second_name,Address,Phone_number, FK_doctors) values('%s','%s','%s','%s',%d);",
                patients.getFirst_name(), patients.getSecond_name(), patients.getAddress(), patients.getPhone_number(), patients.getFK_doctors()
        );
        patients.setID(executeUpdate(sql));
        return (patients.getID()>0);
    }
    @Override
    public boolean update(Patients patients) {
        String sql = String.format(
                "UPDATE patients SET First_name = '%s', Second_name = '%s', Address = '%s', Phone_number = '%s', FK_doctors=%d WHERE patients.ID = %d",
                patients.getFirst_name(), patients.getSecond_name(), patients.getAddress(), patients.getPhone_number(), patients.getFK_doctors(), patients.getID()
        );
        return (0 < executeUpdate(sql));
    }
    @Override
    public boolean delete(Patients patients) {
        String sql = String.format(
                "DELETE FROM `patients` WHERE `patients`.`ID` = %d;", patients.getID()
        );
        return (0 < executeUpdate(sql));
    }


}
