package by.it.shkantau.jd01.jd01_13;

public class TaskB {

// Разработать консольное приложение, в котором поместить 3 void  процедуры, вложенные друг в друга.
//    § Каждую процедуру сопроводить двумя сообщениями: в начале и в конце тела процедуры.    Код процедуры – произвольный, но с возможным делением на ноль.
//    § Проследить обработку исключений, обязательно защитить вызов каждой процедуры во внешнем вызывающем блоке.
//    § Один тип ошибки – деление на ноль обрабатывать в процедуре, остальные ошибки пробрасывать и обрабатывать в main.

     static void run(){
        try {
            void3();
        } catch (Exception e) {
            System.out.println("There are some errors: "+e.toString());
        }
    }

    private static   void void3 () throws Exception{
        System.out.println("Procedure void3 begin");

        try {
            int v1 = 1/(int)(3 * Math.random());
        } catch (ArithmeticException e) {
            System.out.println("Division by zero is ocured in procedure void3");
        }
        void2();
        System.out.println("Procedure void3 finish");
    }

    private static void void2 () throws Exception{
        System.out.println("Procedure void2 begin");
        try {
            int v2 = 1/(int)(3 * Math.random());
            if (v2 == 1){
                throw new CustomException("This is sample exception");
            }
        } catch (ArithmeticException e) {
            System.out.println("Division by zero is occured in procedure void2");
//            return;
        }

        void1();
        System.out.println("Procedure void2 finish");
    }

    private static void void1 () throws Exception{
        System.out.println("Procedure void1 begin");
        try {
            int v3 = 1/(int)(3 * Math.random());
        } catch (ArithmeticException e) {
            System.out.println("Division by zero is ocured in procedure void1");
        }
        System.out.println("Procedure void1 finish");
    }


    private static class CustomException extends Exception{
         CustomException(String message) {
            super(message);
        }
    }

}
