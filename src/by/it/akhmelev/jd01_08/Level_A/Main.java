package by.it.akhmelev.jd01_08.Level_A;

public class Main {
    public static void main(String[ ] args) {
        //создадим видеоплеер, запустим, два раза нажмем на паузу, остановим
        VideoPleer videoPleer=new VideoPleer();
        System.out.println(videoPleer.showState());
        videoPleer.play();  // нажали воспроизведение
        System.out.println(videoPleer.showState());
        videoPleer.pause(); //поставили на паузу
        System.out.println(videoPleer.showState());
        videoPleer.pause(); //сняли с паузы
        System.out.println(videoPleer.showState());
        videoPleer.stop();  //остановили
        System.out.println(videoPleer.showState());
    }
}
