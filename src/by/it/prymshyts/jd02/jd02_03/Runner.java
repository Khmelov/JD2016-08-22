package by.it.prymshyts.jd02.jd02_03;

public class Runner {
    public static void main(String[] args) {
        ManagerController managerController = new ManagerController(new Market());
        managerController.start();
    }
}
