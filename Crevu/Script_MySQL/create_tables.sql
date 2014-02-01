CREATE TABLE welcome_user
(
id INT NOT NULL AUTO_INCREMENT,
nickname VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL,
message VARCHAR(4000),
date_create DATE,
PRIMARY KEY(id)
) ENGINE=InnoDB;


CREATE TABLE user
(

id INT NOT NULL AUTO_INCREMENT,
username VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL,
password VARCHAR(256) NOT NULL,
first_name VARCHAR(100),
last_name VARCHAR(100),
gender CHAR,
birth_date DATE,
city VARCHAR(200),
nationality VARCHAR(50) NOT NULL,
fiscal_code VARCHAR(100),
is_company TINYINT(1) NOT NULL DEFAULT 0,
user_type VARCHAR(30) NOT NULL,
bird_level VARCHAR(50) NOT NULL DEFAULT 'PLUME',
user_level VARCHAR(50) NOT NULL DEFAULT 'BRONZE',
date_create DATE,
date_change DATE,
cookie_secret VARCHAR(256),
UNIQUE(email),
UNIQUE(username),
PRIMARY KEY(id)
) ENGINE=InnoDB;

CREATE TABLE notification
(
id INT NOT NULL AUTO_INCREMENT,
id_user INT NOT NULL,
text VARCHAR(100) NOT NULL,
delivered TINYINT(1) NOT NULL DEFAULT 0,
date_create DATE,
PRIMARY KEY(id,date_create)
) ENGINE=InnoDB PARTITION BY HASH(MONTH(date_create)) PARTITIONS 24;

CREATE TABLE social_account
(
id INT NOT NULL AUTO_INCREMENT,
id_user INT NOT NULL,
account_type VARCHAR(50) NOT NULL,
social_id VARCHAR(100),
social_password VARCHAR(100),
date_create DATE,
date_change DATE,
access_token_value VARCHAR(500),
access_token_secret VARCHAR(500),
PRIMARY KEY(id)
) ENGINE=InnoDB;

CREATE TABLE address
(
id INT NOT NULL AUTO_INCREMENT,
id_user INT NOT NULL,
street VARCHAR(200) NOT NULL,
city VARCHAR(200) NOT NULL,
country VARCHAR(100) NOT NULL,
state VARCHAR(100),
zip_code VARCHAR(100) NOT NULL,
phone_number VARCHAR(100),
cell_number VARCHAR(100),
address_email VARCHAR(100),
delivery_address TINYINT(1) NOT NULL DEFAULT 0,
predef_delivery_address TINYINT(1) NOT NULL DEFAULT 0,
date_create DATE,
date_change DATE,
PRIMARY KEY(id)
) ENGINE=InnoDB;

CREATE TABLE payment_data
(
id_user INT NOT NULL,
payment_type VARCHAR(100) NOT NULL,
payment_email VARCHAR(100),
payment_password VARCHAR(100),
credit_card_number VARCHAR(100),
credit_card_type VARCHAR(100),
cvv2 CHAR(3),
expriry DATE,
date_create DATE,
date_change DATE,
PRIMARY KEY(id_user)
) ENGINE=InnoDB;

CREATE TABLE text
(
id INT NOT NULL AUTO_INCREMENT,
body VARCHAR(100) NOT NULL,
source VARCHAR(100) NOT NULL,
votes INT DEFAULT 0,
bad TINYINT(1) NOT NULL DEFAULT 0,
date_create DATE,
date_change DATE,PRIMARY KEY(id,date_create))  
ENGINE=InnoDB PARTITION BY HASH(MONTH(date_create)) PARTITIONS 24;

CREATE TABLE text_wish
(
id INT NOT NULL AUTO_INCREMENT,
id_user INT NOT NULL,
id_text INT NOT NULL,
date_create DATE,
PRIMARY KEY(id)
) ENGINE=InnoDB;

CREATE TABLE tshirt_proposal
(
id INT NOT NULL AUTO_INCREMENT,
id_user INT NOT NULL,
id_text INT NOT NULL,
name VARCHAR(100),
color VARCHAR(100),
price FLOAT,
approved TINYINT(1) NOT NULL DEFAULT 0,
votes INT NOT NULL DEFAULT 0,
likes INT NOT NULL DEFAULT 0,
retweets INT NOT NULL DEFAULT 0,
brand VARCHAR(100),
active TINYINT(1) NOT NULL,
date_create DATE,
date_change DATE,
personal_rank INTEGER,
PRIMARY KEY(id,date_create)
)  ENGINE=InnoDB PARTITION BY HASH(MONTH(date_create)) PARTITIONS 24;

CREATE TABLE sold_tshirt
(
id INT NOT NULL AUTO_INCREMENT,
id_buyer INT NOT NULL,
id_seller INT NOT NULL,
id_tshirt_proposal INT NOT NULL,
date_create DATE,
PRIMARY KEY(id,date_create)
)  ENGINE=InnoDB PARTITION BY HASH(MONTH(date_create)) PARTITIONS 24;

CREATE TABLE order_deal
(
id INT NOT NULL AUTO_INCREMENT,
order_status CHAR NOT NULL,
id_supplier_order INT,
dispatch_reference VARCHAR(100),
status CHAR NOT NULL,
date_create DATE,
date_change DATE,PRIMARY KEY(id,date_create)
)  ENGINE=InnoDB PARTITION BY HASH(MONTH(date_create)) PARTITIONS 24;



CREATE TABLE ordered_tshirt
(
id_order_deal INT NOT NULL,
id_sold_tshirt INT NOT NULL,
date_create DATE
,PRIMARY KEY(date_create))  ENGINE=InnoDB PARTITION BY HASH(MONTH(date_create)) PARTITIONS 24;


CREATE TABLE payment
(
id_order_deal INT NOT NULL,
payment_type VARCHAR(100) NOT NULL,
payment_email VARCHAR(100),
payment_password VARCHAR(100),
credit_card_number VARCHAR(100),
credit_card_type VARCHAR(100),
cvv2 CHAR(3),
expriry DATE,
date_create DATE
,PRIMARY KEY(date_create)
)  ENGINE=InnoDB PARTITION BY HASH(MONTH(date_create)) PARTITIONS 24;



CREATE TABLE warehouse
(
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(100) NOT NULL,
place VARCHAR(200) NOT NULL,
description VARCHAR(500) NOT NULL,
email VARCHAR(100) NOT NULL,
address VARCHAR(200) NOT NULL,
phone_number_one VARCHAR(100) NOT NULL,
phone_number_two VARCHAR(100),
date_create DATE,
date_change DATE,PRIMARY KEY(id)
) ENGINE=InnoDB;

CREATE TABLE supplier_order
(
id INT NOT NULL AUTO_INCREMENT,
id_order_deal INT NOT NULL,
id_warehouse INT NOT NULL,
status CHAR NOT NULL,
tshirt_number INT NOT NULL,
attachment_name VARCHAR(100) NOT NULL,
date_create DATE,
date_change DATE,
PRIMARY KEY(id,date_create)
)  ENGINE=InnoDB PARTITION BY HASH(MONTH(date_create)) PARTITIONS 24;

CREATE TABLE transaction
(
id INT NOT NULL AUTO_INCREMENT,
id_warehouse INT NOT NULL,
id_supplier_order INT NOT NULL,
amount FLOAT NOT NULL,
status CHAR NOT NULL,
date_create DATE,
date_change DATE,
PRIMARY KEY(id,date_create)
)  ENGINE=InnoDB PARTITION BY HASH(MONTH(date_create)) PARTITIONS 24;

CREATE TABLE revenue
(
id_user INT NOT NULL,
id_sold_tshirt INT NOT NULL,
revenue FLOAT NOT NULL DEFAULT 0,
paid FLOAT NOT NULL DEFAULT 0,
date_create DATE,PRIMARY KEY(id_user)
)  ENGINE=InnoDB ;



CREATE TABLE basket_item
(
id INT NOT NULL AUTO_INCREMENT,
id_user INT NOT NULL,
id_tshirt_proposal INT NOT NULL,
delivered TINYINT(1) NOT NULL DEFAULT 0,
date_create DATE,PRIMARY KEY(id)
) ENGINE=InnoDB;


CREATE TABLE category
(
id INT NOT NULL AUTO_INCREMENT,category_name VARCHAR(50) NOT NULL, 
date_create DATE, 
UNIQUE(category_name),PRIMARY KEY(id)
) ENGINE=InnoDB;



CREATE TABLE tshirt_category
(
id INT NOT NULL AUTO_INCREMENT,
id_category INT NOT NULL,
id_tshirt_proposal INT NOT NULL,
date_create DATE,PRIMARY KEY(id))  ENGINE=InnoDB;



CREATE TABLE wishlist_item
(
id INT NOT NULL AUTO_INCREMENT,
id_user INT NOT NULL,
id_tshirt_proposal INT NOT NULL,
date_create DATE,PRIMARY KEY(id)
) ENGINE=InnoDB;


CREATE TABLE tshirt_comment
(
id INT NOT NULL AUTO_INCREMENT,
id_tshirt_proposal INT NOT NULL,
author INT NOT NULL,
date_create DATE,
PRIMARY KEY(id)
) ENGINE=InnoDB;

CREATE TABLE user_tshirt_ranking
(
id_user INT NOT NULL,
id_tshirt INT NOT NULL,
position INT NOT NULL,
date_ranking DATE
) ENGINE=InnoDB;

CREATE TABLE user_communication
(
id INT NOT NULL AUTO_INCREMENT,
id_user INT NOT NULL,
message VARCHAR(4000),
date_ranking DATE,
PRIMARY KEY(id)
) ENGINE=InnoDB;

CREATE TABLE event
(
) ENGINE=InnoDB;