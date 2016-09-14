package by.it.akhmelev.jd01_11.Generics;

public class MyOperationClasses {

    private static class MyOperation<T1,T2 extends Number> {
        private T1 var1;
        private T2 var2;
        //методы .....
    }

    public static <T,R> R calc(T t){
        R r=null;
        return r;
    }
    public static void main(String[] args) {
        //использование параметризированного класса
        MyOperation<Integer,Short> myOperation=new MyOperation<Integer, Short>();
        MyOperation<Float,Long>    myOperation2= new MyOperation<Float, Long>();

        //в версия Java 7 и выше есть оператор daemond <>. И можно даже так:
        MyOperation<Double,Long>   myOperation3= new MyOperation<>();

        if (myOperation instanceof MyOperation){ //ok
            //а так будет ошибка. Невозможно компилировать
            //myOperation<Integer,Short> instanceof myOperation <Integer,Short>
        }

    }

}


