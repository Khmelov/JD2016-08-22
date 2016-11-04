package by.it.shkantau.project.java;

public interface Patterns {
    String LOGIN="[a-zA-Z0-9-_.:]+";
    String COMPANY="[a-Z0-9 ]+";
    String PASSWORD=".+";
    String EMAIL="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    String INT="[0-9]+";
    String FLIGTH_CODE="[A-Z]{2}[0-9]{3}";
}
