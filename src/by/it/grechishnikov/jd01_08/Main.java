package by.it.grechishnikov.jd01_08;


public class Main {
    public static void main(String[] args) {
        //Вариант 3
        Engineer firstEngineer = new Lead("Василий Петрович", 30, 500, true);
        Engineer secondEngineer = new Lead("Александр Евгеньевич", 25, 400);
        SeniorLead major = new SeniorLead("Иван Аркадьевич", 50, 5000, firstEngineer, secondEngineer);

        System.out.println(firstEngineer.toString());
        firstEngineer.goToWork();
        firstEngineer.talkWithWorkers();

        System.out.println(secondEngineer);
        secondEngineer.goToWork();
        secondEngineer.talkWithWorkers();

        System.out.println(major);
        major.goToWork();
        major.talkWithWorkers();
    }
}
