package by.it.snegurskiy.jd02_09;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)     // FIELD - все поля в XML
@XmlType(name = "User", propOrder = {  // PROPERTY - только  с геттерами и сеттерами
        "surname",                           // PUBLIC_MEMBER - только public
        "name",                       // NONE - ни одно
        "login",
        "password",
        "account"
})
public class User {
    @XmlAttribute(required = true) //опишем логин как аттрибут
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class) //тип адаптера
    @XmlID //и ключевой (уникальный)
    private String surname;
    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private String login;
    @XmlElement(required = true)
    private String password;
    @XmlElement(required = true)
    private Account account = new Account();

    public User (){}

    public User(String surname, String name, String login, String password, Account account) {
        this.surname = surname;
        this.name = name;
        this.login = login;
        this.password = password;
        this.account=account;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String toString() {
        return "\nSurname: " + surname + "\nName: " + name + "\nLogin: " + login
                + "\nPassword: " + password   + "\nAccount: " + account + account.toString();
    }

    @XmlRootElement
    @XmlType(name = " account ", propOrder = {
            "balance"
    })
    public static class Account {
        private int balance;

        public Account() {}
        public Account(int balance) {
            this.balance = balance;
        }
        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public String toString() {
            return "\nAccount:" + "\n\tBalance: " + balance + "\n";
        }
    }
}
