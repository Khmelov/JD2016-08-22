package by.it.voronovich.JD02_06.BuilderReport;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ReportEnd extends BuilderReport{

    @Override
    public void end() {
        DateFormat end = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        String endTime = end.format(System.currentTimeMillis());
        System.out.println(endTime);
        printWriter.println(endTime);
        printWriter.flush();
    }
}
