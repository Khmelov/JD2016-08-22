package by.it.akhmelev.jd02_06.p08_observer;

class Subscriber2 implements PublisherActionListener{
    @Override
    public void doAction(String message) {
        System.out.println(message + " from "+ this.getClass().getName());
    }

}
