package by.it.voronovich.JD02_06.BuilderReport;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ReportStart extends BuilderReport{

    @Override
    public void start() {
        DateFormat start = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        String startTime = start.format(System.currentTimeMillis());
        System.out.println(startTime);
        String line = startTime + "\n";
        printWriter.println(line);
        printWriter.flush();
    }
}
