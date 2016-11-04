package by.it.aborisenok.JD03_02;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * Created by Лёша on 24.10.2016.
 */
public class SearchRoleIDByUserName {
    public static void main(String[] args) {
        ConnectionCreator.setBdName("aborisenok");
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {

            //получаем пользователей. Если неизвестно число полей, то нужно получить метаданные
//
            ResultSet resultSet = statement.executeQuery("SELECT user.ID, user.Name, user.Surname, role.ID, role.Role FROM `" + ConnectionCreator.getBdName() + "`.`user` " +
                    "INNER JOIN `" + ConnectionCreator.getBdName() + "`.`role` ON user.FK_Role=role.ID");
            while (resultSet.next()) {
                ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
                int columnCount = resultSetMetaData.getColumnCount();
                for (int i = 1; i < columnCount+1; i++) {
//                    System.out.println(")");
                    System.out.print(
                            resultSetMetaData.getColumnLabel(i) + "=" +
                                    resultSet.getString(i) + "\t"
                    );
                }
                System.out.println();
            }
            //общее число записей (для примера, правильнее сделать свой счетчик в предыдущем запросе)
            resultSet=statement.executeQuery("SELECT COUNT(*) FROM `" + ConnectionCreator.getBdName() + "`.`user` INNER JOIN role ON user.FK_Role=role.ID");
            if (resultSet.next())
                System.out.println("Всего записей: "+resultSet.getInt(1));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
