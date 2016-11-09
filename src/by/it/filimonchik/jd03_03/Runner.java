package by.it.filimonchik.jd03_03;

import by.it.filimonchik.jd03_03.DAO.AdDAO;
import by.it.filimonchik.jd03_03.DAO.DAO;
import by.it.filimonchik.jd03_03.DAO.UsersDAO;
import by.it.filimonchik.jd03_03.bean.*;

import java.util.List;

/**
 * Created by Raman.Filimonchyk on 07/11/2016.
 */
public class Runner {

    static void showUsers() {
        System.out.println( "\nТаблица пользователей:") ;
        List<User> users = new UsersDAO().getAll( "" );
        for (User each : users) System.out.print( each );
    }

    static void showAd() {
        System.out.println( "\n"+"\nТаблица описания автомобиля:");
        List<Ad> ad = new AdDAO().getAll( "" );
        for (Ad each : ad) System.out.println( each );
    }

    public static void main(String[] args) {

        DAO dao = DAO.getDAO();

        System.out.println( "\n" + "Роли пользователей:" );
        for (Role role : dao.role.getAll( "" )) {
            System.out.println( role );
        }
        showUsers();

        System.out.println( "\n" + "Доступные цвета автомобилей: " );
        for (Color color : dao.color.getAll( "" )) {
            System.out.println( color );
        }

        System.out.println( "\n" + "Доступные модели автомобилей: " );
        for (Model model : dao.model.getAll( "" )) {
            System.out.println( model );
        }

        System.out.println( "\n" + "Доступные кузова автомобилей: " );
        for (Car_body car_body : dao.car_body.getAll( "" )) {
            System.out.println( car_body );
        }
        showUsers();

        User user = new User( 1, "user2", "user2", "user2@tut.by", 2 );
        if (dao.user.create( user )) System.out.print( "\n" + "Добавлен:" + "\n" + user );
        showUsers();
        user = dao.user.getAll( "WHERE ID>2" ).get( 0 );
        user.setLogin( "update_login" );
        if (dao.user.update( user )) System.out.print( "\n" + "Изменен:" + "\n" + user );
        showUsers();
        if (dao.user.delete( user )) System.out.print( "\n" + "Удален:" + "\n" + user );
        showUsers();

        showAd();
        Ad ad = new Ad(0, 1, 3, 4, 30000, 2);
        if (dao.ad.create( ad )) System.out.print( "\n" + "Добавлен:" + "\n" + ad );
        showAd();
        ad = dao.ad.getAll( "WHERE ID>2" ).get( 0 );
        ad.setFK_Color( 3 );
        if (dao.ad.update( ad )) System.out.print( "\n" + "Изменен:" + "\n" + ad );
        showAd();
        if (dao.ad.delete( ad )) System.out.print( "\n" + "Удален:" + "\n" + ad );
        showAd();
        }
}
