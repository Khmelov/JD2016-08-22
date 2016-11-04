package by.it.shkantau.project.java.connection;

 class ConnectionSettingsPOJO {
    private String URL_DB;
    private String USER_DB;
    private String PASSWORD_DB;


    public ConnectionSettingsPOJO() {
    }

    public ConnectionSettingsPOJO(String URL_DB, String USER_DB, String PASSWORD_DB) {
        this.URL_DB = URL_DB;
        this.USER_DB = USER_DB;
        this.PASSWORD_DB = PASSWORD_DB;
    }

    public String getURL_DB() {
        return URL_DB;
    }

    public void setURL_DB(String URL_DB) {
        this.URL_DB = URL_DB;
    }

    public String getUSER_DB() {
        return USER_DB;
    }

    public void setUSER_DB(String USER_DB) {
        this.USER_DB = USER_DB;
    }

    public String getPASSWORD_DB() {
        return PASSWORD_DB;
    }

    public void setPASSWORD_DB(String PASSWORD_DB) {
        this.PASSWORD_DB = PASSWORD_DB;
    }

    @Override
    public String toString() {
        return "ConnectionSettingsPOJO{" +
                "URL_DB='" + URL_DB + '\'' +
                ", USER_DB='" + USER_DB + '\'' +
                ", PASSWORD_DB='" + PASSWORD_DB + '\'' +
                '}';
    }

}
