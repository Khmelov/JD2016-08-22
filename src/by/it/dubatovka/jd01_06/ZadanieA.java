package by.it.dubatovka.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 12.09.2016.
 */
public class ZadanieA {
    public static void main(String[] args) {
        StringBuilder data=new StringBuilder(RuslanLudmila.dubzelenij);
        Pattern p =Pattern.compile("[а-яА-ЯёЁ]{5,}");
        Matcher m =p.matcher(data);


    }
}
