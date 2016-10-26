package by.it.aborisenok.JD03_03.custom_dao;



public class DAO {

    private static DAO dao; //синглтон для DAO

    public UserDAO user;    //DAO для пользователей
    public RoleDAO role;
    public VisitDateDAO visitDate;
    public DoctorDAO doctor;
    public PoliclinicDAO policlinic;
    public TalonDAO talon;

    public static DAO getDAO() {   //метод, который создает DAO или возвращает существующий экземпляр
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.user = new UserDAO();
                    dao.role = new RoleDAO();
                    dao.visitDate = new VisitDateDAO();
                    dao.doctor = new DoctorDAO();
                    dao.policlinic = new PoliclinicDAO();
                    dao.talon = new TalonDAO();
                }
            }
        }
        return dao;
    }
}
