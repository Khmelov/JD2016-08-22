package by.it.grechishnikov.jd01_08;


public class Lead extends Engineer {
    private String task; //Инкапсуляция. Скрываем доступ к переменным извне класса. Доступ к ним только через геттеры
    private boolean oldWorker;

    public Lead(String name, int age, int salary) {
        super(name, age, salary);
        oldWorker = false;
    }

    public Lead(String name, int age, int salary, boolean oldWorker) {
        super(name, age, salary);
        this.oldWorker = oldWorker;
    }

    public void doWork() {
        if(!getTask().isEmpty()) {
            System.out.println("Делаю: " + getTask());
        } else {
            System.out.println("Нет задания");
        }
    }

    @Override
    public boolean sleepOnWork() {
        System.out.println("Нельзя спать на работе!");
        return false;
    }

    @Override
    public void goToWork() {
        System.out.println("Иду руководить подчинёнными.");
    }

    @Override
    public String toString() {
        String result = String.format("Меня зовут %s, мне %d и я получаю $%d. ", getName(), getAge(), getSalary());
        return isOldWorker() ? result + "Я здесь работаю давно." : result + "Я здесь новенький.";
    }

    public boolean isOldWorker() {
        return oldWorker;
    }

    public void setOldWorker(boolean oldWorker) {
        this.oldWorker = oldWorker;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
