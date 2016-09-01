package by.it.akhmelev.jd01_01;

class Args {
    private String[] args;
    Args(String[] args) {
        this.args=args;
    }

    void printArgs(){
        for (String arg:args) {
            System.out.println(arg);
        }
    }
}
