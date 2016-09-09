package by.it.akhmelev.jd01_09.nested;

/**
 * Created by Alex on 18.02.2016.
 */
public interface University {
    int NUMBER_FACULTY = 20;
    void create();
    class LearningDepartment { // static по умолчанию
        public int idChief;
        public static void assignPlan(int idFaculty) {
            // реализация
        }
        public void acceptProgram() {
            // реализация
        }
    }
}