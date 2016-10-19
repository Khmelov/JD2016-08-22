package by.it.prymshyts.jd03.jd03_03;

import by.it.prymshyts.jd03.DB;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UnivDAO<T> {

    private T bean;
    private String table;
    private Field[] fields;

    public UnivDAO(T bean, String table, Field[] fields) {
        this.bean = bean;
        this.table = table;
        this.fields = fields;
    }

    public List<T> getAll(String condition) {
        List<T> beans = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " " + condition + ";";

        try (Connection connection = DB.getConnection();
             Statement statement   = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                T newBean = newBean();
                for (int i = 1; i <= fields.length; i++) {
                    Field f = fields[i - 1];
                    f.setAccessible(true);
                    String strType = f.getType().toString();

                    try {
                        if (f.getType() == Boolean.class || strType.equals("boolean"))
                            f.set(newBean, rs.getBoolean(i));
                        if (f.getType() == Byte.class || strType.equals("byte"))
                            f.set(newBean, rs.getByte(i));
                        if (f.getType() == Integer.class || strType.equals("int"))
                            f.set(newBean, rs.getInt(i));
                        if (f.getType() == Double.class || strType.equals("double"))
                            f.set(newBean, rs.getDouble(i));
                        if (f.getType() == Float.class || strType.equals("float"))
                            f.set(newBean, rs.getFloat(i));
                        if (f.getType() == Long.class || strType.equals("long"))
                            f.set(newBean, rs.getLong(i));
                        if (f.getType() == Short.class || strType.equals("short"))
                            f.set(newBean, rs.getShort(i));
                        if (f.getType() == String.class)
                            f.set(newBean, rs.getString(i));
                        if (f.getType() == Date.class)
                            f.set(newBean, rs.getDate(i));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                beans.add(newBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return beans;
    }

    private T newBean() {
        try {
            return (T) bean.getClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public T read(int id) throws SQLException {
        List<T> beans = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (beans.size() > 0) {
            return beans.get(0);
        } else
            return null;
    }

    public boolean update(T bean) throws SQLException {
        String sql = "UPDATE `" + table + "` SET ";
        String delimiter = "";
        try {
            for (int i = 1; i < fields.length; i++) {
                Field f = fields[i];
                f.setAccessible(true);
                sql = sql.concat(delimiter + "`" + f.getName() + "` = '" + f.get(bean) + "'");
                delimiter = ", ";
            }
            fields[0].setAccessible(true);
            sql = sql.concat(" WHERE `" + fields[0].getName() + "` = '" + fields[0].get(bean) + "'");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return (0 < executeUpdate(sql, false));
    }

    public boolean create(T bean) throws SQLException {
        String names = "";
        String values = "";
        String delimiter = "";
        try {
            for (int i = 1; i < fields.length; i++) {
                Field f = fields[i];
                f.setAccessible(true);
                names = names.concat(delimiter + f.getName());
                values = values.concat(delimiter + "'" + f.get(bean) + "'");
                delimiter = ", ";
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        String sql = "insert INTO " + table + " (" + names + ") values(" + values + ")";

        int id = executeUpdate(sql, true);

        if (id > 0) {
            try {
                fields[0].setAccessible(true);
                fields[0].set(bean, id);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return (id > 0);
    }

    public boolean delete(T bean) throws SQLException {
        String sql = null;
        try {
            sql = "DELETE FROM `" + table + "` WHERE `" + table + "`.`ID` = '" + fields[0].get(bean) + "';";
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (0 < executeUpdate(sql, false));
    }

    private static int executeUpdate(String sql, boolean returnLastID) throws SQLException {
        int result;

        try (Connection connection = DB.getConnection();
             Statement statement   = connection.createStatement()
        ) {
            result = statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);

            if (result>0 && returnLastID) {
                ResultSet resultSet = statement.getGeneratedKeys();

                if (resultSet.next()) {
                    result = resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }

        return result;
    }

}
