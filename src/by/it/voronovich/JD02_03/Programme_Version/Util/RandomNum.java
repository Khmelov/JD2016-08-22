package by.it.voronovich.JD02_03.Programme_Version.Util;

public class RandomNum {

    public static int Random(int from, int to) {
        int random = from + (int) Math.round(Math.random() * (to - from));
        return random;
    }
}
