package by.it.snegurskiy.jd03.classwork;

/**
 * Created by Acer on 21.10.2016.
 */
public class Payments {

    private int ID;
    private int Data;
    private String Type;
    private double Sum;
    private int Source;
    private int FK_account;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getData() {
        return Data;
    }

    public void setData(int data) {
        Data = data;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public double getSum() {
        return Sum;
    }

    public void setSum(double sum) {
        Sum = sum;
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
        if (!Type.equals(payment.Data)) return false;
        if (Sum != payment.Sum) return false;
        if (Source != payment.Source) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + Data;
        result = 31 * result + Type.hashCode();
        result = 31 * result + (int)Sum;
        result = 31 * result + Source;
        result = 31 * result + FK_account;
        return result;
    }

    public Payments() {
    }

    public Payments(int ID, int data, String type, double sum, int source, int FK_account) {
        this.ID = ID;
        Data = data;
        Type = type;
        Sum = sum;
        Source = source;
        this.FK_account = FK_account;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "ID=" + ID +
                ", Data='" + Data + '\'' +
                ", Type='" + Type + '\'' +
                ", Sum='" + Sum + '\'' +
                ", Source='" + Source + '\'' +
                ", FK_account=" + FK_account +
                "}\n";
    }
}
