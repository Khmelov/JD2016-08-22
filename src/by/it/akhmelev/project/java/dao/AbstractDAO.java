package by.it.akhmelev.project.java.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class AbstractDAO{
    public String lastSQL="";
    //общая команда для Create Update Delete
    protected int executeUpdate(String sql) {
        int result = -1;
        lastSQL="executeUpdate:"+sql;
        try (Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
            //если это была вставка вернем ключ, а иначе вернем число записей
            if (sql.trim().toUpperCase().startsWith("INSERT")) {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) result = resultSet.getInt(1);
            }
        } catch (Exception e) {
            //тут нужно логгирование SQLException(e);
        }
        //System.out.println(result+":"+sql); //проверить SQL можно снимая комментарий с этой строки
        return result;
    }
}
