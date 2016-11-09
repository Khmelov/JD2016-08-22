package by.it.filimonchik.jd03_03.DAO;

/**
 * Created by Raman.Filimonchyk on 07/11/2016.
 */
public class DAO {

    private static DAO dao;

    public UsersDAO user;
    public RoleDAO role;
    public AdDAO ad;
    public ColorDAO color;
    public ModelDAO model;
    public Car_bodyDAO car_body;

    public static DAO getDAO() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.user = new UsersDAO();
                    dao.role = new RoleDAO();
                    dao.ad = new AdDAO();
                    dao.color=new ColorDAO();
                    dao.model=new ModelDAO();
                    dao.car_body=new Car_bodyDAO();
                }
            }
        }
        return dao;
    }
}
