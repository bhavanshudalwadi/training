use Inventory_Module;

-- String Functions:

-- String Concatenation:
SELECT name + ' (' + CONVERT(NVARCHAR, id) + ')' AS ConcatenatedName FROM Categories;
-- Substring:
SELECT SUBSTRING(description, 1, 50) AS ShortenedDescription FROM Categories;
-- String Length:
SELECT name, LEN(name) AS NameLength FROM Products;



-- Math Functions:

-- Addition:
SELECT price, in_stock, price + in_stock AS TotalValue FROM Products;
-- Rounding:
SELECT name, ROUND(price, 2) AS RoundedPrice FROM Products;
-- Random Number:
SELECT name, RAND() AS RandomNumber FROM Products;



-- Date Functions:
-- Current Date and Time:
SELECT name, GETDATE() AS CurrentDateTime FROM Customers;
-- Date Difference:
SELECT id, DATEDIFF(DAY, date, GETDATE()) AS DaysSinceTransaction FROM Transactions;
-- End of Month:
SELECT name, EOMONTH(dt) AS EndOfMonth FROM Categories;



-- Advanced Types:
-- Type Conversion:
SELECT name, CAST(price AS INT) AS PriceAsInteger FROM Products;
-- NULLIF - Handling NULL Values:
SELECT name, NULLIF(price, 0) AS PriceOrNull FROM Products;
-- COALESCE - Handling NULL Values:
SELECT name, COALESCE(price, 0) AS PriceOrDefault FROM Products;





use Library_Managment_System;

-- String Functions:-
-- String Concatenation:
SELECT name + ' (' + CONVERT(NVARCHAR, id) + ')' AS ConcatenatedName FROM categories;
-- Substring:
SELECT SUBSTRING(description, 1, 50) AS ShortenedDescription FROM books;
-- String Length:
SELECT name, LEN(name) AS NameLength FROM authors;


-- Math Functions:-
-- Addition:
SELECT id, cat_id, id + cat_id AS TotalIdCatId FROM books;
-- Rounding:
SELECT id, ROUND(id/2, 0) AS RoundedHalfId FROM authors;
-- Random Number:
SELECT RAND() AS RandomNumber FROM books;


-- Date Functions:-
-- Current Date and Time:
SELECT name, GETDATE() AS CurrentDateTime FROM users;
-- Date Difference:
SELECT id, DATEDIFF(DAY, start_time, end_time) AS DurationInDays FROM rents;
-- End of Month:
SELECT EOMONTH(req_date) AS EndOfMonth FROM waitlist;


-- Advanced Types:-
-- Type Conversion:
SELECT name, CAST(id AS NVARCHAR) AS IdAsString FROM categories;
-- NULLIF - Handling NULL Values:
SELECT email, NULLIF(email, '') AS NonEmptyEmail FROM users;
-- COALESCE - Handling NULL Values:
SELECT title, COALESCE(description, 'No description') AS BookDescription FROM books;


use Social_Media_APP_Facebook;

-- String Functions:-
-- String Concatenation:
SELECT username + ' - ' + name AS UserInfo FROM users;
-- Substring:
SELECT SUBSTRING(content, 1, 50) AS ShortenedContent FROM posts;
-- String Length:
SELECT email, LEN(email) AS EmailLength FROM users;


-- Math Functions:-
-- Addition:
SELECT id, user_id, id + user_id AS TotalIdUserId FROM posts;
-- Rounding:
SELECT id, ROUND(id/2.0, 0) AS RoundedHalfId FROM likes;
-- Random Number:
SELECT id, RAND() AS RandomNumber FROM friendships;


-- Date Functions:
-- Current Date and Time:
SELECT username, GETDATE() AS CurrentDateTime FROM users;
-- Date Difference:
SELECT id, DATEDIFF(DAY, like_dt, GETDATE()) AS DaysSinceLike FROM likes;
-- End of Month:
SELECT username, EOMONTH(reg_dt) AS EndOfMonth FROM users;


-- Advanced Types:-
-- Type Conversion:
SELECT username, CAST(id AS NVARCHAR) AS IdAsString FROM users;
-- NULLIF - Handling NULL Values:
SELECT email, NULLIF(name, '') AS NonEmptyName FROM users;
-- COALESCE - Handling NULL Values:
SELECT content, COALESCE(post_visibility, 0) AS PostVisibilityOrDefault FROM posts;