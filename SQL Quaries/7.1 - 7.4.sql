use Inventory_Module;

select CONCAT(name, ' - ', phone) 'Name with Phone',
	LEFT(name, 3) 'Name Starts', 
	RIGHT(name, 3) 'Name Ends', 
	UPPER(name) 'Name In Upper', 
	LOWER(name) 'Name In Lower', 
	LTRIM('     '+name+'      ') 'Left Trim',
	RTRIM('     '+name+'      ') 'Right Trim',
    REPLACE(name, 'a', '@') 'Replace a -> @',
	REPLICATE(name, 3) 'Repeate Name',
	REVERSE(name) 'Reverse Name',
    SUBSTRING(name, 2, 4) 'Name Substring',
	CHARINDEX('t', 'Customer') 'Finding CharIndex',
	STUFF(name, 1, 0, 'Mr. ') 'Adding Mr.',
	TRIM('     '+name+'      ') 'Trimed Name',
	CONCAT_WS(' - ', name, phone, email) 'Customer Details',
    CHAR(66) '66'
from Customers


SELECT ABS(-10), ROUND(15.49, 0), CEILING(13.21), FLOOR(17.89), SQRT(25), POWER(2, 3);
SELECT EXP(2), LOG(10), LOG10(100), RAND(), PI(), SIN(1), SQUARE(64);
SELECT SUM(price) from  Products;
SELECT MAX(price) from  Products;

SELECT SUM(12);
SELECT MAX(34);

SELECT CAST('2017-08-25' AS datetime);


SELECT GETDATE(), SYSDATETIME(), DATEADD(MONTH, 3, GETDATE()), DATEDIFF(DAY, '2022-01-01', '2022-02-01'), DATEPART(YEAR, '2022-01-15');
SELECT CONVERT(VARCHAR, GETDATE(), 120), FORMAT(GETDATE(), 'yyyy-MM-dd HH:mm:ss'), MONTH('2022-04-15'), YEAR('2022-04-15'), EOMONTH('2022-04-15');


SELECT CAST('2024-01-22 05:31:00' AS datetime), CONVERT(int, 25.65), ISNUMERIC(4567), SYSTEM_USER, USER_NAME();

