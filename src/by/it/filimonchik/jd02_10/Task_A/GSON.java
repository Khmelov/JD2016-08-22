package by.it.filimonchik.jd02_10.Task_A;

import by.it.filimonchik.jd02_10.Task_A.ArendaAuto;
import by.it.filimonchik.jd02_10.Task_A.Diller;
import by.it.filimonchik.jd02_10.Task_A.Dillers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

/**
 * Created by Raman.Filimonchyk on 27/10/2016.
 */
public class GSON {
    public static void main (String [] args){
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

        ArrayList<Diller> list = new ArrayList<>();
        Diller diller = new Diller("Ivan", "Audi");
        list.add(diller);
        diller = new Diller("Vasia", "Ferrari");
        list.add(diller);

        Dillers dillers = new Dillers();
        dillers.setList(list);

        ArendaAuto arendaauto = new ArendaAuto();
        arendaauto.setDillers(dillers);

        String json = gson.toJson(arendaauto);
        System.out.println("Task A." + "\n" + "Маршаллизация: " + "\n" + json);

        ArendaAuto dill = gson.fromJson(json, ArendaAuto.class);
        System.out.print("\n" + "Демаршаллизация: " + "\n" + dill.toString());


    }
}
