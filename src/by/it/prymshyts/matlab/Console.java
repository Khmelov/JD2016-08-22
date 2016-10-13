package by.it.prymshyts.matlab;

class Console {

    static void println(Object s) {
        if (s != null) {
            System.out.println(s);
        }
    }

    static void print(Object s) {
        if (s != null) {
            System.out.print(s);
        }
    }

    static void printWarning(Object s) {
        System.err.println(s);
    }
}
