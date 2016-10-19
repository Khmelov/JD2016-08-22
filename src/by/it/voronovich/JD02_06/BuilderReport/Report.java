package by.it.voronovich.JD02_06.BuilderReport;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Report extends BuilderReport {

    @Override
    void action(String operation) {
        printWriter.println(operation);
        printWriter.flush();

    }
}
