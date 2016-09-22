package by.it.opiga.JD01_08;

import java.util.Objects;

/**
 * Created by Asus on 19.09.2016.
 */
public class Tanker extends CargoShip implements Ship {
    private int maxVesGruza;
    private int colTanks;
    private String type;

    public Tanker() {
        maxVesGruza = 5000;
        colTanks = 50;
        this.komandir = "x";
        this.name = "unname";
        this.scorost = 60;
        this.ves = 6000;

    }

    public Tanker(Object... arg) {
        super(arg);
        if (arg.length > 6) {
            switch (arg.length) {
                case 7: {
                    maxVesGruza = (int) arg[6];
                    break;
                }
                case 8: {
                    maxVesGruza = (int) arg[6];
                    colTanks = (int) arg[7];
                    break;
                }
                case 9: {
                    type = arg[8].toString();
                }

            }
        }
    }


    @Override
    public String showState() {
        String state = "cvbcvb";
        if (this.isStateSwim()) {
            state = "Корабль плывет";
        }
        if (this.isStateStop()) {
            state = "Корабль стоит";
            if (this.isStateLoaded()) {
                state = "Корабль загружается";
            }
            if (this.isStateFilled()) {
                state = "Корабль загружен";
            }
        }

        return state;
    }

    public int getMaxVesGruza() {
        return maxVesGruza;
    }

    public int getColTanks() {
        return colTanks;
    }

    public void setMaxVesGruza(int maxVesGruza) {
        this.maxVesGruza = maxVesGruza;
    }

    public void setColTanks(int colTanks) {
        this.colTanks = colTanks;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return getClass().getName() + " @maxVesGruza = " + maxVesGruza + " @colTanks = " + colTanks + " @name = " + name;
    }
}
