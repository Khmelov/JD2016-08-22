package by.it.snegurskiy.Project.java.DAO;



public class DAO {


    private static DAO dao; //синглтон для DAO

    public UserDAO user;    //DAO для пользователей
    public RoleDAO role;    //DAO для ролей пользователей
    public PaymentDAO payment;    //DAO для платежей
    public AccountDAO account;    //DAO для счетов
    public UserstatusDAO status;        //DAO для статусов пользователей


    public static DAO getDAO() {   //метод, который создает DAO или возвращает существующий экземпляр
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.user = new UserDAO();
                    dao.role = new RoleDAO();
                    dao.payment= new PaymentDAO();
                    dao.account= new AccountDAO();
                    dao.status = new UserstatusDAO();

                }
            }
        }
        return dao;
    }
}
