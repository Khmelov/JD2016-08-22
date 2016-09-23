package by.it.shkantau.jd01_12;

import java.io.*;
import java.util.*;


 class Task12C {

     static void c1 ( String src) {
//read file from src
        File file = new File(src);
        if (file.exists()) {
            Map<Integer, String> mapList = new TreeMap<>();
// readLine from file and split by  \t
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "windows-1251"))){
                String line;
                String[] strSplits;
                while ((line = br.readLine()) != null) {
                    strSplits = line.split("\\t");
                    if (strSplits.length == 2) {
                        try {
                            mapList.put(Integer.parseInt(strSplits[0]), strSplits[1]);
                        }catch (NumberFormatException e){
                            System.out.println("Wrong goods code format");
                        }

                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            Set<String> stringSet = new HashSet<>();
            Iterator itr = mapList.entrySet().iterator() ;

            while  (itr.hasNext()){
                Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) itr.next();
                String value = entry.getValue();
                if(!stringSet.add(value)){
                    itr.remove();
                }
            }

            itr = mapList.entrySet().iterator() ;
            while  (itr.hasNext()){
                System.out.println(itr.next());
            }
        }else {
            System.out.println("Source not found.");
        }
    }
    static void  c2 (){
//        System.out.print("Type some like this: ( ( () [] ) {} ):");
//        Scanner scanner  = new Scanner(System.in);
//        String line = scanner.nextLine();

    }
}
