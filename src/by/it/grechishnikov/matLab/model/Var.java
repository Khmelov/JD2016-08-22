package by.it.grechishnikov.matLab.model;

import by.it.grechishnikov.matLab.controller.Runner;

public abstract class Var implements IOperationable{
    String name;

    public Var(String name) {
        this.name = name;
    }

    @Override
    public Var add(Var var) throws NotSupportedException {
        throw new NotSupportedException();
    }

    public Var add(Scalar var) throws NotSupportedException {
        throw new NotSupportedException();
    }

    public Var add(Vector var) throws NotSupportedException {
        throw new NotSupportedException();
    }

    public Var add(Matrix var) throws NotSupportedException {
        throw new NotSupportedException();
    }



    @Override
    public Var sub(Var var) throws NotSupportedException {
        throw new NotSupportedException();
    }

    public Var sub(Scalar var) throws NotSupportedException {
        throw new NotSupportedException();
    }

    public Var sub(Vector var) throws NotSupportedException {
        throw new NotSupportedException();
    }

    public Var sub(Matrix var) throws NotSupportedException {
        throw new NotSupportedException();
    }



    @Override
    public Var mul(Var var) throws NotSupportedException {
        throw new NotSupportedException();
    }

    public Var mul(Scalar var) throws NotSupportedException {
        throw new NotSupportedException();
    }

    public Var mul(Vector var) throws NotSupportedException {
        throw new NotSupportedException();
    }

    public Var mul(Matrix var) throws NotSupportedException {
        throw new NotSupportedException();
    }



    @Override
    public Var div(Var var) throws NotSupportedException {
        throw new NotSupportedException();
    }

    public Var div(Scalar var) throws NotSupportedException {
        throw new NotSupportedException();
    }

    public Var div(Vector var) throws NotSupportedException {
        throw new NotSupportedException();
    }

    public Var div(Matrix var) throws NotSupportedException {
        throw new NotSupportedException();
    }

    @Override
    public void assign() {
        Runner.storage.put(name, this);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " = ";
    }
}
