package by.it.grechishnikov.jd02_08;


public class Parsing {
    private static String path = "src/by/it/grechishnikov/jd02_07/Store+xsd.xml";

    public static void main(String[] args) {
        System.out.println("Задание А");
        SAX.run(path);
        System.out.println("Задание В");
        StAX.run(path);
        System.out.println("Задание С");
        DOM.run(path);
    }
}
