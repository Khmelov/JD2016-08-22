package by.it.voronovich.JD03_03.bean;

import java.io.Serializable;

public class CatalogGood implements Serializable{

    private int idCatalog;
    private String Brand;
    private String Model;
    private double Price;
    private String ReleaseDate;
    private String Weight;

    public CatalogGood(){

    }

    public CatalogGood(int idCatalog, String Brand, String Model, double Price, String ReleaseDate, String Weight){
        this.idCatalog=idCatalog;
        this.Brand=Brand;
        this.Model=Model;
        this.Price=Price;
        this.ReleaseDate=ReleaseDate;
        this.Weight=Weight;
    }

    @Override
    public int hashCode() {
        int result = idCatalog;
        result = 31 * result + Brand.hashCode();
        result = 31 * result + Model.hashCode();
        result = 31 * result + (int)Price;
        result = 31 * result + ReleaseDate.hashCode();
        result = 31 * result + Weight.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CatalogGood cg = (CatalogGood) o;

        if (idCatalog != cg.idCatalog) return false;
        if (!Brand.equals(cg.Brand)) return false;
        if (!Model.equals(cg.Model)) return false;
        if (Price != cg.Price) return false;
        if (!ReleaseDate.equals(cg.ReleaseDate)) return false;
        if (!Weight.equals(cg.Weight)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "CatalogGood{" +
                "idCatalog=" + idCatalog +
                ", Brand='" + Brand + '\'' +
                ", Model='" + Model + '\'' +
                ", Price='" + Price + '\'' +
                ", ReleaseDate='" + ReleaseDate + '\'' +
                ", Weight='" + Weight + '\'' +
                "}\n";
    }

    public int getIdCatalog() {
        return idCatalog;
    }

    public String getBrand() {
        return Brand;
    }

    public String getModel() {
        return Model;
    }

    public double getPrice() {
        return Price;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public String getWeight() {
        return Weight;
    }

    public void setIdCatalog(int idCatalog) {
        this.idCatalog = idCatalog;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public void setModel(String model) {
        Model = model;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public void setReleaseDate(String releaseDate) {
        ReleaseDate = releaseDate;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }
}
