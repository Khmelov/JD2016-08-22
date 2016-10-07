package by.it.akhmelev.jd02_06.p10_strategy;

public interface AuthStrategy {
    boolean checkLogin(String name, String password);
}
