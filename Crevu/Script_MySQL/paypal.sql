DROP TABLE payment_data;

CREATE TABLE payment_data
(
id INT NOT NULL AUTO INCREMENT,
payment_type VARCHAR(50),
payment_date VARCHAR(50),
payment_status VARCHAR(50) NOT NULL,
address_status VARCHAR(50),
payer_status VARCHAR(50),
payer_email VARCHAR(100),
payer_id VARCHAR(50),
address_name VARCHAR(100),
address_country VARCHAR(100),
address_country_code VARCHAR(10),
address_zip VARCHAR(10),
address_state VARCHAR(10),
address_city VARCHAR(50),
address_street VARCHAR(100),
receiver_email VARCHAR(100),
receiver_id VARCHAR(100),
residence_country VARCHAR(50),
item_name VARCHAR(100),
item_number VARCHAR(10) NOT NULL,
quantity INT NOT NULL,
shipping FLOAT,
tax FLOAT,
TXN_TYPE varchar(50),
txn_id VARCHAR(50),
notify_version VARCHAR(10),
date_create DATE,
PRIMARY KEY(id)
) ENGINE=InnoDB;