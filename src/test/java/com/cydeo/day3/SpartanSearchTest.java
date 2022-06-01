package com.cydeo.day3;

import com.cydeo.utility.DB_Util;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * BackgroundL on Spartan UI All Data page,
 * Search functionality has been acting yp
 * and it does not always return correct result count
 * You opened the defect, it has been fixed
 * and yet it occasionally comes back again
 * Now you are writing automated test to make sure
 * it works at all time
 *  few scenarios you can come up with
 *  search by gender would work
 *  search by partial name should work
 *  search by partial name + gender should work
 */

public class SpartanSearchTest {

    @BeforeClass
    public void setup(){
        // create connection ONLY ONCE! for all tests in this class
        String url = "jdbc:oracle:thin:@54.147.20.88:1521:XE";
        String username = "SP";
        String password = "SP";

        DB_Util.createConnection(url, username, password);
    }

    @AfterClass
    public void teardown(){
        // tear down the connection only once after all the tests in this class
        DB_Util.destroy();
    }

    @Test
    public void testSearchByGender(){

        // Assuming you already used your webdriver knowledge
        // to get actual result from that total count
        // or by counting the web table row and get the result below
        int actualResultMale = 53;
        int actualResultFemale = 47;

        // now get the expected result from Database query
        // For Male  : SELECT COUNT(*) AS COUNT FROM SPARTANS WHERE GENDER = 'Male'
        // For Female: SELECT COUNT(*) AS COUNT FROM SPARTANS WHERE GENDER = 'Female'


        DB_Util.runQuery("SELECT COUNT(*) AS COUNT FROM SPARTANS WHERE GENDER = 'Male'");
        int expectedMaleResult = Integer.parseInt( DB_Util.getFirstRowFirstColumn() );

        //  assert
        assertEquals(actualResultMale, expectedMaleResult);

        DB_Util.runQuery("SELECT COUNT(*) AS COUNT FROM SPARTANS WHERE GENDER = 'Female'");
        int expectedFemaleResult = Integer.parseInt( DB_Util.getFirstRowFirstColumn() );
        // assert
        assertEquals(actualResultFemale, expectedFemaleResult);

    }

    @Test
    public void testSearchByPartialName(){
        // search by name contains a and has 57 results on UI
        // we want to make sure this matches the database query result below
        // SELECT COUNT(*) FROM SPARTANS WHERE LOWER(NAME) LIKE '%a%'

        int actualResultFromUI = 62;

        DB_Util.runQuery("SELECT COUNT(*) FROM SPARTANS WHERE LOWER(NAME) LIKE '%a%'");
        int expectedResultFromDB = Integer.parseInt(DB_Util.getFirstRowFirstColumn());

        // assert
        assertEquals(actualResultFromUI, expectedResultFromDB);

    }


}
