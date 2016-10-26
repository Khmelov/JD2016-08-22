package by.it.prymshyts.jd03.jd03_02.CRUD;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserCRUDTest {
    private UserCRUD userCRUD = new UserCRUD();
    private User user = new User(3, "test", "test", "testpass", 2);
    private User userToUpd = new User(2, "test3@mail.ru", "test3", "test3pass", 2);

    @Test
    public void create() throws Exception {
        assertTrue(userCRUD.create(user));
    }

    @Test
    public void read() throws Exception {
        assertEquals(userCRUD.read(1).getLogin(), "test1");
    }

    @Test
    public void update() throws Exception {
        assertTrue(userCRUD.update(userToUpd));
    }

    @Test
    public void delete() throws Exception {
        assertTrue(userCRUD.delete(user));
    }
}