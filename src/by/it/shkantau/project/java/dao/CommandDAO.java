package by.it.shkantau.project.java.dao;

import by.it.shkantau.project.java.beans.Command;
import by.it.shkantau.project.java.connection.ConnectionCreator;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommandDAO extends AbstractDAO implements IDAO <Command> {
    @Override
    public Command read(int id) {
        List<Command> commands =  getAll("WHERE id_commands=" + id + " LIMIT 0,1");
        return (commands.size() > 0) ? commands.get(0) : null;
    }

    @Override
    public int create(Command entity) {
        String sql = String.format("INSERT INTO commands(name) VALUES('%s');",
                entity.getName());
//        entity.setId(executeUpdate(sql));
        return executeUpdate(sql);
    }

    @Override
    public boolean update(Command entity) {
        String sql = String.format("UPDATE `commands` SET `name`='%s' WHERE `commands`.`id_commands` = %d;",
                entity.getName(), entity.getId());
        return (0<executeUpdate(sql));
    }

    @Override
    public boolean delete(Command entity) {
        String sql = String.format("DELETE FROM `commands` WHERE  `commands`.`id_commands`=%d;", entity.getId());
        executeUpdate(sql);
        return (0<executeUpdate(sql));
    }

    @Override
    public List <Command> getAll(String WhereAndOrder) {
        List<Command> commands = new ArrayList<>();
        String sql = "SELECT * FROM commands " + WhereAndOrder + ";";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                commands.add(new Command(resultSet.getInt("id_commands"),resultSet.getString("name")));
            }

        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return commands;
    }
}
