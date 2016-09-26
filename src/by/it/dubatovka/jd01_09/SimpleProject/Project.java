package by.it.dubatovka.jd01_09.SimpleProject;

/**
 * Created by Dubatovka Sergey on 23.09.2016.
 */
public class Project {
    public static void main(String[] args) {
        Variable one = new Variable("2.2");
        Variable two = new Variable("3.3");

        Variable res= one.add(two);
        System.out.println(one + "+"+ two+"="+res);

    }

}
