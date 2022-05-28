package com.cydeo.day1;

import java.sql.*;

public class SimpleNavigation {

    public static void main(String[] args) throws SQLException {

        // Step 1: Create a Connection by providing Connection Information
        // This connection is jdbc url, also known as connection string
        // Syntax looks like this jdbc:DatabaseType:subprotocal:@Host:port:SID
        // PLEASE REPLACE THIS IP WITH YOUR OWN WORKING E2 SERVER IP!!
        String url = "jdbc:oracle:thin:@54.147.20.88:1521:XE";
        String username = "hr";
        String password = "hr";

        // now JDBC provides utility class called DriverManager with many methods
        // the getConnection method accepts 3 parameters url, username, and password
        // according to this info,
        // it will first look for the driver of the database type you are connecting to
        // once found, use the rest of the connection information such as
        // host ip, username, password, port, side to make the connection
        // MAKE SURE THE CONNECTION WORKS MANUALLY
        // ANYTHING THAT DOES NOT WORK MANUALLY WILL NOT WORK AUTOMATED

        Connection conn = DriverManager.getConnection(url, username, password);
        System.out.println("Successfully Connected");

        // Once we have the connection, now we use this connection object to create statement object
        Statement stmt = conn.createStatement();

        // Once we have statement object, now we can execute query to get ResultSet
        // ResultSet Object stores all row data
        // It uses the iterator to move through the row using cursor to hold position where it is currently at
        ResultSet rs = stmt.executeQuery("SELECT  * FROM REGIONS");
        // By default, the cursor(pointer) of the ResultSet object is at
        // a location known as BeforeFirst, basically right before the first row
        // in order to get to the first row, you need to call next() method
        // next method moves your pointer to next row
        // it will return tre if there is a valid next row
        // false if there is no more valid rows
        rs.next(); // now we are at the first row

        // The resulting data has two column REGION_ID, REGION_NAME
        // In order to access the cell value,
        // We can either getX (X here is the data type) method that accepts 1 parameter
        // either using column name or using 1 based index
        // getString, getInt, getDouble and so on... we will be using getString for now
        System.out.println("rs.getString(\"REGION_ID\") = "
                + rs.getString("REGION_ID"));
        System.out.println("rs.getString(\"REGION_NAME\") = "
                + rs.getString("REGION_NAME"));
        // you can also use column index
        System.out.println("rs.getString(1) = " + rs.getString(1));
        System.out.println("rs.getString(2) = " + rs.getString(2));

        // now we want to move to next row
        rs.next(); // now we are at 2nd row
        System.out.println("rs.getString(\"REGION_ID\") = "
                + rs.getString("REGION_ID"));
        System.out.println("rs.getString(\"REGION_NAME\") = "
                + rs.getString("REGION_NAME"));

        // now we want to move to next row
        rs.next(); // now we are at 3rd row
        System.out.println("rs.getString(\"REGION_ID\") = "
                + rs.getString("REGION_ID"));
        System.out.println("rs.getString(\"REGION_NAME\") = "
                + rs.getString("REGION_NAME"));

        // now we want to move to next row
        rs.next(); // now we are at 4th row
        System.out.println("rs.getString(\"REGION_ID\") = "
                + rs.getString("REGION_ID"));
        System.out.println("rs.getString(\"REGION_NAME\") = "
                + rs.getString("REGION_NAME"));

        //we Are currently at last row and rs.next will return false if called again
        System.out.println("rs.next() = " + rs.next());
        // now try to get the cell value ??
        // NO, WE ARE AT AFTER THE LAST ROW
        //System.out.println("rs.getString(\"REGION_NAME\") = "
        //      + rs.getString("REGION_NAME"));


    }
}
