package com.cydeo.day1;

import java.sql.*;

public class TestOracleConnection {

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
    }
}
