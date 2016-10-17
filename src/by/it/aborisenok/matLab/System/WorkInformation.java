package by.it.aborisenok.matLab.System;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by aborisenok on 17.10.2016.
 */
public class WorkInformation {
      private static Time startTime;
      private static Time endTime;

      private static ArrayList<String> fullOperation = new ArrayList<>();


    public static ArrayList<String> getFullOperation() {
        return fullOperation;
    }

    public static void setFullOperation(String oper) {
        fullOperation.add(oper);
    }

    public static Time getStartTime() {
        return startTime;
    }

    public static void setStartTime() {
       startTime =  new Time(System.currentTimeMillis());
    }

    public static Time getEndTime() {
        return endTime;
    }

    public static void setEndTime() {
        endTime =  new Time(System.currentTimeMillis());
    }
}
