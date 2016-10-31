package by.it.snegurskiy;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Acer on 25.10.2016.
 */
public class Pars2 {

    public static void main(String[] args) {

        String s="ContactId=261594&OrderId=c0fa223a-e0d4-4bed-b335-b97df36caa13&OrderTypeId=1&OrderStatusId=1&OrderStatus=4&OrderStageId=20&EntrySourceId=2&FulfillmentLocationId=1&SubsidiaryCode=US&OrderDate=8/1/2016 4:59:00 AM&Culture=en-US";
        String[] pars=s.split("&");
        HashMap<String,String> Map= new HashMap<>();
        for (int i = 0; i <pars.length ; i++) {
            String []s1 = pars[i].split("=");
            Map.put(s1[0],s1[1]);

        }

    }
}
