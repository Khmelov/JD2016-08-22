package by.it.shkantau.jd03.jd03_02;

import by.it.shkantau.jd03.jd03_01.ConnectionCreator;
import by.it.shkantau.jd03.jd03_01.DbManager;
import by.it.shkantau.jd03.jd03_02.crud.UserBean;
import by.it.shkantau.jd03.jd03_02.crud.UserCRUD;

import java.io.FileNotFoundException;
import java.sql.*;

public class Runner_jd03_02 {

    public static void main(String[] args) {

            taskA();
            taskB();
            taskC();
    }

    private static void taskC() {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            System.out.println("Clearing data from tables");
            DbManager.clearTables(statement);
            System.out.println("Dropping tables");
            DbManager.removeTables(statement);

            System.out.println("Create tables");
            DbManager.createTables(statement);
            System.out.println("Filling tables with data");
            DbManager.fillTables(statement);
        }catch (SQLException | FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private static void taskB() {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    "SELECT users.user_id,users.login,users.pass,users.email, roles.name " +
                            "FROM airportdb.users " +
                            "INNER JOIN roles " +
                            "ON users.role=roles.role_id;"
            );
            while (resultSet.next()) {
//            ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
//            int columnCount=resultSetMetaData.getColumnCount();
//            for (int i = 1; i < columnCount+1; i++) {
//                System.out.print(resultSetMetaData.getColumnLabel(i) + "=" + resultSet.getString(i) + "\t");
//            }
//            System.out.println();

                System.out.println("user_id=" + resultSet.getInt(1) + ", login=" + resultSet.getString(2) + ", pass=" + resultSet.getString(3) +
                        ", email=" + resultSet.getString(4) + ", role=" + resultSet.getString(5));
            }
            System.out.println("Row count in users table = " + getIntFormSQL(statement, "SELECT COUNT(*) FROM users") +
                    ", different role count in users table = " + getIntFormSQL(statement, "SELECT  COUNT(DISTINCT role) FROM users;"));
        }catch (SQLException | FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private static void taskA() {

//        System.out.println("role_id by roleName: user - " +getIdByName(statement, "roles" , "user"));
//        testRussianLiterals(statement);

        UserCRUD userCRUD = new UserCRUD();
        UserBean userBean = new UserBean("newUser","email@email.com","*****",3);
//            CREATE+READ
        UserBean userBean1 = userCRUD.read(userCRUD.create(userBean));
        System.out.println("Created user="+userBean + ", readed user="+userBean1);
//            UPDATE+READ
        System.out.print("beforeUpdateUser="+userBean+", ");
        userBean1 = userCRUD.read(userCRUD.update(new UserBean(userBean.getId(), "updatedLoigin", "update@email.com", "updatedPass", 2)));
        System.out.print("afterUpdateUser="+userBean1);
//            DELETE
        System.out.println("Deleted user_id ="+userCRUD.delete(userBean));
    }

    private static int getIdByName(Statement  statement, String tableName, String columnName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT role_id FROM "+tableName +" WHERE name='"+columnName+"';");
        while (resultSet.next()){
            return resultSet.getInt(1);
        }
        throw new SQLException("Can't find role with name="+columnName+".");
    }

    private static void testRussianLiterals(Statement statement) throws SQLException {
        // test russian language at the DB
        statement.executeUpdate("INSERT INTO users(email,login,pass,role) VALUES('test@gmail.com','русишШвайнэ', '123',3)");
        ResultSet resultSet = statement.executeQuery("SELECT user_id, email, login, role FROM users WHERE email='"+"test@gmail.com"+"';");
        resultSet.next();
        System.out.println("ID="+resultSet.getString(1)+", email="+resultSet.getString(2)+", login="+resultSet.getString(3)+", role="+resultSet.getString(4));
    }

    private static int getIntFormSQL(Statement statement, String sql) throws SQLException {
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        return resultSet.getInt(1);
    }


}
