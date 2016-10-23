package by.it.snegurskiy.jd03.classwork.DAO;

/**
 * Created by Acer on 24.10.2016.
 */
public class DAO {


    private static DAO dao; //синглтон для DAO

    public UserDAO user;    //DAO для пользователей
    public RoleDAO role;    //DAO для ролей пользователей
    public PaymentDAO payment;    //DAO для платежей
    public AccountDAO account;    //DAO для счетов
    public RoleaccountDAO roleaccount;        //DAO для ролей счетов


    public static DAO getDAO() {   //метод, который создает DAO или возвращает существующий экземпляр
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.user = new UserDAO();
                    dao.role = new RoleDAO();
                    dao.payment= new PaymentDAO();
                    dao.account= new AccountDAO();
                    dao.roleaccount = new RoleaccountDAO();

                }
            }
        }
        return dao;
    }
}
