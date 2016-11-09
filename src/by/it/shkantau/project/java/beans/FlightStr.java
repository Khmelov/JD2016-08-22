package by.it.shkantau.project.java.beans;

import java.sql.Timestamp;

public class FlightStr {
    private int id = 0;
    private int viewNumber;
    private String flightCode;
    private String company;
    private Timestamp departure_time;
    private Timestamp arrival_time;
    private String plane;
    private String to;
    private String from;
    private String crew;
    private String user;

    public FlightStr() {
    }

    public FlightStr(int id, String flightCode, String company, Timestamp departure_time, Timestamp arrival_time, String plane, String to, String from, String crew, String user) {
        this.id = id;
        this.flightCode = flightCode;
        this.company = company;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.plane = plane;
        this.to = to;
        this.from = from;
        this.crew = crew;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getViewNumber() {
        return viewNumber;
    }

    public void setViewNumber(int viewNumber) {
        this.viewNumber = viewNumber;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Timestamp getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(Timestamp departure_time) {
        this.departure_time = departure_time;
    }

    public Timestamp getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Timestamp arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "FlightStr{" +
                "id=" + id +
                ", flightCode='" + flightCode + '\'' +
                ", company='" + company + '\'' +
                ", departure_time=" + departure_time +
                ", arrival_time=" + arrival_time +
                ", plane='" + plane + '\'' +
                ", to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", crew='" + crew + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
