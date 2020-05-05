drop table if exists customer_details;
create table customer_details (
  id integer PRIMARY KEY NOT NULL auto_increment,
  first_name varchar(30) NOT NULL,
  last_name varchar(30) NOT NULL,
  email varchar(200) NOT NULL,
  age smallint
);
