package by.it.prymshyts.jd02.jd02_03;

class Logger implements ILogger {

    static void buyersLog(String str) {
        if (BUYERS_LOG) {
            System.out.println(str);
        }
    }

    static void marketLog(String str) {
        if (MARKET_LOG) {
            System.out.println(str);
        }
    }

    static void checkLog(String str) {
        if (CHECK_LOG) {
            System.out.println(str);

        }
    }

    static String getWhitespaceString(int num) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num * 25; i++) {
            sb.append(" ");
        }

        return sb.toString();
    }
}
