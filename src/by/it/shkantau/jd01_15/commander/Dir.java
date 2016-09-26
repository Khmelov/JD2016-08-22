package by.it.shkantau.jd01_15.commander;

import java.io.File;
import java.util.Date;

 class Dir  implements Instruction{
    private  File file;
    private  String [] args;

     Dir(String[] args , File file) {
        this.args = args;
        this.file = file;
    }

    @Override
    public void apply() {
        if (args == null){
            String [] files = file.list();
            for (String fileName : files){
                System.out.println(getFileString(new File(file.getPath() + File.separator + fileName)));
            }
        }else{
            File newFile = new File(file.getPath() + File.separator +args[0]);
            if (newFile.exists()) {
                String[] files = newFile.list();
                for (String fileName : files) {
                    System.out.println(getFileString(new File(newFile.getPath() + File.separator + fileName)));
                }
            }else  {
                System.out.println("Wrong directory path");
            }
        }
    }

    private String getFileString(File currentfile){

        String dateModified = new Date(currentfile.lastModified()).toString();
        String isDir;
        if (currentfile.isDirectory()){
            isDir = "<DIR>";
        }else {
            isDir = Long.toString(currentfile.length());
        }
       return String.format("%s \t %s \t %s", dateModified, isDir, currentfile.getName());
    }

}
