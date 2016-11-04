package by.it.shkantau.project.java.dao;

import java.util.List;

interface IDAO<TYPE> {
    //READ чтение отдельной сущности
    TYPE read(int id);
    //CREATE,UPDATE,DELETE обновление сущности
    int create(TYPE entity);
    boolean update(TYPE entity);
    boolean delete(TYPE entity);

    //READ - чтение всех элементов по условию
    List<TYPE> getAll(String WhereAndOrder);
    //и другие необходимые системе операции

}
