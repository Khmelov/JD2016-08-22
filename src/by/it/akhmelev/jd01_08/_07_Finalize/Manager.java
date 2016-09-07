package by.it.akhmelev.jd01_08._07_Finalize;

class Manager {
    private int id;
    Manager(int value) {
        id = value;
    }
    protected void finalize() throws Throwable {
        try {
// код освобождения ресурсов
            System.out.println("объект будет удален, id=" + id);
        } finally {
            super.finalize();
        }
    }
}
