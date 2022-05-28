package com.cydeo.day1;

import java.sql.*;

public class LoopingThroughResultSet {

    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@54.147.20.88:1521:XE";
        String username = "hr";
        String password = "hr";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");

            // keep looping to next row until there is no more rows when rs.next() returns false
            // rs.next() move the pointer to next row
            // and returns true if there is valid next row and false if there is no valid row
            // this will print all 4 rows REGION_NAME
            while (rs.next()){

                System.out.println("rs.getString(\"REGION_NAME\") = "
                        + rs.getString("REGION_NAME"));
            }
            // where is your pointer right now?? -->> AfterLast Location
            // below line will return exception because we are at afterLast location
            // System.out.println("rs.getString(\"REGION_NAME\") = "
            //        + rs.getString("REGION_NAME"));
            rs.previous();


        } catch (SQLException e) {
            System.out.println("Exception occurred " + e.getMessage());
        }
    }
}
