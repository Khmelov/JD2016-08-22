package by.it.akhmelev.jd02_04.matlab_with_parser;

public class Error extends Exception{

    public Error() {
        System.out.println("ERR: unknown");
    }

    public Error(String message) {
        System.out.println("ERR:" + message);
    }

}
