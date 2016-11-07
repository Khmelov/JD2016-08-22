package by.it.filimonchik.jd03_02;

import by.it.filimonchik.jd03_02.bean.*;
import by.it.filimonchik.jd03_02.crud.*;

import java.sql.SQLException;

/**
 * Created by Raman.Filimonchyk on 07/11/2016.
 */
public class Runner {
        public static void main(String[] args) {
            User user=new User(0, "admin", "abc", "admin@admin.by", 1);
            UserCRUD userCRUD=new UserCRUD();

            Ad ad=new Ad(0, 2, 3, 4, 20000, 2);
            AdCRUD adCRUD=new AdCRUD();

            Role role = new Role(1,"");
            RoleRead roleRead = new RoleRead();

            Color color = new Color(2,"");
            ColorRead colorRead = new ColorRead();

            Model model = new Model(2,"");
            ModelRead modelRead = new ModelRead();

            Car_body car_body = new Car_body(2,"");
            Car_bodyRead car_bodyRead = new Car_bodyRead();

            try {

                role = roleRead.read( role.getID() );
                System.out.println("Role. \n" + "Данные о ролях считаны: " + role + "\n");

                adCRUD.create(ad);
                System.out.println("Ad. \n" + "Объявление создано: " + ad);

                ad=adCRUD.read(ad.getID());
                System.out.println("Объявление считано: " + ad);

                ad.setPrice(10000);
                adCRUD.update(ad);
                System.out.println("Данные о стоимости обновлены: " + ad);

                adCRUD.delete(ad);
                System.out.println("Объявление удалено: " + ad + "\n");

                userCRUD.create(user);
                System.out.print("Users. \n" + "Пользователь создан: " + user);

                user=userCRUD.read(user.getID());
                System.out.print("Данные пользователя считаны: " + user);

                user.setEmail("Email@email.by");
                userCRUD.update(user);
                System.out.print("Данные пользователя обновлены: " + user);

                userCRUD.delete(user);
                System.out.println("Пользователь удален: " + user);

                color = colorRead.read( color.getID() );
                System.out.println("Colors. \n" + "Данные о расцветках машин считаны: " + color + "\n");

                model = modelRead.read( model.getID() );
                System.out.println("Models. \n" + "Данные о моделях машин считаны: " + model + "\n");

                car_body = car_bodyRead.read( car_body.getID() );
                System.out.println("Car body. \n" + "Данные о кузове машин считаны: " + car_body + "\n");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
