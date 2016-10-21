package by.it.snegurskiy.jd01.jd01_01;

public class HelloWorld {

    public static void main(String[] argsMain) {


        Slogan s1= new Slogan();
        s1.printSlogan();
        s1.setSlogan("привет мир");
        s1.printSlogan();// write your code here
        s1.setSlogan("пока мир");
        s1.printSlogan();
        s1.setSlogan("Hi world");

        PrintArgs printArgs = new PrintArgs(argsMain);
        printArgs.printAllArgs();

    }
}
