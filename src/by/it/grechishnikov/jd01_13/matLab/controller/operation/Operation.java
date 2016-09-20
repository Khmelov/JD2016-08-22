package by.it.grechishnikov.jd01_13.matLab.controller.operation;

import by.it.grechishnikov.jd01_13.matLab.model.*;


public  class Operation implements IOperationable {

    @Override
    public Var add(String name, Var var1, Var var2) {
        try {
            if (var1 instanceof Scalar && var2 instanceof Scalar)
                return Add.add(name, (Scalar) var1, (Scalar) var2);
            else if (var1 instanceof Scalar && var2 instanceof Vector)
                return Add.add(name, (Scalar) var1, (Vector) var2);
            else if (var1 instanceof Scalar && var2 instanceof Matrix)
                return Add.add(name, (Scalar) var1, (Matrix) var2);

            else if (var1 instanceof Vector && var2 instanceof Scalar)
                return Add.add(name, (Vector) var1, (Scalar) var2);
            else if (var1 instanceof Vector && var2 instanceof Vector)
                return Add.add(name, (Vector) var1, (Vector) var2);
            else if (var1 instanceof Vector && var2 instanceof Matrix)
                return Add.add(name, (Vector) var1, (Matrix) var2);

            else if (var1 instanceof Matrix && var2 instanceof Scalar)
                return Add.add(name, (Matrix) var1, (Scalar) var2);
            else if (var1 instanceof Matrix && var2 instanceof Vector)
                return Add.add(name, (Matrix) var1, (Vector) var2);
            else if (var1 instanceof Matrix && var2 instanceof Matrix)
                return Add.add(name, (Matrix) var1, (Matrix) var2);
            else
                throw new NotSupportedException();
        } catch (NotSupportedException e) {
            System.out.println("Операция невозможна");
            return new NullObject();
        }
    }

    public Var mul(String name, Var var1, Var var2) {
        try {
            if (var1 instanceof Scalar && var2 instanceof Scalar)
                return Mul.mul(name, (Scalar) var1, (Scalar) var2);
            else if (var1 instanceof Scalar && var2 instanceof Vector)
                return Mul.mul(name, (Scalar) var1, (Vector) var2);
            else if (var1 instanceof Scalar && var2 instanceof Matrix)
                return Mul.mul(name, (Scalar) var1, (Matrix) var2);

            else if (var1 instanceof Vector && var2 instanceof Scalar)
                return Mul.mul(name, (Vector) var1, (Scalar) var2);
            else if (var1 instanceof Vector && var2 instanceof Vector)
                return Mul.mul(name, (Vector) var1, (Vector) var2);
            else if (var1 instanceof Vector && var2 instanceof Matrix)
                return Mul.mul(name, (Vector) var1, (Matrix) var2);

            else if (var1 instanceof Matrix && var2 instanceof Scalar)
                return Mul.mul(name, (Matrix) var1, (Scalar) var2);
            else if (var1 instanceof Matrix && var2 instanceof Vector)
                return Mul.mul(name, (Matrix) var1, (Vector) var2);
            else if (var1 instanceof Matrix && var2 instanceof Matrix)
                return Mul.mul(name, (Matrix) var1, (Matrix) var2);
            else
                throw new NotSupportedException();
        } catch (NotSupportedException e) {
            System.out.println("Операция невозможна");
            return new NullObject();
        }
    }

    public Var div(String name, Var var1, Var var2) {
        try {
            if (var1 instanceof Scalar && var2 instanceof Scalar)
                return Div.div(name, (Scalar) var1, (Scalar) var2);
            else if (var1 instanceof Scalar && var2 instanceof Vector)
                return Div.div(name, (Scalar) var1, (Vector) var2);
            else if (var1 instanceof Scalar && var2 instanceof Matrix)
                return Div.div(name, (Scalar) var1, (Matrix) var2);

            else if (var1 instanceof Vector && var2 instanceof Scalar)
                return Div.div(name, (Vector) var1, (Scalar) var2);
            else if (var1 instanceof Vector && var2 instanceof Vector)
                return Div.div(name, (Vector) var1, (Vector) var2);
            else if (var1 instanceof Vector && var2 instanceof Matrix)
                return Div.div(name, (Vector) var1, (Matrix) var2);

            else if (var1 instanceof Matrix && var2 instanceof Scalar)
                return Div.div(name, (Matrix) var1, (Scalar) var2);
            else if (var1 instanceof Matrix && var2 instanceof Vector)
                return Div.div(name, (Matrix) var1, (Vector) var2);
            else if (var1 instanceof Matrix && var2 instanceof Matrix)
                return Div.div(name, (Matrix) var1, (Matrix) var2);
            else
                throw new NotSupportedException();
        } catch (NotSupportedException e) {
            System.out.println("Операция невозможна");
            return new NullObject();
        }
    }


    public Var sub(String name, Var var1, Var var2) {
        try {
            if (var1 instanceof Scalar && var2 instanceof Scalar)
                return Sub.sub(name, (Scalar) var1, (Scalar) var2);
            else if (var1 instanceof Scalar && var2 instanceof Vector)
                return Sub.sub(name, (Scalar) var1, (Vector) var2);
            else if (var1 instanceof Scalar && var2 instanceof Matrix)
                return Sub.sub(name, (Scalar) var1, (Matrix) var2);

            else if (var1 instanceof Vector && var2 instanceof Scalar)
                return Sub.sub(name, (Vector) var1, (Scalar) var2);
            else if (var1 instanceof Vector && var2 instanceof Vector)
                return Sub.sub(name, (Vector) var1, (Vector) var2);
            else if (var1 instanceof Vector && var2 instanceof Matrix)
                return Sub.sub(name, (Vector) var1, (Matrix) var2);

            else if (var1 instanceof Matrix && var2 instanceof Scalar)
                return Sub.sub(name, (Matrix) var1, (Scalar) var2);
            else if (var1 instanceof Matrix && var2 instanceof Vector)
                return Sub.sub(name, (Matrix) var1, (Vector) var2);
            else if (var1 instanceof Matrix && var2 instanceof Matrix)
                return Sub.sub(name, (Matrix) var1, (Matrix) var2);
            else
                throw new NotSupportedException();
        } catch (NotSupportedException e) {
            System.out.println("Операция невозможна");
            return new NullObject();
        }
    }
}