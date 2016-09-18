package by.it.snegurskiy.jd01_08;

/**
 * Created by snegurskiy.nn on 08.09.2016.
 */
public class Runner08 {
    public static void main(String[ ] args) {
        Comedy Comedy=new Comedy();
        System.out.println(Comedy.showState());
        Comedy.play();  // нажали воспроизведение
        Comedy.soundUp(); // сделали громче на 10
        System.out.println(Comedy.showState());
        Comedy.soundOn(); //включили звук
        Comedy.soundUp();// сделали громче на 10
        System.out.println(Comedy.showState());
        Comedy.pause(); //поставили на паузу
        Comedy.soundDown();// сделали тише на 10
        System.out.println(Comedy.showState());
        Comedy.pause(); //сняли с паузы
        Comedy.soundOff(); // выключили звук
        System.out.println(Comedy.showState());
        Comedy.soundOn();// звук включили
        Comedy.stop();  //остановили
        System.out.println(Comedy.showState());
        Fantomas fantomas =new Fantomas();//создать комедию Фантомас
        fantomas.soundOn(); //включить звук в Фантомасе
        fantomas.soundUp();// динамический полиморфизм, увеличить звук в Фантомасе +30 вместо обычного +10
        fantomas.play();
        System.out.println(fantomas.showState());
    }
}
