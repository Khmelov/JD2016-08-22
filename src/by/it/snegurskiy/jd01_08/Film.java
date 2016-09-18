package by.it.snegurskiy.jd01_08;

/**
 * Created by user on 07.09.2016.
 */
public interface Film {

    boolean play (); //воспроизведение фильма
    boolean stop(); // выключить фильм
    void pause();   // поставить фильм на паузу
    int soundUp (); //сделать громче
    void soundDown (); //сделать тише
    boolean soundOn(); // включить звук
    boolean soundOff(); //выключить звук

}
