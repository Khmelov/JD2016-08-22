package by.it.akhmelev.jd01_09.inner;

public class Main {
    public static void main(String[ ] args) {
        // вызов статического метода
        ParentClass.SubClass sc=new ParentClass().new SubClass();
        sc.launch();
    }
}


