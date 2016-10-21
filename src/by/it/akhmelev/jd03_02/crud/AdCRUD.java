package by.it.akhmelev.jd03_02.crud;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class AdCRUD {
/*
    private int id;
    private String description;
    private String address;
    private int floor;
    private int floors;
    private String area;
    private double price;
    private int roomCount;
    private int fkUsers;

 */
    public Ad create(Ad ad) throws SQLException {
        ad.setId(0);
        //формирование строки createAdSQL по данным bean ad
        String createAdSQL = String.format(Locale.ENGLISH,
                "insert into ad(" +
                        "Description," +
                        "Address," +
                        "Floor," +
                        "Floors," +
                        "Area," +
                        "Price," +
                        "RoomCount," +
                        "FK_Users" +
                        ") values('%s','%s',%d,%d,%f,%f,%d,%d);",
                ad.getDescription(),
                ad.getAddress(),
                ad.getFloor(),
                ad.getFloors(),
                ad.getArea(),
                ad.getPrice(),
                ad.getRoomCount(),
                ad.getFkUsers()
        );
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement(); //создаем объект для обращения к базе
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            System.out.println(createAdSQL);


            if (statement.executeUpdate(createAdSQL) == 1)
            {
                //если все добавлено то узнаем последний ID
                ResultSet resultSet = statement.executeQuery(
                        String.format("SELECT LAST_INSERT_ID();")
                );
                //извлекаем из resultSet последний ID
                if (resultSet.next())
                    ad.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return ad;
    }

    public Ad read(int id) throws SQLException {
        Ad adResult = null;
        String readAdSQL = "SELECT * FROM ad where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readAdSQL);
            if (resultSet.next()) {
                adResult = new Ad(
                        resultSet.getInt("ID"),
                        resultSet.getString("Description"),
                        resultSet.getString("Address"),
                        resultSet.getInt("Floor"),
                        resultSet.getInt("Floors"),
                        resultSet.getFloat("Area"),
                        resultSet.getFloat("Price"),
                        resultSet.getInt("RoomCount"),
                        resultSet.getInt("FK_Users")
                );
            }
        } catch (SQLException e) {
            throw e;
        }
        return adResult;
    }

    public Ad update(Ad ad) throws SQLException {
        Ad adResult = null;
        String updateAdSQL = String.format(Locale.ENGLISH,
                "UPDATE ad " +
                        "SET Description = '%s'," +
                        " Address = '%s'," +
                        " Floor = %d," +
                        " Floors = %d," +
                        " Area = %f," +
                        " Price = %f," +
                        " RoomCount = %d," +
                        " FK_Users = %d" +
                " WHERE ad.ID = %d",
                ad.getDescription(),
                ad.getAddress(),
                ad.getFloor(),
                ad.getFloors(),
                ad.getArea(),
                ad.getPrice(),
                ad.getRoomCount(),
                ad.getFkUsers(),
                ad.getId()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            System.out.println(updateAdSQL);
            if (statement.executeUpdate(updateAdSQL) == 1)
                adResult = ad;
        } catch (SQLException e) {
            throw e;
        }
        return adResult;
    }

    public boolean delete(Ad ad) throws SQLException {
        String deleteAdSQL = String.format("DELETE FROM ad WHERE ad.ID = %d", ad.getId());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deleteAdSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }


}
