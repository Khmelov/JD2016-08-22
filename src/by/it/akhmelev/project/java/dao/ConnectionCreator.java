package by.it.akhmelev.project.java.dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {
    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");

            //ниже способ, который работает, но ненадежно
            //Driver driver = new FabricMySQLDriver();
            //DriverManager.registerDriver(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Памятка. Корректно держать настройки соединения вне кода (!)
    private static final String URL_DB =
            "jdbc:mysql://127.0.0.1:2016/it_academy"
             +"?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER_DB = "root";
    private static final String PASSWORD_DB = "";

    //аналог синглтона на случай множественного обращения
    private static volatile Connection connection = null;

    public static Connection getConnection2() throws SQLException {
        if (connection == null || connection.isClosed()) {
                synchronized (URL_DB) {
                    if (connection == null || connection.isClosed())
                        connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
                }
        }
        return connection;
    }


    //получение соединения из пула
    //смотрите файлы context.xml
    //и web.xml
    public static Connection getConnection() {

        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/my_sql_akhmelev");
            connection=ds.getConnection();
            return connection;
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
