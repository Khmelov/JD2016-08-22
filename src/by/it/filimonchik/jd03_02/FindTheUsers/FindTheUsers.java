package by.it.filimonchik.jd03_02.FindTheUsers;

import by.it.filimonchik.jd03_02.Connection.ConnectionCreator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Raman.Filimonchyk on 07/11/2016.
 */
public class FindTheUsers {
    public static void main(String[] args) {
        try {
            Statement statement = ConnectionCreator.getConnection().createStatement();
            ResultSet set = statement.executeQuery(String.format("select * from users inner join " +
                    "role on users.FK_Role=role.id"));
            while (set.next()) {
                String line = String.format("Login = '%s', Password = '%s', Email = '%s', id = '%d', FK_Role = '%d' ",
                        set.getString("Login"), set.getString("Password"), set.getString("Email"),
                        set.getInt("id"), set.getInt("FK_Role"));
                System.out.println(line);
            }
            String lastLine = "Пользователей: ";
            set = statement.executeQuery("select count(*) from users");
            set.next();
            lastLine += set.getInt(1);
            set = statement.executeQuery("select count(*) from role");
            set.next();
            lastLine += ", ролей: " + set.getInt(1);
            System.out.println(lastLine);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
