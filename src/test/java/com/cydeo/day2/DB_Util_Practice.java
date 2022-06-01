package com.cydeo.day2;

import com.cydeo.utility.DB_Util;

public class DB_Util_Practice {

    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@54.147.20.88:1521:XE";
        String username = "hr";
        String password = "hr";

        // This will create connection and save the connection to static variable of utility
        DB_Util.createConnection(url, username, password);
        // This will execute query and save the query result to static variable of utility
        DB_Util.runQuery("SELECT * FROM COUNTRIES");

        // This will print out every cell in the results
        DB_Util.displayAllData();

        // Get 2nd column from 2nd row
        System.out.println("DB_Util.getCellValue(2,2) = "
                + DB_Util.getCellValue(2, 2));

        // get the Country_Name from 2nd row
        System.out.println("DB_Util.getCellValue(2, \"COUNTRY_NAME\") = "
                + DB_Util.getCellValue(2, "COUNTRY_NAME"));

        // run different query here: SELECT * FROM REGIONS;
        // DB_Util.runQuery(" SELECT * FROM REGIONS");

        // get row count
        System.out.println("DB_Util.getRowCount() = " + DB_Util.getRowCount());

        // get column count
        System.out.println("DB_Util.getColumnCount() = " + DB_Util.getColumnCount());

        // get all column names as list
        System.out.println("DB_Util.getAllColumnNamesAsList() = "
                + DB_Util.getAllColumnNamesAsList());

        // get entire 3rd row as list
        System.out.println("DB_Util.getRowDataAsList(3) = "
                + DB_Util.getRowDataAsList(3) );

        // get the entire 2nd column as list of string
        System.out.println("DB_Util.getColumnDataAsList(2) = "
                + DB_Util.getColumnDataAsList(2));

        // get the COUNTRY_NAME column as list of string
        System.out.println("DB_Util.getColumnDataAsList(\"COUNTRY_NAME\") = "
                + DB_Util.getColumnDataAsList("COUNTRY_NAME"));

        // get 2nd row as MAP<String, String>
        System.out.println("DB_Util.getRowMap(2) = "
                + DB_Util.getRowMap(2));

        // get all rows as list of Map
        System.out.println("DB_Util.getAllRowAsListOfMap() = "
                + DB_Util.getAllRowAsListOfMap());

        // run this query and get the only cell in the result
        // SELECT COUNT(*) COUNT FROM EMPLOYEES
        DB_Util.runQuery("SELECT COUNT(*) COUNT FROM EMPLOYEES");
        System.out.println("DB_Util.getFirstRowFirstColumn() = "
                + DB_Util.getFirstRowFirstColumn());


        // This will clean up ResultSet, Statement, Connection object resources just like you did with File
        DB_Util.destroy();

    }

}
