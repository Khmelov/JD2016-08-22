package by.it.shkantau.jd02.jd02_10;

class POJO_Car {
    private String vendor;
    private int yearBuild;
    private int mileage;
    private String mark;
    private POJO_Tire tire;


    public POJO_Car() {
    }

    POJO_Car(String vendor, int yearBuild, int mileage, String mark, POJO_Tire tire) {
        this.vendor = vendor;
        this.yearBuild = yearBuild;
        this.mileage = mileage;
        this.mark = mark;
        this.tire = tire;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public int getYearBuild() {
        return yearBuild;
    }

    public void setYearBuild(int yearBuild) {
        this.yearBuild = yearBuild;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public POJO_Tire getTire() {
        return tire;
    }

    public void setTire(POJO_Tire tire) {
        this.tire = tire;
    }

    @Override
    public int hashCode() {
        return vendor.hashCode()+yearBuild+mileage+mark.hashCode()+tire.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        return this.getClass() == obj.getClass() && this.hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        return "Car: " + vendor+" "+mark+" "+ yearBuild + " "+ mileage +", " + tire;
    }
}
