package by.it.shkantau.project.java.dao;

import by.it.shkantau.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class AbstractDAO{
    public String lastSQL="";

    protected int executeUpdate(String sql) {
        int result = -1;
        lastSQL="executeUpdate:"+sql;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
            if (sql.trim().toUpperCase().startsWith("INSERT")) {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) result = resultSet.getInt(1);
            }
        } catch (Exception e) {
            lastSQL += e.toString();
            e.printStackTrace();

        }
        //System.out.println(result+":"+sql); //проверить SQL можно снимая комментарий с этой строки
        return result;
    }

    public int getLastID(String idColName, String tableName){
        String sql = "SELECT " + idColName + " FROM " + tableName + " ORDER BY " + idColName + " DESC LIMIT 1;";

        int result = -1;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            result = resultSet.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
