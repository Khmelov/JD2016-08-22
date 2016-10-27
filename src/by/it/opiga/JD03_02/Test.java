package by.it.opiga.JD03_02;

import by.it.opiga.JD03_01.FillDbOrders;
import by.it.opiga.JD03_02.CRUD.*;

import java.sql.*;

/**
 * Created by Asus on 19.10.2016.
 */
public class Test {
    public static void main(String[] args) {

//        Reset.Reset("t04_status");
//        Reset.Reset("t03_order");
//        Reset.Reset("t02_user");
//        Reset.Reset("t01_role");
//        System.out.println("таблицы удалены ");
//
//        FillDbOrders.createTable();

//    //поиск ID роли по имени
//        Role findRoleID=null;
//        //введите имя
//        String name="";
//        Scanner scan=new Scanner(System.in);
//        name=scan.next();
//        scan.close();
//        try {
//           findRoleID= RoleRead.read(name);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println(findRoleID.toString());


//CRUD для таблицы t03_orders
//        order ord1 = new order("Ivanov", "MP256988", 292569871, "econom", GetTime.getCurrentTime(), GetTime.getTimeLeave(), "cash", 1, 1);
//        order ord3 = new order(1, "Moroz", "MP87459", 29129825, "econom", GetTime.getCurrentTime(), GetTime.getTimeLeave(), "cash", 1, 1);
//        try {
//            OrderCRUD.create(ord1);
//            OrderCRUD.read(ord1.getId());
//            OrderCRUD.update(ord3);
//            OrderCRUD.read(ord1.getId());
//            if (OrderCRUD.delete(ord1.getId())) System.out.println("запись удалена ");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//CRUD для таблицы t02_user
//        user us1 = new user("qwe", "1589", "qwe@mail.ru",1);
//        user us2 = new user(1,"iuo", "1589","iuo@mail.ru", 2);
//        try {
//            UserCRUD.create(us1);
//            UserCRUD.read(us1.getID());
//            UserCRUD.update(us2);
//            UserCRUD.read(us2.getID());
//            if (UserCRUD.delete(us2.getID())) System.out.println("запись удалена ");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        showUsers();


    }
    public static void showUsers()
    {    int count=0;
        String readUserSQL = "SELECT t02_user.ID,t02_user.login,t02_user.pass,t02_user.email, t01_role.role"
        +" FROM `t02_user` INNER JOIN `t01_role`ON (t02_user.FK_role=t01_role.ID)" ;
        try {
            try (
                    Connection connection = ConnectionCreator.getConnection();
                    Statement statement = connection.createStatement();
            ) {
                ResultSet resultSet=statement.executeQuery(readUserSQL);
                while (resultSet.next())
                {
                    ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
                    int columnCount=resultSetMetaData.getColumnCount();
                    for (int i = 1; i < columnCount+1; i++) {
                        System.out.print(resultSetMetaData.getColumnLabel(i)+"="+resultSet.getString(i)+"\t");
                    }
                    count++;
                    System.out.println();
                }
                //resultSet=statement.executeQuery(readUserSQL);
                //if(resultSet.next())
                    System.out.println("Всего записей = "+count);
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
