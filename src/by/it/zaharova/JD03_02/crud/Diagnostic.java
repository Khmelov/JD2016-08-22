package by.it.zaharova.JD03_02.crud;

public class Diagnostic {
    private int ID;
    private String Illness;
    private String Drugs;
    private String Operations;
    private String Procedures;
    private int FK_patients;
    private int FK_doctors;

    public Diagnostic() {
    }

    public Diagnostic(int ID, String illness, String drugs, String operations, String procedures, int FK_patients, int FK_doctors) {
        this.ID = ID;
        Illness = illness;
        Drugs = drugs;
        Operations = operations;
        Procedures = procedures;
        this.FK_patients = FK_patients;
        this.FK_doctors = FK_doctors;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getIllness() {
        return Illness;
    }

    public void setIllness(String illness) {
        Illness = illness;
    }

    public String getDrugs() {
        return Drugs;
    }

    public void setDrugs(String drugs) {
        Drugs = drugs;
    }

    public String getOperations() {
        return Operations;
    }

    public void setOperations(String operations) {
        Operations = operations;
    }

    public String getProcedures() {
        return Procedures;
    }

    public void setProcedures(String procedures) {
        Procedures = procedures;
    }

    public int getFK_patients() {
        return FK_patients;
    }

    public void setFK_patients(int FK_patients) {
        this.FK_patients = FK_patients;
    }

    public int getFK_doctors() {
        return FK_doctors;
    }

    public void setFK_doctors(int FK_doctors) {
        this.FK_doctors = FK_doctors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Diagnostic that = (Diagnostic) o;

        if (ID != that.ID) return false;
        if (FK_patients != that.FK_patients) return false;
        if (FK_doctors != that.FK_doctors) return false;
        if (Illness != null ? !Illness.equals(that.Illness) : that.Illness != null) return false;
        if (Drugs != null ? !Drugs.equals(that.Drugs) : that.Drugs != null) return false;
        if (Operations != null ? !Operations.equals(that.Operations) : that.Operations != null) return false;
        return Procedures != null ? Procedures.equals(that.Procedures) : that.Procedures == null;

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (Illness != null ? Illness.hashCode() : 0);
        result = 31 * result + (Drugs != null ? Drugs.hashCode() : 0);
        result = 31 * result + (Operations != null ? Operations.hashCode() : 0);
        result = 31 * result + (Procedures != null ? Procedures.hashCode() : 0);
        result = 31 * result + FK_patients;
        result = 31 * result + FK_doctors;
        return result;
    }

    @Override
    public String toString() {
        return "Diagnostic{" +
                "ID=" + ID +
                ", Illness='" + Illness + '\'' +
                ", Drugs='" + Drugs + '\'' +
                ", Operations='" + Operations + '\'' +
                ", Procedures='" + Procedures + '\'' +
                ", FK_patients=" + FK_patients +
                ", FK_doctors=" + FK_doctors +
                '}';
    }
}
