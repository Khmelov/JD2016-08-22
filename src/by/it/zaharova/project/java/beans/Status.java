package by.it.zaharova.project.java.beans;

public class Status {
    private int ID;
    private String Patient_status;
    private int FK_diagnostic;

    public Status() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPatient_status() {
        return Patient_status;
    }

    public void setPatient_status(String patient_status) {
        Patient_status = patient_status;
    }

    public int getFK_diagnostic() {
        return FK_diagnostic;
    }

    public void setFK_diagnostic(int FK_diagnostic) {
        this.FK_diagnostic = FK_diagnostic;
    }

    public Status(int ID, String patient_status, int FK_diagnostic) {
        this.ID = ID;
        Patient_status = patient_status;
        this.FK_diagnostic = FK_diagnostic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Status status = (Status) o;

        if (ID != status.ID) return false;
        if (FK_diagnostic != status.FK_diagnostic) return false;
        return Patient_status != null ? Patient_status.equals(status.Patient_status) : status.Patient_status == null;

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (Patient_status != null ? Patient_status.hashCode() : 0);
        result = 31 * result + FK_diagnostic;
        return result;
    }

    @Override
    public String toString() {
        return "Status{" +
                "ID=" + ID +
                ", Patient_status='" + Patient_status + '\'' +
                ", FK_diagnostic=" + FK_diagnostic +
                '}';
    }
}
