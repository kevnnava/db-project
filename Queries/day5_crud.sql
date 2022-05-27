/**
  IntelliJ Comes with great visual feature to
  create tables and perform crud operation on that table
        -- C (Create new row)
        -- R (Read rows)
        -- U (Update rows)
        -- D (Delete rows)
  It will also help to generate the query needed to make it happen
  Here is the MESSAGE Table with 2 Columns (MESSAGE_ID, CONTENT) we did
 */
-- CREATING TABLE
CREATE TABLE MESSAGE
(
    MESSAGE_ID NUMBER       not null
        constraint MESSAGE_PK
            primary key,
    CONTENT    VARCHAR2(50) not null
);

-- ADDING ROW
INSERT INTO HR.MESSAGE (MESSAGE_ID, CONTENT)
VALUES (2, 'b25 like buttons');

INSERT INTO HR.MESSAGE (MESSAGE_ID, CONTENT)
VALUES (2, 'b25 like repeating');

COMMIT; -- THIS WILL SAVE CHANGES TO DATABASE

-- READING ROW
SELECT * FROM MESSAGE;

-- UPDATING MESSAGES
UPDATE MESSAGE
SET CONTENT = 'b25 likes LEARNING'
WHERE MESSAGE_ID = 2;

-- DELETING ROW
DELETE
FROM MESSAGE
WHERE MESSAGE_ID = 2;

-- HOW TO CLEAR EVERYTHING IN THE TABLE
-- TRUNCATE
TRUNCATE TABLE MESSAGE;
-- HOW TO MODIFY THE TABLE -- SUCH AS ADDING COLUMN
ALTER TABLE MESSAGE
ADD SCORE INTEGER;
-- HOW TO COMPLETELY DELETE A TABLE
DROP TABLE MESSAGE;