DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS status;

CREATE TABLE status (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  status_name VARCHAR(250) NOT NULL,
);

INSERT INTO status (status_name) VALUES
  ('NEW'),
  ('ACTIVE'),
  ('INACTIVE');

CREATE TABLE customer (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL,
  CONSTRAINT FK_customer_status foreign key (status_id) references status(id)
);



INSERT INTO customer (first_name, last_name, email) VALUES
  ('Shanvi', 'Ch', 'shanvi@ch.com'),
  ('Kritk', 'Ch', 'kritk@ch.com'),
  ('Ram', 'Ch', 'ram@ch.com');

