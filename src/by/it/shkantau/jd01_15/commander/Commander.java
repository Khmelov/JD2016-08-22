package by.it.shkantau.jd01_15.commander;

import java.io.File;

public class Commander {

    private File file = new File("");
    private Command command;


    public Commander(String path) {
        this.file = new File(path);
        if (!this.file.exists()){
            this.file = new File(System.getProperty("user.dir"));
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void setCommand(String line) {
        Command command= new Command(line, file);
        command.apply();
        printPath();
    }



    public void printPath(){
        System.out.print(file.getPath()+ ">");
    }








}
