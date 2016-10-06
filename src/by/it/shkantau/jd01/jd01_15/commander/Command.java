package by.it.shkantau.jd01.jd01_15.commander;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Command implements Instruction {
    private String name ;
    private  String [] args;
    private File file;

     Command(String line, File file) {
        if (line.length() < 2 || file == null){
            throw new  IllegalArgumentException();
        }

        String [] strings = line.trim().split("\\s");

        switch (strings.length){
            case 0: throw new  IllegalArgumentException();
            case 1: this.args = null; break;
            default:
                List<String> tmp = new ArrayList<>(Arrays.asList(strings));
                tmp.remove(0);
                this.args  = tmp.toArray(new String[tmp.size()]);
        }

        this.name = strings[0];
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    @Override
    public void apply() {

        switch (name){
            case "dir":
                Dir dir = new Dir(this.args, file);
                dir.apply();
                break;
            case "cd":
                Cd cd = new Cd(this.args, file);
                cd.apply();

                break;
            default:
                System.out.println("Command not found.");
        }

    }
}
