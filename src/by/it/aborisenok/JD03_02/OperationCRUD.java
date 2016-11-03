package by.it.aborisenok.JD03_02;

import by.it.aborisenok.JD03_02.crud.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 * Created by aborisenok on 26.10.2016.
 */
public class OperationCRUD {
    public static void main(String[] args) throws SQLException {
        ConnectionCreator.setBdName("");
        Connection connection = ConnectionCreator.getConnection();

        ResetClass.BDDelete(connection);
        ResetClass.BDCreating(connection);
        ResetClass.tablesCreation(connection);

        UserCRUD userCRUD = new UserCRUD();
        RoleCRUD roleCRUD = new RoleCRUD();
        VisitDateCRUD visitDateCRUD = new VisitDateCRUD();
        DoctorCRUD doctorCRUD = new DoctorCRUD();
        PoliclinicCRUD policlinicCRUD = new PoliclinicCRUD();

        User user = new User(0, "alex", "alex1", "Valera", "Petrov", Timestamp.valueOf("1992-10-06 00:00:00"), "Minsk", "Lenina", 12, 32, 1);
        Role role = new Role(0, "User");
        VisitDate visitDate = new VisitDate(0, Timestamp.valueOf("2016-10-21 09:00:00"), 1);
        Doctor doctor = new Doctor(0, "Jonny", "Nickon", "Terapevt", "Hight", 23, 1);
        Policlinic policlinic = new Policlinic(0, "3rd Minsk Policlinic", "Minsk", "Nezavisimosti", 16);

        user = userCRUD.create(user);
        role = roleCRUD.create(role);
        visitDate = visitDateCRUD.create(visitDate);
        doctor = doctorCRUD.create(doctor);
        policlinic = policlinicCRUD.create(policlinic);

        System.out.println(userCRUD.read(user.getID()));
        System.out.println(roleCRUD.read(role.getID()));
        System.out.println(visitDateCRUD.read(visitDate.getID()));
        System.out.println(doctorCRUD.read(doctor.getID()));
        System.out.println(policlinicCRUD.read(policlinic.getID()));
        System.out.println();

        user.setName("Hello");
        user.setSurname("Hello");
        role.setRole("admin");
        visitDate.setVisitTime(Timestamp.valueOf("2016-10-22 23:00:00"));
        doctor.setName("Doctor");
        doctor.setSurname("Hause");
        policlinic.setName("Good hospital");

        user = userCRUD.update(user);
        role = roleCRUD.update(role);
        visitDate = visitDateCRUD.update(visitDate);
        doctor = doctorCRUD.update(doctor);
        policlinic = policlinicCRUD.update(policlinic);

        System.out.println(userCRUD.read(user.getID()));
        System.out.println(roleCRUD.read(role.getID()));
        System.out.println(visitDateCRUD.read(visitDate.getID()));
        System.out.println(doctorCRUD.read(doctor.getID()));
        System.out.println(policlinicCRUD.read(policlinic.getID()));

        if (userCRUD.delete(user))
            System.out.println("Удален №" + user.getID());
        if (roleCRUD.delete(role))
            System.out.println("Удален №" + role.getID());
        if (visitDateCRUD.delete(visitDate))
            System.out.println("Удален №" + visitDate.getID());
        if (doctorCRUD.delete(doctor))
            System.out.println("Удален №" + doctor.getID());
        if (policlinicCRUD.delete(policlinic))
            System.out.println("Удален №" + policlinic.getID());

    }
}
