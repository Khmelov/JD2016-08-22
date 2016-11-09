package by.it.zaharova.JD03_02.crud;


import by.it.zaharova.JD03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DiagnosticCRUD {

    public Diagnostic create(Diagnostic diagnostic) throws SQLException {
        diagnostic.setID(0);
        //формирование строки
        // createDiagnosticSQL по данным bean diagnostic
        String createDiagnosticSQL = String.format(
                "insert into diagnostic(Illness,Drugs,Operations,Procedures,FK_patients, FK_doctors) values('%s','%s','%s','%s',%d,%d);",
                diagnostic.getIllness(), diagnostic.getDrugs(), diagnostic.getProcedures(), diagnostic.getProcedures(), diagnostic.getFK_patients(), diagnostic.getFK_doctors()
        );
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement(); //создаем объект для обращения к базе
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            if (statement.executeUpdate(createDiagnosticSQL) == 1) {
                //если все добавлено то узнаем последний ID
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                //извлекаем из resultSet последний ID
                if (resultSet.next())
                    diagnostic.setID(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return diagnostic;
    }

    public Diagnostic read(int id) throws SQLException {
        Diagnostic diagnosticResult = null;
        String readDiagnosticSQL = "SELECT * FROM diagnostic where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readDiagnosticSQL);
            if (resultSet.next()) {
                diagnosticResult = new Diagnostic(
                        resultSet.getInt("ID"),
                        resultSet.getString("Illness"),
                        resultSet.getString("Drugs"),
                        resultSet.getString("Operations"),
                        resultSet.getString("Procedures"),
                        resultSet.getInt("FK_patients"),
                        resultSet.getInt("FK_doctors"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return diagnosticResult;
    }

    public Diagnostic update(Diagnostic diagnostic) throws SQLException {
        Diagnostic diagnosticResult = null;
        String updateDiagnosticSQL = String.format(
                "UPDATE diagnostic SET Illness = '%s', Drugs = '%s', Operations = '%s', Procedures = '%s', FK_patients=%d, FK_doctors=%d WHERE diagnostic.ID = %d",
                diagnostic.getIllness(), diagnostic.getDrugs(), diagnostic.getProcedures(), diagnostic.getProcedures(), diagnostic.getFK_patients(), diagnostic.getFK_doctors(), diagnostic.getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updateDiagnosticSQL) == 1)
                diagnosticResult = diagnostic;
        } catch (SQLException e) {
            throw e;
        }
        return diagnosticResult;
    }

    public boolean delete(Diagnostic diagnostic) throws SQLException {
        String deleteDiagnosticSQL = String.format("DELETE FROM diagnostic WHERE diagnostic.ID = %d", diagnostic.getID());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deleteDiagnosticSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }


}
