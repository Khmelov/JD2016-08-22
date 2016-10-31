package by.it.dubatovka.jd03_03.dao;


public class DAO {
    private static DAO dao;

    public UserDAO user;
    public RoleDAO role;
    public StatusDAO status;
    public ObjectsDAO objects;
    public AdDAO ad;
    public PriorityDAO priority;

    public static DAO getDAO() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.user = new UserDAO();
                    dao.role = new RoleDAO();
                    dao.status = new StatusDAO();
                    dao.priority = new PriorityDAO();
                    dao.ad = new AdDAO();
                    dao.objects = new ObjectsDAO();
                }
            }
        }
        return dao;
    }
}