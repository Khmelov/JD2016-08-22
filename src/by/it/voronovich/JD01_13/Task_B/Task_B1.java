package by.it.voronovich.JD01_13.Task_B;

/**
 * Класс демонстрирует проталкивание исключений на верх
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */

public class Task_B1 {

    protected static void firstMethod() throws Exception {
        System.out.println("Начало первого метода");
        secondMethod();
        if(1000/5>0){
            throw new Exception("Ошибка пришла из первого метода");
        } else {
            try{
                double x = Math.random()/0;
            } catch (ArithmeticException e){
                System.out.println("Обработка ошибки первого метода");
            }
        }
        System.out.println("Конец первого метода");
    }

    protected static void secondMethod() throws Exception {
        System.out.println("Начало второго метода");
        thirdMethod();
        if(1000/5>0){
            throw new Exception("Ошибка пришла из второго метода");
        } else {
            try{
                double x = Math.random()/0;
            } catch (ArithmeticException e){
                System.out.println("Обработка ошибки второго метода");
            }
        }
        System.out.println("Конец второго метода");
    }

    protected static void thirdMethod() throws Exception {
        System.out.println("Начало третьего метода");
        if(1000/5>0){
            throw new Exception("Ошибка пришла из третьего метода");
        } else {
            try{
                double x = Math.random()/0;
            } catch (ArithmeticException e){
                System.out.println("Обработка ошибки третьего метода");
            }
        }
        System.out.println("Конец третьего метода");
    }
}
