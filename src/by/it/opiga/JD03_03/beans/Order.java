package by.it.opiga.JD03_03.beans;

/**
 * Created by Asus on 19.10.2016.
 */
public class Order {
    private int ID;
    private String fio;
    private String passport;
    private int phone;
    private String category;
    private long arrive;
    private long leave;
    private String payment;
    private int FK_user;
    private int FK_status;

    public Order() {
    }

    public Order(String fio, String passport, int phone, String category, long arrive, long leave, String payment, int FK_user, int FK_status) {

        this.fio = fio;
        this.passport = passport;
        this.phone = phone;
        this.category = category;
        this.arrive = arrive;
        this.leave = leave;
        this.payment = payment;
        this.FK_user = FK_user;
        this.FK_status = FK_status;
    }
    public Order(int ID, String fio, String passport, int phone, String category, long arrive, long leave, String payment, int FK_user, int FK_status) {
        this.ID=ID;
        this.fio = fio;
        this.passport = passport;
        this.phone = phone;
        this.category = category;
        this.arrive = arrive;
        this.leave = leave;
        this.payment = payment;
        this.FK_user = FK_user;
        this.FK_status = FK_status;
    }
    public int getId() {
        return ID;
    }

    public String getFio() {
        return fio;
    }

    public String getPassport() {
        return passport;
    }

    public int getPhone() {
        return phone;
    }

    public String getCategory() {
        return category;
    }

    public long getArrive() {
        return arrive;
    }

    public long getLeave() {
        return leave;
    }

    public String getPayment() {
        return payment;
    }

    public int getFK_user() {
        return FK_user;
    }

    public int getFK_status() {
        return FK_status;
    }

//    @Override
//    public String toString() {
//        return super.toString();
//    }

    public void setId(int id) {
        this.ID = id;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setArrive(long arrive) {
        this.arrive = arrive;
    }

    public void setLeave(long leave) {
        this.leave = leave;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public void setFK_user(int FK_user) {
        this.FK_user = FK_user;
    }

    public void setFK_status(int FK_status) {
        this.FK_status = FK_status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (ID != order.ID) return false;
        if (phone != order.phone) return false;
        if (arrive != order.arrive) return false;
        if (leave != order.leave) return false;
        if (FK_user != order.FK_user) return false;
        if (FK_status != order.FK_status) return false;
        if (fio != null ? !fio.equals(order.fio) : order.fio != null) return false;
        if (passport != null ? !passport.equals(order.passport) : order.passport != null) return false;
        if (category != null ? !category.equals(order.category) : order.category != null) return false;
        return payment != null ? payment.equals(order.payment) : order.payment == null;

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        result = 31 * result + phone;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (int) (arrive ^ (arrive >>> 32));
        result = 31 * result + (int) (leave ^ (leave >>> 32));
        result = 31 * result + (payment != null ? payment.hashCode() : 0);
        result = 31 * result + FK_user;
        result = 31 * result + FK_status;
        return result;
    }

    @Override
    public String toString() {
        return "order{" +
                "ID=" + ID +
                ", fio='" + fio + '\'' +
                ", passport='" + passport + '\'' +
                ", phone=" + phone +
                ", category='" + category + '\'' +
                ", arrive=" + arrive +
                ", leave=" + leave +
                ", payment='" + payment + '\'' +
                ", FK_user=" + FK_user +
                ", FK_status=" + FK_status +
                '}';
    }
}
