package by.it.aborisenok.matLab.Vars;

import java.util.HashMap;

/**
 * Created by Лёша on 04.10.2016.
 */
public class HashMapper {
    private static HashMap<String, Var> veriable = new HashMap<>();

    public static void setVeriable(String key, Var var){
        veriable.put(key, var);
    }

    public static Var getVeriable(String key){
        Var var = veriable.get(key);
        return var;
    }

    public static HashMap<String, Var> getHashMap(){
        return veriable;
    }

    public static void assigned(String name, Var var){
        setVeriable(name, var);
    }

    public static boolean ifHashMapperContain(String key){
        if (veriable.containsKey(key)){
            return true;
        } else {
            return false;
        }
    }
}
