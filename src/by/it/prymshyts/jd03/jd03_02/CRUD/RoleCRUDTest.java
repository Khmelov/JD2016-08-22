package by.it.prymshyts.jd03.jd03_02.CRUD;

import org.junit.Test;

import static org.junit.Assert.*;

public class RoleCRUDTest {
    private RoleCRUD roleCRUD = new RoleCRUD();
    private Role role = new Role(3, "Test");
    private Role roleToUpd = new Role(2, "Tester");

    @Test
    public void create() throws Exception {
        assertTrue(roleCRUD.create(role));
    }

    @Test
    public void read() throws Exception {
        assertEquals(roleCRUD.read(1).getRole(), "Administrator");
    }

    @Test
    public void update() throws Exception {
        assertTrue(roleCRUD.update(roleToUpd));
    }

    @Test
    public void delete() throws Exception {
        assertTrue(roleCRUD.delete(role));
    }
}