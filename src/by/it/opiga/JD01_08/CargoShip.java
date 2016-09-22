package by.it.opiga.JD01_08;

/**
 * Created by Asus on 19.09.2016.
 */
public abstract class CargoShip implements Ship {

    protected int shirina;
    protected int visota;
    protected int ves;
    protected int scorost;
    protected String name;
    protected String komandir;

    private boolean stateSwim=true;
    private boolean stateStop=false;
    private boolean stateLoaded=false;
    private boolean stateFilled=true;


    public CargoShip() {
    }

    public CargoShip(Object... arg) {
        switch (arg.length) {
            case 1: {
                shirina = (int) arg[0];
                break;
            }
            case 2: {
                shirina = (int) arg[0];
                visota = (int) arg[1];
                break;
            }
            case 3: {
                shirina = (int) arg[0];
                visota = (int) arg[1];
                ves = (int) arg[2];
                break;
            }
            case 4: {
                shirina = (int) arg[0];
                visota = (int) arg[1];
                ves = (int) arg[2];
                scorost = (int) arg[3];
                break;
            }
            case 5: {
                shirina = (int) arg[0];
                visota = (int) arg[1];
                ves = (int) arg[2];
                scorost = (int) arg[3];
                name = arg[4].toString();
                break;
            }
            case 6: {
                shirina = (int) arg[0];
                visota = (int) arg[1];
                ves = (int) arg[2];
                scorost = (int) arg[3];
                name = arg[4].toString();
                komandir = arg[5].toString();
                break;
            }
        }
        }
    @Override
    public boolean swim() {
        stateSwim=true;
        stateStop=false;
        stateLoaded=false;
        stateFilled=true;
        return true;
    }

    @Override
    public boolean stand() {
        stateStop=true;
        stateSwim=false;
        stateLoaded=false;
        stateFilled=false;
        return false;
    }

    @Override
    public boolean loaded() {
        stateStop=true;
        stateSwim=false;
        stateLoaded=true;
        stateFilled=false;
        return false;
    }

    @Override
    public boolean filled() {
        stateStop=true;
        stateSwim=false;
        stateLoaded=false;
        stateFilled=true;
        return false;
    }

    boolean isStateSwim() {
        return stateSwim;
    }

    boolean isStateStop() {
        return stateStop;
    }
    boolean isStateLoaded() {
        return stateLoaded;
    }
    boolean isStateFilled() {
        return stateFilled;
    }
    public abstract String showState();

    public int getShirina() {
        return shirina;
    }

    public int getVisota() {
        return visota;
    }

    public int getVes() {
        return ves;
    }

    public int getScorost() {
        return scorost;
    }

    public String getName() {
        return name;
    }

    public String getKomandir() {
        return komandir;
    }

    public void setShirina(int shirina) {
        this.shirina = shirina;
    }

    public void setVisota(int visota) {
        this.visota = visota;
    }

    public void setVes(int ves) {
        this.ves = ves;
    }

    public void setScorost(int scorost) {
        this.scorost = scorost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKomandir(String komandir) {
        this.komandir = komandir;
    }
    @Override
    public String toString() {
        return getClass().getName()+"@name = "+name+"@komandir = "+komandir;
    }
}
