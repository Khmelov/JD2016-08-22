package by.it.shkantau.jd01_08;

import java.util.Arrays;

/**
 * Created by Aliaksei on 13.09.2016.
 */
public class Runner {
    public static void main (String [] args){

        VideoPlayer videoPlayer = new VideoPlayer("Sony walkman", 0.1, "videoplayer", 5 , 0.3,
                Arrays.asList("mp3", "ogg", "m4u", "wma", "mp4"),
                Arrays.asList("internalFlash", "USB"));
        System.out.println(videoPlayer);
    }
}
