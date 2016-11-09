package by.it.kisel.JD03_02.crud;

public class Orders {
    private int ID;
    private int ArrivalDate;
    private int DepartureDate;
    private int TotalPrice;
    private int FK_rooms;
    private int FK_persons;

    public Orders() {
    }

    public Orders(int ID, int arrivalDate, int departureDate, int totalPrice, int FK_rooms, int FK_persons) {
        this.ID = ID;
        ArrivalDate = arrivalDate;
        DepartureDate = departureDate;
        TotalPrice = totalPrice;
        this.FK_rooms = FK_rooms;
        this.FK_persons = FK_persons;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getArrivalDate() {
        return ArrivalDate;
    }

    public void setArrivalDate(int arrivalDate) {
        ArrivalDate = arrivalDate;
    }

    public int getDepartureDate() {
        return DepartureDate;
    }

    public void setDepartureDate(int departureDate) {
        DepartureDate = departureDate;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        TotalPrice = totalPrice;
    }

    public int getFK_rooms() {
        return FK_rooms;
    }

    public void setFK_rooms(int FK_rooms) {
        this.FK_rooms = FK_rooms;
    }

    public int getFK_persons() {
        return FK_persons;
    }

    public void setFK_persons(int FK_persons) {
        this.FK_persons = FK_persons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (ID != orders.ID) return false;
        if (ArrivalDate != orders.ArrivalDate) return false;
        if (DepartureDate != orders.DepartureDate) return false;
        if (TotalPrice != orders.TotalPrice) return false;
        if (FK_rooms != orders.FK_rooms) return false;
        return FK_persons == orders.FK_persons;

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + ArrivalDate;
        result = 31 * result + DepartureDate;
        result = 31 * result + TotalPrice;
        result = 31 * result + FK_rooms;
        result = 31 * result + FK_persons;
        return result;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "ID=" + ID +
                ", ArrivalDate=" + ArrivalDate +
                ", DepartureDate=" + DepartureDate +
                ", TotalPrice=" + TotalPrice +
                ", FK_rooms=" + FK_rooms +
                ", FK_persons=" + FK_persons +
                '}';
    }
}
