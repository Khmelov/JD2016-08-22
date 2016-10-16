package by.it.shkantau.jd02.jd02_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TaskA {

    private static String gsonStr;

    public static void main(String[] args) {

        System.out.println("Getting GsonStr from POJO:\n"+demarshlingGSON());
        System.out.println("Create POJO from gsonSr:\n"+marshlingGSOM(gsonStr));

    }

    private static String demarshlingGSON(){
        gsonStr = (new GsonBuilder().serializeNulls().setPrettyPrinting().create()).toJson(createPOJO_Instance());
        return  gsonStr;
    }

    private static POJO_Car marshlingGSOM(String gsonStr){
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        return gsonStr != null ? gson.fromJson(gsonStr, POJO_Car.class) : null;
    }

    private static POJO_Car createPOJO_Instance(){
        return  new POJO_Car("Skoda", 2013, 98000, "Oktavia", new POJO_Tire("Barum","Polaris 3", "winter", 15.0, 195, 65));

    }

}
