DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
customer_id int not null primary key auto_increment,
customer_name varchar(30) not null,
account_number long not null,
account_balance long not null,
loan_amount long not null
);