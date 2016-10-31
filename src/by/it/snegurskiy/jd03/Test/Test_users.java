package by.it.snegurskiy.jd03.Test;

import by.it.snegurskiy.jd03.classwork.Bean.Users;
import by.it.snegurskiy.jd03.classwork.CRUD.UsersCRUD;

import java.sql.*;

public class Test_users {

    public static void main(String[] args) throws SQLException {
        Users user=new Users(0,"Surname" , "Name", "Login","Password", 2);
        UsersCRUD testUser = new UsersCRUD();
        testUser.create(user);
        System.out.println(user);
        user.setName("Name2");
        testUser.update(user);
        user=testUser.read(user.getID());
        System.out.println(user);
        testUser.delete(user);

    }
}
