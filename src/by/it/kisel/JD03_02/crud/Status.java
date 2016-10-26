package by.it.kisel.JD03_02.crud;

public class Status {
    private int ID;
    private String OrderStatus;
    private int FK_orders;

    public Status() {
    }

    public Status(int ID, String orderStatus, int FK_orders) {
        this.ID = ID;
        OrderStatus = orderStatus;
        this.FK_orders = FK_orders;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        OrderStatus = orderStatus;
    }

    public int getFK_orders() {
        return FK_orders;
    }

    public void setFK_orders(int FK_orders) {
        this.FK_orders = FK_orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Status status = (Status) o;

        if (ID != status.ID) return false;
        if (FK_orders != status.FK_orders) return false;
        return OrderStatus != null ? OrderStatus.equals(status.OrderStatus) : status.OrderStatus == null;

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (OrderStatus != null ? OrderStatus.hashCode() : 0);
        result = 31 * result + FK_orders;
        return result;
    }
}
