package by.it.aborisenok.JD03_02;

import by.it.aborisenok.JD03_02.crud.*;


import java.sql.Connection;
import java.sql.SQLException;


/**
 * Created by Лёша on 21.10.2016.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionCreator.getConnection();
        if (!connection.isClosed())
            System.out.println("Open");
        connection.close();
        if (connection.isClosed())
            System.out.println("Close");

        Talon talon = new Talon(0, 1, 1, 1, 1);

        TalonCRUD talonCRUD = new TalonCRUD();

        talon = talonCRUD.create(talon);

        System.out.print(talonCRUD.read(talon.getID()));

        talon.setFK_Doctor(2);
        talon.setFK_User(2);
        talon = talonCRUD.update(talon);
        System.out.println(talon.getID());

        System.out.print(talonCRUD.read(talon.getID()));

        if (talonCRUD.delete(talon))
            System.out.print("Удален №" + talon.getID());


//          Policlinic policlinic = new Policlinic(0, "1st Minsk Policlinic", "Minsk", "Lobanka", 1);
//
//        PoliclinicCRUD policlinicCRUD = new PoliclinicCRUD();
//
//        policlinic = policlinicCRUD.create(policlinic);
//        System.out.println(policlinic.getID());
//
//        System.out.print(policlinicCRUD.read(policlinic.getID()));
////
//        policlinic.setName("2st Minsk Policlinic");
//        policlinic.setStreet("Pupkin");
//        policlinic = policlinicCRUD.update(policlinic);
//        System.out.println(policlinic.getID());
//
//        System.out.print(policlinicCRUD.read(policlinic.getID()));
//
//        if (policlinicCRUD.delete(policlinic))
//            System.out.print("Удален №"+policlinic.getID());


//        long time = System.currentTimeMillis();
//        Timestamp timestamp = new Timestamp(time);
//        System.out.println(timestamp);
//
//        Pacient pacient = new Pacient(0, "Frady", "Jonson", timestamp, "Minsk", "Engelsa", 12, 31);
//
//        PacientCRUD pacientCRUD = new PacientCRUD();
//
//        pacient = pacientCRUD.create(pacient);
//
//        System.out.print(pacientCRUD.read(pacient.getID()));
//
//        pacient.setName("Vasiliy");
//        pacient.setSurname("Pupkin");
//        pacient = pacientCRUD.update(pacient);
//        System.out.println(pacient.getID());
//
//        System.out.print(pacientCRUD.read(pacient.getID()));
//
//        if (pacientCRUD.delete(pacient))
//            System.out.print("Удален №" + pacient.getID());

//        Doctor doctor = new Doctor(0, "Frady", "Jonson", "yrolog", "hight", 423, 1);
//
//        DoctorCRUD doctorCRUD = new DoctorCRUD();
//
//        doctor = doctorCRUD.create(doctor);
//        System.out.println(doctor.getID());
//
//        System.out.print(doctorCRUD.read(doctor.getID()));
//
//        doctor.setName("Vasiliy");
//        doctor.setSurname("Pupkin");
//        doctor = doctorCRUD.update(doctor);
//        System.out.println(doctor.getID());
//
//        System.out.print(doctorCRUD.read(doctor.getID()));
//
//        if (doctorCRUD.delete(doctor))
//            System.out.print("Удален №"+doctor.getID());



//        long time = System.currentTimeMillis();
//        System.out.println(time);
//        Date date = new Date(time);
//        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
//        System.out.println(format.format(date));
//        Timestamp timestamp = new Timestamp(time);
//        System.out.println(timestamp);
//
//        VisitDate visitDate = new VisitDate(0, timestamp, 1);
//        visitDate.getVisitTime();
//        System.out.println(visitDate.getVisitTime());
//
//
//
//        VisitDateCRUD visitDateCRUD = new VisitDateCRUD();
//
//       visitDate = visitDateCRUD.create(visitDate);
//        System.out.println(visitDate.getID());
//
//        System.out.print(visitDateCRUD.read(visitDate.getID()));
//
//        visitDate.setVisitTime(new Timestamp(System.currentTimeMillis()));
//        visitDate = visitDateCRUD.update(visitDate);
//        System.out.println(visitDate.getID());
//
//        System.out.print(visitDateCRUD.read(visitDate.getID()));
//
//        if (visitDateCRUD.delete(visitDate))
//            System.out.print("Удален №"+visitDate.getID());
//
//
//    }
    }
}
