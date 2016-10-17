package by.it.shkantau.jd02.jd02_10;

class POJO_Tire {
    private String brand;
    private String mark;
    private String type;
    private int width;
    private int series;
    private double diskDiameter;

    public POJO_Tire() {
    }

    POJO_Tire(String brand, String mark, String type, double diskDiameter, int width, int series) {
        this.brand = brand;
        this.mark = mark;
        this.type = type;
        this.diskDiameter = diskDiameter;
        this.width = width;
        this.series = series;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getDiskDiameter() {
        return diskDiameter;
    }

    public void setDiskDiameter(double diskDiameter) {
        this.diskDiameter = diskDiameter;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Tire:" +brand+" "+mark+" "+type+" "+width+"/"+series+ " R" + diskDiameter;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        return getClass() == obj.getClass() && this.hashCode() == obj.hashCode();
    }

    @Override
    public int hashCode() {
        return brand.hashCode()+mark.hashCode()+type.hashCode()+width+series + (int)diskDiameter;
    }
}
