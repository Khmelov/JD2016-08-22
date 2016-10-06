package by.it.shkantau.jd01.jd01_15.commander;

import java.io.File;

 class Cd implements Instruction {
    private File file;
    private  String [] args;

     Cd(String[] args, File file) {
        this.file = file;
        this.args = args;
    }

    @Override
    public void apply() {
        if (args != null){
            String [] dirs  = args[0].trim().split(File.separator);
        }
    }
}
