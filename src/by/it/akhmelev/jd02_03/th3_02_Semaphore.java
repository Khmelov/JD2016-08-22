package by.it.akhmelev.jd02_03;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class th3_02_Semaphore {

    private static Semaphore semaphore=new Semaphore(3);

    private static class Run implements Runnable{
        private String name;
        Run(String name) {this.name = name;} //конструктор Run

        @Override
        public void run() {
            System.out.println(name+" создан");
            try {
            semaphore.acquire(); //взяли разрешение у семафора
            System.out.println("--"+name+" стартовал");
            Thread.sleep(1000);  //работа
            System.out.println("-----"+name+" завершился");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                semaphore.release(); //вернули разрешение
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executors= Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executors.execute(new Run("Поток №"+i));
        }
        executors.shutdown();
        System.out.println("Все потоки запущены");
    }


}
