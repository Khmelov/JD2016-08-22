package by.it.opiga.JD03_03.dao;

import by.it.opiga.JD03_04.project.java.dao.ConnectionCreator;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by Asus on 28.10.2016.
 */
public class DAO {
    private static DAO dao;

    public UserDAO user;
    public RoleDAO role;
    public OrderDAO order;

    //метод создает дао или возвращает существующий
    public static DAO getDAO()
    {
        if(dao==null)
        {
            synchronized (DAO.class)
            {
                if(dao==null)
                {
                    dao=new DAO();
                    dao.role=new RoleDAO();
                    dao.user=new UserDAO();
                    dao.order=new OrderDAO();

                }
            }

        }
        return dao;
    }


    protected int executeUpdate(String sql) {
        int result = -1;

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement   = connection.createStatement()
        ) {
            result = statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
