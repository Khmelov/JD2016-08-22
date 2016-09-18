package by.it.shkantau.jd01_09.util.parser;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Aliaksei on 11.09.2016.
 */

public class Parser {

    public static final String DOUBLE_REGEX ="(\\-?\\d+(\\.\\d{0,})?)";
    public static final String VETOR_REGEX ="\\{((-?([0-9.])+),?)+}";
    public static final String MATRIX_REGEX ="\\{((\\{((-?([0-9.])+),?)+}),?)+}";
    public static final String ANY_OPERAND = "("+DOUBLE_REGEX+")|("+VETOR_REGEX+")|("+MATRIX_REGEX+")";
    public static final String OPERATOR = "[-+*/]";
    public static final String FULL_EXPRESSION = "("+ANY_OPERAND+")"+ "(" +OPERATOR+")"+ "(" +ANY_OPERAND +")";


    private static Scanner scanner = new Scanner(System.in);

    public static String getLine() {
        System.out.println("Type the expression: ");
        return scanner.nextLine();
    }

    public static boolean checkStringPattern(String patternStr, String str){
        Pattern p = Pattern.compile(patternStr);
        Matcher m = p.matcher(str);
        return m.matches();
    }


}
