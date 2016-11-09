package by.it.zaharova.JD03_03;

import by.it.zaharova.JD03_03.beans.Patients;
import by.it.zaharova.JD03_03.custom_dao.DAO;
import by.it.zaharova.JD03_03.custom_dao.PatientsDAO;

import java.sql.SQLException;
import java.util.List;

public class V1_CustomRunner {

    static void showPatientss(){
        //покажем все, что есть в таблице пользователей
        System.out.println("\nТаблица пациентов:");
        List<Patients> patients=new PatientsDAO().getAll("");
        for (Patients each:patients) System.out.println(each);
    }

    public static void main(String[] args) throws SQLException {
        //инициализация работы с базой
        DAO dao = DAO.getDAO();
      
        showPatientss();

        Patients patients = new Patients(4, "ghdjf", "ghadfli","ifwiejow12","12345646",1);
        //добавим пользователя
        if (dao.patients.create(patients)) System.out.println("\nДобавлен:" + patients);
        showPatientss();

        //извлечем и обновим пользователя с email siivanov@mail.ru
        patients = dao.patients.getAll("WHERE ID>2").get(0);
        if (dao.patients.update(patients)) System.out.println("\nИзменен:" + patients);
        showPatientss();

        //удалим пользователя
        if (dao.patients.delete(patients)) System.out.println("\nУдален:" + patients);
        showPatientss();
    }
}
