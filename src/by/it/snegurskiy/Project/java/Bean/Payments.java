package by.it.snegurskiy.Project.java.Bean;



import java.sql.Timestamp;
import java.util.Calendar;

public class Payments {

    private int ID;
    private Timestamp Data;
    private String Type;
    private int Amount;
    private int Source;
    private int FK_account;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Timestamp getData() {
        return Data;
    }

    public void setData(Timestamp data) {
        Calendar calendar = Calendar.getInstance();
        Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
        Data = timestamp;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public int getSource() {
        return Source;
    }

    public void setSource(int source) {
        Source = source;
    }

    public int getFK_account() {
        return FK_account;
    }

    public void setFK_account(int FK_account) {
        this.FK_account = FK_account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;

        Payments payment = (Payments) o;

        if (FK_account != payment.FK_account) return false;
        if (ID != payment.ID) return false;
        if (Data != payment.Data) return false;
        if (!Type.equals(payment.Type)) return false;
        if (Amount != payment.Amount) return false;
        if (Source != payment.Source) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ID;
//        result = 31 * result + (int)Data;
        result = 31 * result + Type.hashCode();
        result = 31 * result + Amount;
        result = 31 * result + Source;
        result = 31 * result + FK_account;
        return result;
    }

    public Payments() {
    }

    public Payments(int ID, Timestamp data, String type, int amount, int source, int FK_account) {
        this.ID = ID;
        Data = data;
        Type = type;
        Amount = amount;
        Source = source;
        this.FK_account = FK_account;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "ID=" + ID +
                ", Data='" + Data + '\'' +
                ", Type='" + Type + '\'' +
                ", Amount=" + Amount +
                ", Source=" + Source +
                ", FK_account=" + FK_account +
                "}\n";
    }
}
