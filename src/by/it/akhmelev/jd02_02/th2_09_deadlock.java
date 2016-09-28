package by.it.akhmelev.jd02_02;

public class th2_09_deadlock {
    static class Friend {
        private final String name;
        public Friend(String name) {this.name = name;}
        public String getName() {return this.name;}

        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s" + " поклонился мне!%n", this.name, bower.getName());
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) {
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
