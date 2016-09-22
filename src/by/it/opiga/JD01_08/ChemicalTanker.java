package by.it.opiga.JD01_08;

/**
 * Created by Asus on 21.09.2016.
 */
public class ChemicalTanker extends Tanker {

    @Override
    public String showState() {
        return super.showState();
    }

    public ChemicalTanker() {
        super();
    }

    public ChemicalTanker(Object... arg) {
        super(arg);
    }
    @Override
    public String toString() {
        return getClass().getName()+" @name = "+name;
    }


}
