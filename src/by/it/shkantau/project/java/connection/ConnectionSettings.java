package by.it.shkantau.project.java.connection;


public class ConnectionSettings {

    private String URL_DB;
    private String USER_DB;
    private String PASSWORD_DB;
    private static ConnectionSettings connectionSettings;


    public static ConnectionSettings getCS(String Url_DB, String User_DB, String PASS_DB){
        if (connectionSettings == null){
            connectionSettings = new ConnectionSettings(Url_DB, User_DB, PASS_DB);
        }
        return connectionSettings;
    }

    private ConnectionSettings(String URL_DB, String USER_DB, String PASSWORD_DB) {
        this.URL_DB = URL_DB;
        this.USER_DB = USER_DB;
        this.PASSWORD_DB = PASSWORD_DB;
    }

    public String getURL_DB() {
        return URL_DB;
    }

    public String getUSER_DB() {
        return USER_DB;
    }

    public String getPASSWORD_DB() {
        return PASSWORD_DB;
    }

    @Override
    public String toString() {
        return "ConnectionSettings{" +
                "URL_DB='" + URL_DB + '\'' +
                ", USER_DB='" + USER_DB + '\'' +
                ", PASSWORD_DB='" + PASSWORD_DB + '\'' +
                '}';
    }
}
