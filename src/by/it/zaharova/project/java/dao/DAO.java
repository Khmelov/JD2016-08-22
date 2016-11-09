package by.it.zaharova.project.java.dao;

public class DAO {

    private static DAO dao;

    public PatientsDAO patients;
    public DoctorsDAO doctors;
    public DiagnosticDAO diagnostic;
    public StatusDAO status;


    public static DAO getDAO() {   //метод, который создает DAO или возвращает существующий экземпляр
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.patients = new PatientsDAO();
                    dao.doctors = new DoctorsDAO();
                    dao.diagnostic = new DiagnosticDAO();
                    dao.status = new StatusDAO();

                }
            }
        }
        return dao;
    }
}
