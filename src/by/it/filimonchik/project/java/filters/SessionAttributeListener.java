package by.it.filimonchik.project.java.filters;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionAttributeListener implements HttpSessionAttributeListener {
//    public class SessionListenerImpl implements HttpSessionAttributeListener {
        public void attributeRemoved(HttpSessionBindingEvent ev) {
        }

        public void attributeAdded(HttpSessionBindingEvent ev) {
            // обработка события
            System.out.println(String.format("add %s : %s",ev.getName(), ev.getValue()));
        }

        public void attributeReplaced(HttpSessionBindingEvent ev) {
            // обработка события
            System.out.println(String.format("add %s : %s",ev.getName(), ev.getValue()));
        }
    }