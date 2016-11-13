package by.it.kisel.JD02_10.Task1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GSONDemo {
    public static void main(String[] args) {
        Gson GSON = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

        Test test = new Test("Петров", new Double[]{4.0, 6.0, 5.0, 9.0, 7.0});

        String JSON = GSON.toJson(test);
        System.out.println(JSON);

        Test test1 = GSON.fromJson(JSON, Test.class);
        System.out.println("\n\n" + test1.toString());
    }
}
