package by.it.voronovich.JD02_03.Programme_Version.Util;

        import by.it.voronovich.JD02_03.Programme_Version.Client;

        import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Данный класс добавляет в синхронизированную очередь клиентов
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */
public class Queue {

    public static ConcurrentLinkedDeque<Client> queue = new ConcurrentLinkedDeque<Client>() {
        @Override
        public void addLast(Client client) {
            super.addLast(client);
        }
    };
}
