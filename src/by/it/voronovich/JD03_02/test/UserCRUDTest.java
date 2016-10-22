package by.it.voronovich.JD03_02.test;

import by.it.voronovich.JD03_02.bean.User;
import by.it.voronovich.JD03_02.crud.UserCRUD;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserCRUDTest {

    @Test
    public void create() throws Exception {
        double random = Math.random();
        String line = "" + random;
        User user = new User(0, line, line, line, line, line, 2);
        UserCRUD userCRUD = new UserCRUD();
        String user1 = userCRUD.create(user).toString();
        String user2 = userCRUD.read(user.getIdUsers()).toString();
        assertEquals(user1, user2);
        userCRUD.delete(user);
    }

    @Test
    public void update() throws Exception {
        double random = Math.random();
        String line = "" + random;
        User user = new User(0, line, line, line, line, line, 2);
        UserCRUD userCRUD = new UserCRUD();
        userCRUD.create(user);
        double random1 = Math.random();
        String line1 = "" + random1;
        user.setName(line1);
        String user1 = userCRUD.update(user).toString();
        String user2 = userCRUD.read(user.getIdUsers()).toString();
        assertEquals(user1, user2);
        userCRUD.delete(user);
    }

    @Test
    public void delete() throws Exception {
        double random = Math.random();
        String line = "" + random;
        User user = new User(0, line, line, line, line, line, 2);
        UserCRUD userCRUD = new UserCRUD();
        userCRUD.create(user);
        boolean user1 = userCRUD.delete(user);
        boolean user2 = true;
        assertEquals(user1, user2);
    }
}