package by.it.grechishnikov.jd02_09.taskB;


import by.it.grechishnikov.jd02_09.taskB.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    private static String path = "src/by/it/grechishnikov/jd02_07/Store.xml";

    public static void main(String[] args) throws Exception {
        Store store = new Store();

        Admin admin = new Admin();
        admin.setNickname("admin");
        admin.setPassword("admin");
        admin.setEmail("admin@mail.ru");

        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setNickname("Вася");
        user1.setPassword("123");
        user1.getOrder().add(admin.getCatalog().getGoods().get(0));
        users.add(user1);

        User user2 = new User();
        user2.setNickname("Вася");
        user2.setPassword("123");
        user2.getOrder().add(admin.getCatalog().getGoods().get(1));
        user2.getOrder().add(admin.getCatalog().getGoods().get(0));

        users.add(user2);

        store.setAdmin(admin);
        store.setUser(users);

        JAXBContext context = JAXBContext.newInstance(Store.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(store, System.out);
    }
}
