package by.it.voronovich.JD03_02.crud;

import by.it.voronovich.JD03_02.ConnectionCreator;
import by.it.voronovich.JD03_02.bean.CatalogGood;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CatalogGoodCRUD {

    public CatalogGood create(CatalogGood cg) throws SQLException {
        cg.setIdCatalog(0);
        //формирование строки createUserSQL по данным bean user
        String createCatalogGoodSQL = String.format(Locale.ENGLISH,
                "insert into catalog(Brand, Model, Price, ReleaseDate, Weight) values('%s','%s',%f,'%s','%s');",
                cg.getBrand(), cg.getModel(), cg.getPrice(), cg.getReleaseDate(), cg.getWeight()
        );
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement(); //создаем объект для обращения к базе
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            if (statement.executeUpdate(createCatalogGoodSQL) == 1)
            {
                //если все добавлено то узнаем последний ID
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                //извлекаем из resultSet последний ID
                if (resultSet.next())
                    cg.setIdCatalog(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return cg;
    }

    public CatalogGood read(int idCatalog) throws SQLException {
        CatalogGood cgResult = null;
        String readCatalogGoodSQL = "SELECT * FROM catalog where idCatalog=" + idCatalog;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readCatalogGoodSQL);
            if (resultSet.next()) {
                cgResult = new CatalogGood(
                        resultSet.getInt("idCatalog"),
                        resultSet.getString("Brand"),
                        resultSet.getString("Model"),
                        resultSet.getDouble("Price"),
                        resultSet.getString("ReleaseDate"),
                        resultSet.getString("Weight"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return cgResult;
    }

    public CatalogGood update(CatalogGood cg) throws SQLException {
        CatalogGood cgResult = null;
        String updateCatalogGoodSQL = String.format(Locale.ENGLISH,
                "UPDATE catalog SET Brand = '%s', Model = '%s', Price = %f, ReleaseDate = '%s', Weight = '%s' WHERE catalog.idCatalog = %d",
                cg.getBrand(), cg.getModel(), cg.getPrice(), cg.getReleaseDate(), cg.getWeight(), cg.getIdCatalog()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updateCatalogGoodSQL) == 1)
                cgResult = cg;
        } catch (SQLException e) {
            throw e;
        }
        return cgResult;
    }

    public boolean delete(CatalogGood cg) throws SQLException {
        String deleteCatalogGoodSQL = String.format("DELETE FROM catalog WHERE catalog.idCatalog = %d", cg.getIdCatalog());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deleteCatalogGoodSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }
}
