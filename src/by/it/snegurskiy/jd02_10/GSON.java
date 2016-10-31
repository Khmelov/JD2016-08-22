package by.it.snegurskiy.jd02_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GSON {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

        User user = new User();
        user.setSurname("Ivanov");
        user.setName("Ivan");
        user.setLogin("Ivan9");

        String json = gson.toJson(user);
        System.out.println("Маршализация:\n" + json);

        User result = gson.fromJson(json, User.class);
        System.out.println("Демаршализация:\n" + result);
    }
}
