package by.it.snegurskiy.jd03_01.classwork.sql.classwork;

/**
 * Created by Acer on 19.10.2016.
 */
public class Account {


    private int ID;
    private int Balance;
    private int Status;
    private int FK_users;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public int getFK_users() {
        return FK_users;
    }

    public void setFK_users(int FK_users) {
        this.FK_users = FK_users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        if (FK_users != account.FK_users) return false;
        if (ID != account.ID) return false;
        if (Balance != account.Balance) return false;
        if (Status != account.Status) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + Balance;
        result = 31 * result + Status;
        result = 31 * result + FK_users;
        return result;
    }

    public Account() {
    }

    public Account(int ID, int balance, int status, int FK_users) {
        this.ID = ID;
        Balance = balance;
        Status = status;
        this.FK_users = FK_users;
    }

    @Override
    public String toString() {
        return "Account{" +
                "ID=" + ID +
                ", balance='" + Balance + '\'' +
                ", status='" + Status + '\'' +
                ", FK_users=" + FK_users +
                "}\n";
    }
}
