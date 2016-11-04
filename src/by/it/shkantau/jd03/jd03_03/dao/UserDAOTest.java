package by.it.shkantau.jd03.jd03_03.dao;


import by.it.shkantau.jd03.jd03_03.beans.Role;
import by.it.shkantau.jd03.jd03_03.beans.User;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserDAOTest {
    private UserDAO userDAO = new UserDAO();
    private User user = new User("TestLogin", "test@test.by","testpass", Role.USER_ROLE);
    private User user1 = new User(1, "updateLogin", "update@test.by","pass", Role.DISPATCHER_ROLE);

    @Test
    public void update() throws Exception {
        assertTrue(userDAO.update(user1));
    }

    @Test
    public void read() throws Exception {
        assertEquals(userDAO.read(1), user1);
    }

    @Test
    public void create() throws Exception {
        assertTrue(userDAO.create(user)>0);
    }

    @Test
    public void delete() throws Exception {
        int id = userDAO.getLastID("user_id", "users");
        user.setId(id);
        assertTrue(userDAO.delete(user));
    }

}