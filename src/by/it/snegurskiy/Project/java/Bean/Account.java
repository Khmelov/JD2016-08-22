package by.it.snegurskiy.Project.java.Bean;

public class Account {


    private int ID;
    private int Balance;
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


        return true;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + Balance;

        result = 31 * result + FK_users;

        return result;
    }

    public Account() {
    }

    public Account(int ID, int balance, int status, int FK_users, int FK_roleaccount) {
        this.ID = ID;
        Balance = balance;

        this.FK_users = FK_users;

    }

    @Override
    public String toString() {
        return "Account(" +
                "ID=" + ID +
                ", balance=" + Balance +

                ", FK_users=" + FK_users +

                ")\n";
    }


}
