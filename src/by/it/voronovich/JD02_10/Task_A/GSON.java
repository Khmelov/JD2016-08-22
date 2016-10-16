package by.it.voronovich.JD02_10.Task_A;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class GSON {

    public static void main(String[] args) {
        //маршаллизация и демаршаллизация в/из JSON. Подготовим  обработчики.

        GsonBuilder builder = new GsonBuilder(); //Это строитель
        builder=builder.serializeNulls();        //в нем пишем что сериализуются null
        builder=builder.setPrettyPrinting();     //и вывод будет форматированный
        Gson gson=builder.create();              //теперь строитель строит того же обработчика


        // Создаем объект
        ArrayList<Client> list = new ArrayList<>();
        Client client = new Client("Derek", "Serx");
        list.add(client);
        client = new Client("Stan", "Marshal");
        list.add(client);
        client = new Client("Coni", "Demiko");
        list.add(client);

        Clients clients = new Clients();
        clients.setList(list);

        WebStore webStore = new WebStore();
        webStore.setClients(clients);
        //маршаллизация
        String json = gson.toJson(webStore);
        System.out.println("Маршализация: ");
        System.out.println(json);
        //демаршаллизация
        WebStore web=gson.fromJson(json, WebStore.class);
        System.out.println("Демаршализация: ");
        System.out.print("\n" + web.toString());
    }
}


