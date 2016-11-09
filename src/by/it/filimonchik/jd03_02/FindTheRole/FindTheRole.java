package by.it.filimonchik.jd03_02.FindTheRole;
import by.it.filimonchik.jd03_02.Connection.ConnectionCreator;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Raman.Filimonchyk on 07/11/2016.
 */
public class FindTheRole  {
    public static void main(String[] args) throws Exception{
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            System.out.print("Введите ID роли: ");
            String roleID = Util.getLineFromConsole();
            String sql = String.format("SELECT Role.Role FROM Role WHERE Role.ID=%s;", roleID);

            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                System.out.println(String.format("Название роли с ID = %s: %s", roleID, resultSet.getString("Role")));
            } else {
                System.out.println(String.format("Роль с ID = %s не найдена", roleID));
            }

        } catch (MySQLSyntaxErrorException e) {
            System.out.print("Ошибка. Необходимо ввести целое число. Попробуйте снова.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}