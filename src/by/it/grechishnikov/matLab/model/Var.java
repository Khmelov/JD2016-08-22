package by.it.grechishnikov.matLab.model;

import by.it.grechishnikov.matLab.controller.Runner;

import java.io.Serializable;

public abstract class Var implements IData, Serializable {
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

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " = ";
    }
}