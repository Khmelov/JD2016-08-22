package by.it.grechishnikov.jd01_08;


public class SeniorLead extends Lead { //SeniorLead расширяет Lead. Содержит поведение класса Lead и переопределяет некоторое его поведение
    private Engineer[] list;

    public SeniorLead(String name, int age, int salary, Engineer... leads) {
        super(name, age, salary);
        this.list = leads;
    }

    public SeniorLead(String name, int age, int salary, boolean oldWorker, Engineer... leads) {
        super(name, age, salary, oldWorker);
        this.list = leads;
    }

    @Override
    public void talkWithWorkers() {
        System.out.println("Здравствуйте, работники моей фирмы!");
    }

    @Override
    public void goToWork() {
        System.out.println("Иду собирать совет руководства.");
    }

    public Engineer[] getList() {
        return list;
    }

    public void setList(Engineer[] list) {
        this.list = list;
    }

    public static void cleanToilet() throws NotSupportedOperationException {
        throw new NotSupportedOperationException("SeniorLead не должен чистить туалет. ");
    }

    @Override
    public String toString() { //Полиморфизм. Переопределен метод toString для правильной его работы
        String result = String.format("Меня зовут %s, мне %d и я получаю $%d. Я руководитель над: ", getName(), getAge(), getSalary());
        for(Engineer e : getList()) {
            result += e.getName() + ", ";
        }
        return result.substring(0, result.length() - 2);
    }
}
