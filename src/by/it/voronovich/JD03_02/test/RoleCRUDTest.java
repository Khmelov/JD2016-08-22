package by.it.voronovich.JD03_02.test;

import by.it.voronovich.JD03_02.bean.Role;
import by.it.voronovich.JD03_02.crud.RoleCRUD;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RoleCRUDTest {
    @Test
    public void create() throws Exception {
        double random = Math.random();
        String line = "" + random;
        Role role = new Role(0, line);
        RoleCRUD roleCRUD = new RoleCRUD();
        String role1 = roleCRUD.create(role).toString();
        String role2 = roleCRUD.read(role.getIdRole()).toString();
        assertEquals(role1, role2);
        roleCRUD.delete(role);
    }

    @Test
    public void update() throws Exception {
        double random = Math.random();
        String line = "" + random;
        Role role = new Role(0, line);
        RoleCRUD roleCRUD = new RoleCRUD();
        roleCRUD.create(role);
        double random1 = Math.random();
        String line1 = "" + random1;
        role.setName(line1);
        String role1 = roleCRUD.update(role).toString();
        String role2 = roleCRUD.read(role.getIdRole()).toString();
        assertEquals(role1, role2);
        roleCRUD.delete(role);
    }

    @Test
    public void delete() throws Exception {
        double random = Math.random();
        String line = "" + random;
        Role role = new Role(0, line);
        RoleCRUD roleCRUD = new RoleCRUD();
        roleCRUD.create(role);
        boolean role1 = roleCRUD.delete(role);
        boolean role2 = true;
        assertEquals(role1, role2);
    }
}