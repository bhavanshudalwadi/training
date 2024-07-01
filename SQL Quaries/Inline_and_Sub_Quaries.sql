use Inventory_Module;
-- Inline Quaries
select * from Products where cat_id in (select id from Categories)
select * from Transactions where product_id in (select id from Products)
select * from PurchaseDetails where transection_id in (select id from Transactions) and supplier_id in (select id from Suppliers)
-- Sub Quaries
select p.*, c.* from Products p join Categories c on c.id = p.cat_id
select t.*, t.* from Transactions t join Products p on p.id = t.product_id
select pd.*, t.*, s.* from PurchaseDetails pd join Transactions t on t.id = pd.transection_id join Suppliers s on s.id = pd.supplier_id where t.type = 'purchase'

use Library_Managment_System;
-- Inline Quaries
select * from books where cat_id in (select id from  categories) and author_id in (select id from authors)
select * from rents where book_id in (select id from books)
select * from waitlist where book_id in (select id from books) and user_id in (select id from users)
-- Sub Quaries
select * from books b join categories c on c.id = b.cat_id join authors a on a.id = b.author_id
select * from rents r join books b on b.id = r.book_id
select * from waitlist w join books b on b.id = w.book_id join users u on u.id = w.user_id


use Social_Media_APP_Facebook;
-- Inline Quaries
select * from posts where user_id in (select id from users)
select * from comments where post_id in (select id from posts)
select * from likes where post_id in (select id from posts) and user_id in (select id from users)
-- Sub Quaries
select * from posts p join users u on u.id = p.user_id
select * from comments c join posts p on p.id = c.post_id
select * from likes l join posts p on p.id = l.post_id join users u on u.id = l.user_id