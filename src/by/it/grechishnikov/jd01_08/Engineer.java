package by.it.grechishnikov.jd01_08;

public abstract class Engineer implements Worker {
    private String name;
    private int age;
    private int salary;

    public Engineer(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public void goToWork() {
        System.out.println("Иду работать...");
    }

    @Override
    public void spendSalary() {
        System.out.println("Иду в магазин тратить зарплату...");
    }

    @Override
    public void talkWithWorkers() {
        System.out.println("Здравствуйте коллеги и начальство!");
    }

    @Override
    public void drinkCoffee() {
        System.out.println("Выпью кофе.");
    }

    @Override
    public void goToHome() {
        System.out.println("Наконец то пятница...");
    }

    @Override
    public void relax() {
        System.out.println("Буду отдыхать.");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }
}
