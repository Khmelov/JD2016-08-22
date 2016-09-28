package by.it.akhmelev.jd02_02;

public class Th2_09_deadlock {
    private static class Friend {
        private final String name;
        Friend(String name) {this.name = name;}
        public String getName() {return this.name;}

        synchronized void bow(Friend bower) {
            System.out.format("%s: %s" + " поклонился мне!%n", this.name, bower.getName());
            bower.bowBack(this);
        }

        synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s" + " стал прямо!%n",    this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend tim = new Friend("Тим");
        final Friend bob = new Friend("Боб");
        new Thread(new Runnable() {
            public void run() { tim.bow(bob); }
        }).start();
        new Thread(new Runnable() {
            public void run() { bob.bow(tim); }
        }).start();
    }
}
