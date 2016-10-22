package by.it.grechishnikov.jd03_03.dao;


import by.it.grechishnikov.jd03_02.crud.*;

import java.util.List;

public class UniversalDAO<Type extends Entity> {
    Type type;

    public UniversalDAO(Type type) {
        this.type = type;
    }

    public void create() {
        if(type instanceof Goods) {
            new GoodsDAO().create((Goods) type);
        } else if(type instanceof Order) {
            new OrdersDAO().create((Order) type);
        } else if(type instanceof Role) {
            new RolesDAO().create((Role) type);
        } else if(type instanceof User) {
            new UsersDAO().create((User) type);
        } else {
            System.out.println("Неподдерживаемый объект");
        }
    }

    public Entity read(int id) {
        if(type instanceof Goods) {
            return new GoodsDAO().read(id);
        } else if(type instanceof Order) {
            return new OrdersDAO().read(id);
        } else if(type instanceof Role) {
            return new RolesDAO().read(id);
        } else if(type instanceof User) {
            return new UsersDAO().read(id);
        } else {
            System.out.println("Неподдерживаемый объект");
        }
        return null;
    }

    public Entity update(Object obj) {
        if(type instanceof Goods) {
            return new GoodsDAO().update((Goods) type);
        } else if(type instanceof Order) {
            return new OrdersDAO().update((Order) type);
        } else if(type instanceof Role) {
            return new RolesDAO().update((Role) type);
        } else if(type instanceof User) {
            return new UsersDAO().update((User) type);
        } else {
            System.out.println("Неподдерживаемый объект");
        }
        return null;
    }

    public boolean delete(int id) {
        if(type instanceof Goods) {
            return new GoodsDAO().delete(id);
        } else if(type instanceof Order) {
            return new OrdersDAO().delete(id);
        } else if(type instanceof Role) {
            return new RolesDAO().delete(id);
        } else if(type instanceof User) {
            return new UsersDAO().delete(id);
        } else {
            System.out.println("Неподдерживаемый объект");
        }
        return false;
    }

    public List<? extends Entity> getAll() {
        if(type instanceof Goods) {
            return new GoodsDAO().getAll();
        } else if(type instanceof Order) {
            return new OrdersDAO().getAll();
        } else if(type instanceof Role) {
            return new RolesDAO().getAll();
        } else if(type instanceof User) {
            return new UsersDAO().getAll();
        } else {
            System.out.println("Неподдерживаемый объект");
        }
        return null;
    }
}
