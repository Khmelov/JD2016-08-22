package by.it.shkantau.project.java.beans;

import java.sql.Timestamp;

public class Flight {
    private int id = 0;
    private String flightCode;
    private String company;
    private Timestamp departure_time;
    private Timestamp arrival_time;
    private int plane=0;
    private int to=0;
    private int from=0;
    private int crew=0;
    private int user=0;

    public Flight() {
    }

    public Flight(int id, String flightCode, String company, Timestamp departure_time, Timestamp arrival_time, int plane, int to, int from, int crew, int user) {
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

    public int getPlane() {
        return plane;
    }

    public void setPlane(int plane) {
        this.plane = plane;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightCode='" + flightCode + '\'' +
                ", company='" + company + '\'' +
                ", departure_time=" + departure_time +
                ", arrival_time=" + arrival_time +
                ", plane=" + plane +
                ", to=" + to +
                ", from=" + from +
                ", crew=" + crew +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;

        Flight flight = (Flight) o;

        if (id != flight.id) return false;
        if (plane != flight.plane) return false;
        if (to != flight.to) return false;
        if (from != flight.from) return false;
        if (crew != flight.crew) return false;
        if (user != flight.user) return false;
        if (!flightCode.equals(flight.flightCode)) return false;
        if (company != null ? !company.equals(flight.company) : flight.company != null) return false;
        if (departure_time != null ? !departure_time.equals(flight.departure_time) : flight.departure_time != null)
            return false;
        return arrival_time != null ? arrival_time.equals(flight.arrival_time) : flight.arrival_time == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + flightCode.hashCode();
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (departure_time != null ? departure_time.hashCode() : 0);
        result = 31 * result + (arrival_time != null ? arrival_time.hashCode() : 0);
        result = 31 * result + plane;
        result = 31 * result + to;
        result = 31 * result + from;
        result = 31 * result + crew;
        result = 31 * result + user;
        return result;
    }
}
