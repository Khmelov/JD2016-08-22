package by.it.prymshyts.jd02.jd02_08;

class Runner {
    public static void main(String[] args) {
        String fileName = "src/by/it/prymshyts/jd02/jd02_08/catalog+xsd.xml";

        System.out.println("SAX парсер:");
        System.out.println("--------------------------------------");

        SAX sax = new SAX();
        sax.parse(fileName);

        System.out.println("--------------------------------------\n");


        System.out.println("StAX парсер:");
        System.out.println("--------------------------------------");

        StAX.parse(fileName);

        System.out.println("--------------------------------------\n");

        System.out.println("DOM парсер:");
        System.out.println("--------------------------------------");

        DOM.parse(fileName);

        System.out.println("--------------------------------------");
    }
}
