package by.it.akhmelev.jd01_11.Generics;

import java.util.Objects;

class GenericMethod {

    static class GenMeth extends GenericMethod{
        public <T1 extends GenericMethod> GenMeth(T1 course) { // конструктор
            System.out.println(course.getClass()); // реализация
        }
        public <T2> GenMeth() { // конструктор
            // реализация
        }
        public <T3 extends GenericMethod> float calculateMark(T3 arg) {
            System.out.println(arg.getClass()); // реализация
            return 1f;
        }
        public <T4> void printReport(T4 arg) {
            System.out.println(arg.getClass()); // реализация
        }
        public <T5> boolean check(T5 b) {
            System.out.println(b.getClass()); // реализация
            return false;
        }
    }

    public static void main(String[] args) {
        GenMeth genMeth1=new GenMeth(new GenericMethod());  //T1 - GenericMethod
        GenMeth genMeth2=new <Boolean>GenMeth();            //T2 - Boolean, но использовать его сложно
        genMeth1.calculateMark(genMeth2);                   //T3 - вложенный $GenMeth
        genMeth2.printReport(new Object());                 //T4 - Object
        genMeth2.check(1f);                                 //T5 - Float

    }



}
