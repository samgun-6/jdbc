CREATE TABLE webpage (ID SERIAL PRIMARY KEY, Url VARCHAR, Author INTEGER , Content VARCHAR, Popularity INTEGER, FOREIGN KEY (Author) REFERENCES tbl_user (ID));

/**
seeder.createWebPageTable(); creates a table called webpage with the fields ID, Url, Author
(a foreign key pointing to a user’s ID), Content, and Popularity. The ID should again be an autoincremented
primary key. Use appropriate data types based on the fake data (see next step).

 */