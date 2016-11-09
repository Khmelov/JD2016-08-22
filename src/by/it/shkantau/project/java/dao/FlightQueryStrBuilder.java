package by.it.shkantau.project.java.dao;

public class FlightQueryStrBuilder {
    private static final String startOfTheQuery="WHERE ";
    private StringBuilder query = new StringBuilder();

    public FlightQueryStrBuilder() {
        this.query = new StringBuilder();
    }

    public String getQuery() {
        query.insert(0,startOfTheQuery);
        return query.toString();
    }

    public void setQuery(String query) {
        this.query = new StringBuilder(query);
    }

    public void appendIntParam(String param, String operator , String str){
        if (str != null && !str.isEmpty()) {
            if (!query.toString().isEmpty()) {
                query.append(" AND ");
            }
            query.append(param).append(operator).append(str);
        }
    }

    public void appendStrParam(String param, String operator , String str){
        if (str != null && !str.isEmpty()) {
            if (!query.toString().isEmpty()) {
                query.append(" AND ");
            }
            query.append(param).append(operator).append("'").append(str).append("'");
        }
    }
}
