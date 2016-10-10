package by.it.voronovich.JD02_06.Var;

import by.it.voronovich.JD02_06.Interface.IVariable;

/**
 *@author Voronovich Dmitry
 *@version 1.1
 */
public abstract class Variable implements IVariable {

    @Override
    public void setValue(Object value) {}

    @Override
    public Object getValue() { return null; }

    @Override
    public boolean saveVar(String name) { return false; }

    @Override
    public Object readVar(String name) { return null; }

    @Override
    public String toString() {
        return null;
    }

    public abstract void setValue (String value);
}