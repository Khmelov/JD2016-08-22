package by.it.akhmelev.jd01_10.matlab_prototype;

public class Error {
    //должен наследоваться extends Exception
    //но материала не было, поэтому будет просто вывод
    public Error(String hint) {
        System.out.println("ERR:" + hint);
    }
}
