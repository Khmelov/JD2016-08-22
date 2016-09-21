package by.it.grechishnikov.jd01_13.matLab.model;

import by.it.grechishnikov.jd01_13.matLab.controller.Runner;

public abstract class Var implements IData {
    boolean alive = false;
    private String name = "";

    public Var() {
    }

    public Var(String name) {
        this.name = name;
    }

    @Override
    public void assign() {
        if(alive) {
            Runner.storage.put(name, this);
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " = ";
    }
}