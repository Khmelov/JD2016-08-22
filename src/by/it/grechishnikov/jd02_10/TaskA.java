package by.it.grechishnikov.jd02_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TaskA {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

        Person person = new Person();
        person.setFirstName("Evgeniy");
        person.setLastName("Grechishnikov");
        person.setAge(23);

        String json = gson.toJson(person);
        System.out.println("Маршализация:\n" + json);

        Person result = gson.fromJson(json, Person.class);
        System.out.println("Демаршализация:\n" + result);
    }
}
