package by.it.snegurskiy.jd01.jd01_01;

/**
 * Created by user on 22.08.2016.
 */
public class PrintArgs {

    private String [] args;

    public PrintArgs (String [] args){
        this.args = args;
    }

    public void printAllArgs(){
        for (String oneArg:args) {
            System.out.println(oneArg);
        }
    }
}
