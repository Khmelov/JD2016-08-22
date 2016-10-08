package by.it.aborisenok.matLab.Errors;

/**
 * Created by aborisenok on 07.10.2016.
 */
public class UseOfUnknownVariableException extends IllegalArgumentException {
    public UseOfUnknownVariableException(String s){
        super(s);
    }
}
