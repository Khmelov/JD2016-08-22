package by.it.shkantau.jd01.jd01_12;

public class Runner_JD12 {

    private static String text =
            "As you can see from the table, the Java Collections Framework provides several general-purpose implementations of the Set,\n" +
             " List , and Map interfaces. In each case, one implementation — HashSet, ArrayList, and HashMap — is clearly the one to  \n" +
             "use for most applications, all other things being equal. Note that the SortedSet and the SortedMap interfaces do not have rows\n" +
                    " in the table. Each of those interfaces has one implementation (TreeSet and TreeMap) and is listed in the Set and the Map \n" +
                    "rows. There are two general-purpose Queues implementations — LinkedList, which is also a List implementation, and PriorityQueue,\n" +
                    " which is omitted from the table. These two implementations provide very different semantics: LinkedList provides FIFO semantics, \n" +
                    "while PriorityQueue orders its elements according to their values. Each of the general-purpose implementations \n" +
                    "provides all optional operations contained in its interface. All permit null elements, keys, and values. None are \n" +
                    " synchronized (thread-safe). All have fail-fast iterators, which detect illegal concurrent modification during iteration\n" +
                    " and fail quickly and cleanly rather than risking arbitrary, nondeterministic behavior at an undetermined time in the future.";



    public static void main(String[] args) {

        Task12A.a1(15, 5);
        Task12A.a2();
        Task12A.a3();

        Task12B.b1(text);
        Task12B.b2(100000);

        Task12C.c1(System.getProperty("user.dir")+"/src/by/it/shkantau/jd01_12/list.txt");
//        Task12C.c2();
    }
}
