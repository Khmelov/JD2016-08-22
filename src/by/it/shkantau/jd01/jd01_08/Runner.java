package by.it.shkantau.jd01.jd01_08;

import java.util.Arrays;

public class Runner {
    public static void main (String [] args){

        VideoPlayer vp1 = new VideoPlayer("Sony walkman", 0.2, "Portable videoplayer", 5 , 0.3,
                Arrays.asList("mp3", "ogg", "m4u", "wma", "mp4"),
                Arrays.asList("internalFlash", "USB"));
        VideoPlayer vp2 = new VideoPlayer("Philips", 1.3, "DVD player", 220, 5.4);

        VideoPlayer vp3 = new VideoPlayer("Samsung BD-E5300", 1.3, "Blue-ray player", 220, 5.4,
                Arrays.asList("mp3", "ogg", "m4u", "wma", "mp4", "blue-ray"),
                Arrays.asList("Wi-Fi", "DiskDrive", "internalFlash", "USB"));
        System.out.println(vp1);
        vp1.play();
        vp1.play("USB");
        System.out.println(vp2);
        System.out.println(vp3);
    }
}
