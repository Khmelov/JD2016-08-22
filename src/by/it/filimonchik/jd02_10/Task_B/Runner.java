package by.it.filimonchik.jd02_10.Task_B;

/**
 * Created by Raman.Filimonchyk on 28/10/2016.
 */
public class Runner {
    public static void main(String[] args) {
        System.out.println("Task B." + "\n" + "Из XML в JSON: " + "\n");
        XMLtoJSON.XMLJSON();
        System.out.println("\n" + "Из JSON в XML: " + "\n");
        JSONtoXML.JSONXML();
    }
}
