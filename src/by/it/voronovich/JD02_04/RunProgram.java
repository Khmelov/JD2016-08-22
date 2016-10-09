package by.it.voronovich.JD02_04;

import by.it.voronovich.JD02_04.Util.PoolInfo;
import by.it.voronovich.JD02_04.Operation.Calculator;

import java.io.IOException;

import static by.it.voronovich.JD02_04.Util.PoolInfo.inspection;

/**
 * Класс запускает программу MathLab
 *
 * @author Voronovich Dmitrry
 * @version 1.1
 */
public class RunProgram {

    public static void main(String[] args) throws UnsupportedException, IOException {

        System.out.println("Math.Lab v.1.0.0...(created by D. Voronovich)..."+"\n");
        System.out.println("Make input using space:");

        PoolInfo poolInfo = new PoolInfo();
        String str;
        boolean input;
        do {
            str = inspection();
            try {
                poolInfo.out(new Calculator().calculator(str));
            } catch (UnsupportedException e) {
                System.err.println(e.getMessage());
            }
            input = PoolInfo.checkInput(str);
        }
        while (input);
        System.out.println("Calculating has been finished..." +"\n" + "For using program run it once again.");
    }
}