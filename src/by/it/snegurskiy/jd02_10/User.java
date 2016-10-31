package by.it.snegurskiy.jd02_10;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


    @XmlRootElement
    @XmlType(name = "User")
    public class User {
        String Surname;
        String Name;
        String Login;

        public User() {}


        public String getSurname() {
            return Surname;
        }

        public void setSurname(String surname) {
            this.Surname = surname;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            this.Name = name;
        }

        public String getLogin() {
        return Login;
    }

        public void setLogin(String login) {
        this.Login = login;
    }

        @Override
        public String toString() {
            return Surname + " " + Name + ", " + Login;
        }
    }


