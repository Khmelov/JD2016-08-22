package by.it.akhmelev.project.java.controller;

public class Menu {
    private String text="";
    private Boolean rigthPosition=false;
    private Boolean active;

    public Menu(String text) {
        this.text = text;
    }

    public Menu(String text, Boolean rigthPosition) {
        this.text = text;
        this.rigthPosition = rigthPosition;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getRigthPosition() {
        return rigthPosition;
    }

    public void setRigthPosition(Boolean rigthPosition) {
        this.rigthPosition = rigthPosition;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }




}
