DROP TABLE IF EXISTS Customer;
CREATE TABLE Customer AS SELECT  * FROM CSVREAD('classpath:tables/user_visa.csv');