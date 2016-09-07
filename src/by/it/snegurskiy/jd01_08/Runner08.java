package by.it.snegurskiy.jd01_08;

import by.it.snegurskiy.jd01_02.C;

/**
 * Created by snegurskiy.nn on 08.09.2016.
 */
public class Runner08 {
    public static void main(String[ ] args) {
        Comedy Comedy=new Comedy();
        System.out.println(Comedy.showState());
        Comedy.play();  // нажали воспроизведение
        System.out.println(Comedy.showState());
        Comedy.pause(); //поставили на паузу
        System.out.println(Comedy.showState());
        Comedy.pause(); //сняли с паузы
        System.out.println(Comedy.showState());
        Comedy.stop();  //остановили
        System.out.println(Comedy.showState());
    }
}
