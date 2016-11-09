package by.it.zaharova.JD03_03.custom_dao;


public class DAO {

    private static DAO dao; //синглтон для DAO

    public PatientsDAO patients;    //DAO для пациентов
    public DoctorsDAO doctors;    //DAO для врачей
    public DiagnosticDAO diagnostic;        //DAO для диагноза
    public StatusDAO status;        //DAO для статуса    //...

    public static DAO getDAO() {   //метод, который создает DAO или возвращает существующий экземпляр
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.patients = new PatientsDAO();
                    dao.doctors = new DoctorsDAO();
                    dao.diagnostic = new DiagnosticDAO();
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
