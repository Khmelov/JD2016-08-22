package by.it.zaharova.JD03_03.custom_dao;

import by.it.zaharova.JD03_03.beans.Diagnostic;
import by.it.zaharova.JD03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DiagnosticDAO extends AbstractDAO implements InterfaceDAO<Diagnostic> {
    @Override
    public List<Diagnostic> getAll(String WHERE) {
        List<Diagnostic> diagnostics = new ArrayList<>();
        String sql = "SELECT * FROM diagnostic " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Diagnostic diagnostic = new Diagnostic();
                diagnostic.setID(rs.getInt("ID"));
                diagnostic.setIllness(rs.getString("Illness"));
                diagnostic.setDrugs(rs.getString("Drugs"));
                diagnostic.setOperations(rs.getString("Operations"));
                diagnostic.setProcedures(rs.getString("Procedures"));
                diagnostic.setFK_patients(rs.getInt("FK_patients"));
                diagnostic.setFK_doctors(rs.getInt("FK_doctors"));
                diagnostics.add(diagnostic);
            }
        } catch (SQLException e) {
            //тут нужно логгирование SQLException(e);
        }
        return diagnostics;
    }

    @Override
    public Diagnostic read(int id) {
        List<Diagnostic> diagnostic = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (diagnostic.size() > 0) {
            return diagnostic.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(Diagnostic diagnostic) {
        String sql = String.format(
                "insert into diagnostic(Illness,Drugs,Operations,Procedures,FK_patients, FK_doctors) values('%s','%s','%s','%s',%d,%d);",
                diagnostic.getIllness(), diagnostic.getDrugs(), diagnostic.getProcedures(), diagnostic.getProcedures(), diagnostic.getFK_patients(), diagnostic.getFK_doctors()
        );
        diagnostic.setID(executeUpdate(sql));
        return (diagnostic.getID()>0);
    }
    @Override
    public boolean update(Diagnostic diagnostic) {
        String sql = String.format(
                "UPDATE diagnostic SET Illness = '%s', Drugs = '%s', Operations = '%s', Procedures = '%s', FK_patients=%d, FK_doctors=%d WHERE diagnostic.ID = %d",
                diagnostic.getIllness(), diagnostic.getDrugs(), diagnostic.getProcedures(), diagnostic.getProcedures(), diagnostic.getFK_patients(), diagnostic.getFK_doctors(), diagnostic.getID()
        );
        return (0 < executeUpdate(sql));
    }
    @Override
    public boolean delete(Diagnostic diagnostic) {
        String sql = String.format(
                "DELETE FROM `diagnostic` WHERE `diagnostic`.`ID` = %d;", diagnostic.getID()
        );
        return (0 < executeUpdate(sql));
    }


}
