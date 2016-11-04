package by.it.dubatovka.project_helpdesk.java.dao;

import by.it.dubatovka.project_helpdesk.java.beans.Objects;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ObjectsDAO extends AbstractDAO implements InterfaceDAO<Objects> {
    @Override
    public Objects read(int id) {
        List<Objects> objList = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (objList.size() > 0) return objList.get(0);
        else return null;
    }

    @Override
    public boolean create(Objects object) {
        String createObjectsSQL = String.format("insert into objects(zia) values ('%s')", object.getZia());
        object.setID(executeUpdate(createObjectsSQL));
        return (object.getID() > 0);
    }

    @Override
    public boolean update(Objects object) {
        String updateObjectSQL = String.format("UPDATE objects SET zia = '%s' WHERE objects.ID='%d'",
                object.getZia(), object.getID());
        return (0 < executeUpdate(updateObjectSQL));
    }

    @Override
    public boolean delete(Objects object) {
        String deleteObjectSQL = String.format("DELETE FROM objects Where objects.ID = '%d'", object.getID());
        return (0 < executeUpdate(deleteObjectSQL));
    }

    @Override
    public List<Objects> getAll(String WhereAndOrder) {
        List<Objects> objectsList =new ArrayList<>();
        String sql = "SELECT * FROM objects " + WhereAndOrder + " ;";
      try (Connection connection= ConnectionCreator.getConnection();
           Statement statement=connection.createStatement()){
          ResultSet rs=statement.executeQuery(sql);
          while (rs.next()){
              Objects object=new Objects();
              object.setID(rs.getInt("ID"));
              object.setZia(rs.getString("zia"));
              objectsList.add(object);
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }
        return objectsList;
    }
}
