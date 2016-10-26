package by.it.aborisenok.JD03_03.custom_dao;

import by.it.aborisenok.JD03_03.beans.VisitDate;
import by.it.aborisenok.JD03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aborisenok on 26.10.2016.
 */
public class VisitDateDAO extends AbstractDAO implements InterfaceDAO<VisitDate>{
    @Override
    public VisitDate read(int id) {
        return null;
    }

    @Override
    public boolean create(VisitDate entity) {
        return false;
    }

    @Override
    public boolean update(VisitDate entity) {
        return false;
    }

    @Override
    public boolean delete(VisitDate entity) {
        return false;
    }

    @Override
    public List<VisitDate> getAll(String WHERE) {
        List<VisitDate> visitDates = new ArrayList<>();
        String sql = "SELECT * FROM visitdate " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                VisitDate visitDate = new VisitDate();
                visitDate.setID(rs.getInt("ID"));
                visitDate.setVisitTime(rs.getTimestamp("VisitTime"));
                visitDate.setFK_Doctor(rs.getInt("FK_Doctor"));

                visitDates.add(visitDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  visitDates;
    }
}
