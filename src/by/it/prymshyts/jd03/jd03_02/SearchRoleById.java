package by.it.prymshyts.jd03.jd03_02;

import by.it.prymshyts.jd01.jd01_02.Util;
import by.it.prymshyts.jd03.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

class SearchRoleById {
    public static void main(String[] args) {
        try (Connection connection = DB.getConnection();
             Statement statement = connection.createStatement()
        ) {
            System.out.print("Введите ID роли: ");
            String roleID = Util.getConsoleLine();
            String sql = String.format("SELECT Role.Role FROM Role WHERE Role.ID=%s;", roleID);

            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                System.out.println(String.format("Название роли с ID = %s: %s", roleID, resultSet.getString("Role")));
            } else {
                System.out.println(String.format("Роль с ID = %s не найдена", roleID));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
