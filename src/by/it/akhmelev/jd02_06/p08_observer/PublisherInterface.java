package by.it.akhmelev.jd02_06.p08_observer;
import java.util.ArrayList;

interface PublisherInterface {
    ArrayList<PublisherActionListener> getListeners();
    void addListener(PublisherActionListener listener);

    public void removeListener(PublisherActionListener listener);
    public void removeAllListeners();
    public void notifySubscribers(String message);
}
