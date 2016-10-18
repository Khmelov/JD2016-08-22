package by.it.filimonchik.jd01_15;

        import java.io.*;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class Task_B {
    public static void B1() throws FileNotFoundException {
        String src = System.getProperty( "user.dir" ) + "/src/by/it/filimonchik/";

        String one = src + "jd01_15/Task_B.java";
        String two = src + "jd01_15/Task_B.txt";

        File f1 = new File( one );
        File f2 = new File( two );

        String line;
        StringBuilder s = new StringBuilder(one);

        try (BufferedReader test = new BufferedReader( new FileReader( one ) )) {
            while ((line = test.readLine()) != null) {
                s.append( line + "\n" );

            }

            StringBuilder tmp = new StringBuilder( s );
            Pattern p = Pattern.compile( "/{2}.+" );
            Matcher m = p.matcher( tmp );
            int pos = 0; 

            while (m.find( pos )) {

                tmp.delete( m.start(), m.end() );
                pos = m.start();

            }
            
            Pattern p1 = Pattern.compile( ".+\n" );
            Matcher m1 = p1.matcher( tmp );
            int col = 1;
            while (m1.find()) {
                System.out.printf( "%02d   %s", col, m1.group() );
                col++;

            }
            try (BufferedWriter rb = new BufferedWriter(new FileWriter(two))) {
                rb.write(tmp.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

