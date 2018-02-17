package com;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonArray = "{\n" +
                "\t\"PENDING_CHALLANS\": [{\n" +
                "\t\t\t\"CHALLAN_NO\": \"HYD2014EC1905118\",\n" +
                "\t\t\t\"UNIT_CODE\": \"23\",\n" +
                "\t\t\t\"REGN_NO\": \"AP11Z4484\",\n" +
                "\t\t\t\"OFFENCE_DATE\": \"2014-08-02\",\n" +
                "\t\t\t\"OFF_TIME\": \"09:39\",\n" +
                "\t\t\t\"BOOKED_POLICE_STATION_NAME\": \"MARREDPALLY TRPS\",\n" +
                "\t\t\t\"PLACE_OF_VIOLATION\": \"SWEEKAR/UPKAAR\",\n" +
                "\t\t\t\"VIOLATIONS\": \"LANE/LINE CROSSING\",\n" +
                "\t\t\t\"ACTUAL_AMOUNT\": \"100\",\n" +
                "\t\t\t\"USER_CHARGES\": \"35\",\n" +
                "\t\t\t\"COMPOUNDING_AMOUNT\": \"135\",\n" +
                "\t\t\t\"TOKEN\": \"118518533\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"CHALLAN_NO\": \"HYD2014EC1024350\",\n" +
                "\t\t\t\"UNIT_CODE\": \"23\",\n" +
                "\t\t\t\"REGN_NO\": \"AP11Z4484\",\n" +
                "\t\t\t\"OFFENCE_DATE\": \"2014-01-03\",\n" +
                "\t\t\t\"OFF_TIME\": \"11:59\",\n" +
                "\t\t\t\"BOOKED_POLICE_STATION_NAME\": \"NA\",\n" +
                "\t\t\t\"PLACE_OF_VIOLATION\": \"RATNAIAH PETROL PUMP X ROAD\",\n" +
                "\t\t\t\"VIOLATIONS\": \"SIGNAL JUMPING\",\n" +
                "\t\t\t\"ACTUAL_AMOUNT\": \"1000\",\n" +
                "\t\t\t\"USER_CHARGES\": \"35\",\n" +
                "\t\t\t\"COMPOUNDING_AMOUNT\": \"1035\",\n" +
                "\t\t\t\"TOKEN\": \"118518533\"\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";

        PendingChallanList pendingChallanList = objectMapper.readValue(jsonArray, PendingChallanList.class);
        System.out.print(pendingChallanList.getPendingChallanList().toString());
    }

}
