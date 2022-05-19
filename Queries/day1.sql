-- This is how you write a single line comment in sql
/*
 This is how you write
 a multi-line comment in sql
 */
-- each query you write is known as a sql SELECT statement
-- * means all, here it means all the columns
-- from some table that exists in the database
-- just like java,
-- SQL Statements end in semi-colon ; MANDATORY
SELECT * FROM REGIONS ;
-- If you want to run your second statement
-- you need to click the query to focus on the cursor and click run
SELECT * FROM COUNTRIES ;

SELECT * FROM LOCATIONS ;

SELECT * FROM DEPARTMENTS ;

SELECT * FROM JOBS ;

SELECT * FROM JOB_HISTORY ;

SELECT * FROM EMPLOYEES ;


-- RESTRICTING COLUMNS IN THE RESULT
-- SQL IS SPACE INSENSITIVE
SELECT FIRST_NAME
FROM EMPLOYEES ;

-- More than one column can be specified seperated by comma ,
SELECT FIRST_NAME, LAST_NAME, EMAIL
FROM EMPLOYEES;

/*
TASK : SELECT SPECIFIC COLUMNS FROM OTHER TABLES TO GET YOURSELF FAMILIAR
 */

/*
 Only getting unique value from the result
 for example, only getting unique first name from employees table
 */

SELECT DISTINCT FIRST_NAME
FROM EMPLOYEES; -- 91 ROWS

--Get only unique last name

SELECT DISTINCT LAST_NAME
FROM EMPLOYEES; -- 102 ROWS

-- This is looking for people with unique first and last name, or full name
SELECT DISTINCT FIRST_NAME, LAST_NAME
FROM EMPLOYEES;

-- RESTRICTING COLUMNS IN THE RESULT USING WHERE CLAUSE

-- COMPARISON OPERATORS: =, >, >=, <, <=,!=, <>
-- LOGICAL OPERATORS: AND, OR

-- Display the employee information for the employee with first_name Ellen
-- In SQL We use single quote for String
SELECT * FROM EMPLOYEES
WHERE FIRST_NAME = 'Ellen'; -- Ellen != ellen != ELLEN, Value are CASE SENSITIVE

-- Display the employee FIRST_NAME, LAST_NAME, SALARY
-- for the employee with SALARY 11000
SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY = 11000;

-- Display the employee FIRST_NAME, LAST_NAME, SALARY
-- for the employee with SALARY 4800 and FIRST_NAME David

-- LOGICAL AND
SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE FIRST_NAME = 'David' AND SALARY = 4800;

-- Display the employee FIRST_NAME, LAST_NAME, SALARY
-- for the employee with SALARY 4800 OR FIRST_NAME David
SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE FIRST_NAME = 'David' OR SALARY = 4800;

-- Display the employees that make more than 5000 and less than 120000
SELECT * FROM EMPLOYEES
WHERE SALARY > 5000 AND SALARY < 12000; -- 49

-- RANGE CHECKING IS MUCH SIMPLER IN SQL USING
-- BETWEEN .... AND
-- IS THE SAME AS COLUMN_VALUE >= lowerbound and COLUMN_VALUE <+ upperbound
-- Above query can be much simpler and more readable as below
SELECT * FROM EMPLOYEES
    WHERE SALARY BETWEEN 5000 AND 12000;

-- Display the employees that have JOB_ID of
                                    -- AD_VP
                                    -- AD_ASST
                                    -- FI_ACCOUNT
                                    -- AC_ACCOUNT
SELECT FIRST_NAME, JOB_ID FROM EMPLOYEES
WHERE JOB_ID = 'AD_VP'
    OR JOB_ID = 'AD_ASST'
    OR JOB_ID = 'FI_ACCOUNT'
    OR JOB_ID = 'AC_ACCOUNT';

-- USING KEYWORD IN for multiple possible value of same column in condition
SELECT  FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE JOB_ID IN ('AD_VP', 'AD_ASST', 'FI_ACCOUNT', 'AC_ACCOUNT');

-- HOW TO SAY NOT IN SQL
-- for equality check != <> ,
    -- FIND OUT ALL REGIONS EXCEPT THE REGION WITH REGION_ID OF 1
SELECT * FROM REGIONS
WHERE REGION_ID <> 1;
-- could also use WHERE REGION_ID != 1;

-- FIND OUT ALL REGIONS EXCEPT THE REGION WITH REGION_NAME of Americas
SELECT * FROM REGIONS
WHERE REGION_NAME <> 'Americas';

-- for BETWEEN AND --> NOT BETWEEN .. AND

-- Display the employees that DOES NOT make more than 5000 and less than 120000
SELECT FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY NOT BETWEEN 5000 and 12000;

-- for IN --> NOT IN
-- Display the employees that have JOB_ID
-- IS NOT ONE OF THESE AD_VP, AD_ASST, FI_ACCOUNT, AC_ACCOUNT
SELECT FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE JOB_ID NOT IN ('AD_VP', 'AD_ASST', 'FI_ACCOUNT', 'AC_ACCOUNT');

-- HOW TO USE NULL IN CONDITION ?
-- FOR EXAMPLE: FIND OUT ALL DEPARTMENTS THAT DOES NOT HAVE MANAGER_ID
SELECT  * FROM DEPARTMENTS
WHERE MANAGER_ID IS NULL; -- 16 ROWS

-- FOR EXAMPLE: FIND OUT ALL DEPARTMENTS THAT HAS MANAGER_ID
SELECT  * FROM DEPARTMENTS
WHERE MANAGER_ID IS NOT NULL; -- 11 ROWS

-- SORTING THE RESULT IN ASCENDING (LOW TO HIGH)
-- OR DESCENDING ORDER (HIGH TO LOW)
-- ORDER BY Clause can be used to order the result of your query
-- It uses either column name or column index
-- It must be the last past of your statement
-- ASC for (LOW TO HIGH), DESC (HIGH TO LOW)

-- Display Employee FIRST-NAME and LAST_NAME and Salary
-- try to sort by below criteria separately
-- FIRST_NAME ASC
-- Salary DESC
-- LAST_NAME DESC
SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
-- ORDER BY FIRST_NAME;
ORDER BY SALARY DESC;
-- ORDER BY LAST_NAME DESC;
-- ORDER BY 1 DESC ; -- THIS MEANS SORT THE RESULT BY FIRST COLUMN
-- SQL INDEX START WITH 1 NOT 0 !!!!


-- WHAT ABOUT THE PARTIAL SEARCH
-- WE USE LIKE AND % (WILD CARD)
-- % can represent 0 or more characters of any kind
-- _ can represent exactly one character of any kind


-- DISPLAY ALL THE FIRST_NAME THAT STARTS WITH LETTER A IN EMPLOYEES TABLES
SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'A%'; -- 10 ROWS

-- DISPLAY ALL THE FIRST_NAME THAT ENDS WITH LETTER A IN EMPLOYEES TABLES
SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE '%a'; -- 16 ROWS

-- DISPLAY ALL THE FIRST_NAME THAT CONTAINS LETTER A IN EMPLOYEES TABLES
SELECT FIRST_NAME
FROM EMPLOYEES
WHERE FIRST_NAME LIKE '%a%'; -- 66 ROWS
