package by.it.voronovich.project.java.dao;

public class DAO {

    private static DAO dao;

    public RoleDAO role;
    public UserDAO user;
    public CatalogGoodDAO cg;
    public OrderDAO order;

    public static DAO getDAO() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.role = new RoleDAO();
                    dao.user = new UserDAO();
                    dao.cg = new CatalogGoodDAO();
                    dao.order = new OrderDAO();
                }
            }
        }
        return dao;
    }
}
