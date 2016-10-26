package by.it.kisel.JD03_02;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Meta_Join_Count {
    public static void main(String[] args) {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();) {

            //получаем пользователей. Если неизвестно число полей, то нужно получить метаданные
            ResultSet resultSet = statement.executeQuery("SELECT * FROM persons INNER JOIN role ON persons.FK_Role=role.ID");
            while (resultSet.next()) {
                ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
                int columnCount=resultSetMetaData.getColumnCount();
                for (int i = 1; i < columnCount+1; i++) {
                System.out.print(
                        resultSetMetaData.getColumnLabel(i) + "=" +
                                resultSet.getString(i) + "\t"
                );
                }
                System.out.println();
            }
            //общее число записей (для примера, правильнее сделать свой счетчик в предыдущем запросе)
            resultSet=statement.executeQuery("SELECT COUNT(*) FROM persons INNER JOIN role ON persons.FK_Role=role.ID");
            if (resultSet.next())
                System.out.println("Всего записей: "+resultSet.getInt(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
