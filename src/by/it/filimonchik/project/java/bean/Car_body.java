package by.it.filimonchik.project.java.bean;

/**
 * Created by Raman.Filimonchyk on 07/11/2016.
 */
public class Car_body {
        private int ID;
        private String Car_body;

        public Car_body() {}

        public Car_body(int ID, String Car_body) {
            this.ID = ID;
            this.Car_body = Car_body;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getCar_body() {
            return Car_body;
        }

        public void setCar_body(String Car_body) {
            this.Car_body = Car_body;
        }

        @Override
        public String toString() {
            return "Car_body{" +
                    "ID=" + ID +
                    ", Car_body='" + Car_body + '\'' +
                    '}';
        }


    }
