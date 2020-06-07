DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS status;

CREATE TABLE status (
  id INT PRIMARY KEY,
  status_name VARCHAR(250) NOT NULL
);

CREATE TABLE c_order (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  order_date TIMESTAMP NOT NULL,
  customer_id INT NOT NULL,
  priority BOOLEAN DEFAULT FALSE,
  status_id INT,
  CONSTRAINT FK_order_status_status foreign key (status_id) references status(id)
);


INSERT INTO status (id, status_name) VALUES
  (1, 'NEW'),
  (2, 'ACTIVE'),
  (3, 'INACTIVE');

CREATE TABLE customer (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL,
  status_id INT,
  CONSTRAINT FK_customer_status foreign key (status_id) references status(id)
);



INSERT INTO customer (first_name, last_name, email, status_id) VALUES
  ('Shan', 'Ch', 'shan@ch.com', 1),
  ('Krit', 'Ch', 'krit@ch.com', 1),
  ('Lav', 'Ch', 'lav@ch.com', 1),
  ('Ram', 'Ch', 'ram@ch.com', 1);

