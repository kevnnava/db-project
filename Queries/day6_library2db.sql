# USE LOWERCASE FOR TABLE NAME
-- THIS PARTICULAR DATABASE IS CONFIGURED TO ONLY USE LOWERCASE FOR TABLE NAME
SELECT COUNT(*) FROM books;

SELECT COUNT(*) FROM users;

-- Display the book name and book category name
-- books, book_categories tables are related by book_category_id
-- this is full table name version
SELECT books.name, book_categories.name
FROM books
         INNER JOIN book_categories ON books.book_category_id = book_categories.id;
-- below is the alias version
SELECT *
FROM books b
         INNER JOIN book_categories bc ON b.book_category_id = bc.id

