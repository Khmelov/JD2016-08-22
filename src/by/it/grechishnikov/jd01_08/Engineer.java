package by.it.grechishnikov.jd01_08;

public abstract class Engineer implements Worker {
    private static final String COMPANY_NAME; //константа. название фирмы никому менять нельзя
    private String name;
    private int age;
    private int salary;

    static {
        COMPANY_NAME = "EPAM SYSTEMS"; //статический блок инициализации. для оценки
    }

    public Engineer() { //для оценки
    }

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

    protected void printCompanyName() { //для доступа у классов в пакете и у наследников
        System.out.println("Я работаю в " + COMPANY_NAME);
    }

    int getAge() {
        return age;
    }

    int getSalary() {
        return salary;
    }
}
