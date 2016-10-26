package by.it.grechishnikov.jd03_03.dao;

public class DAO {
    private static DAO dao;

    private GoodsDAO goodsDAO;
    private OrdersDAO ordersDAO;
    private RolesDAO rolesDAO;
    private UsersDAO usersDAO;

    private DAO() {
    }

    public static DAO getInstance() {
        if(dao == null) {
            dao = new DAO();
            dao.goodsDAO = new GoodsDAO();
            dao.ordersDAO = new OrdersDAO();
            dao.rolesDAO = new RolesDAO();
            dao.usersDAO = new UsersDAO();
        }
        return dao;
    }

    public GoodsDAO getGoodsDAO() {
        return goodsDAO;
    }

    public OrdersDAO getOrdersDAO() {
        return ordersDAO;
    }

    public RolesDAO getRolesDAO() {
        return rolesDAO;
    }

    public UsersDAO getUsersDAO() {
        return usersDAO;
    }
}
