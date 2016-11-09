package by.it.kisel.JD03_03.custom_dao;

public class DAO {

    private static DAO dao; //синглтон для DAO

    public PersonsDAO persons;    //DAO для пользователей
    public RoleDAO role;    //DAO для ролей
    public RoomsDAO rooms;        //DAO для номеров
    public OrdersDAO orders;       //DAO для заказов
    public StatusDAO status;       //DAO для статуса


    public static DAO getDAO() {   //метод, который создает DAO или возвращает существующий экземпляр
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.persons = new PersonsDAO();
                    dao.role = new RoleDAO();
                    dao.rooms = new RoomsDAO();
                    dao.orders = new OrdersDAO();
                    dao.status = new StatusDAO();
                    //новые куски DAO добавляются аналогично при расширении DAO
                    //dao.ad = new AdDAO();
                    //...
                }
            }
        }
        return dao;
    }
}
