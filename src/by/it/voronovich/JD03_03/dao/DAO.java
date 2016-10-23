package by.it.voronovich.JD03_03.dao;

public class DAO {

    private static DAO dao;

    private RoleDAO roleDAO;
    private UserDAO userDAO;
    private CatalogGoodDAO cgDAO;
    private OrderDAO orderDAO;

    private DAO() {
    }

    public static DAO getDAO() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.roleDAO = new RoleDAO();
                    dao.userDAO = new UserDAO();
                    dao.cgDAO = new CatalogGoodDAO();
                    dao.orderDAO = new OrderDAO();
                }
            }
        }
        return dao;
    }

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public CatalogGoodDAO getCgDAO() {
        return cgDAO;
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }
}
