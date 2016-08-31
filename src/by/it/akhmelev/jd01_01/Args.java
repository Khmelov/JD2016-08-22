package by.it.akhmelev.jd01_01;

public class Args {
    private String[] args;
    public Args(String[] args) {
        this.args=args;
    }

    public void printArgs(){
        for (String arg:args) {
            System.out.println(arg);
        }
    }
}
