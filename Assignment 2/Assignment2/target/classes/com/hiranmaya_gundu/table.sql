CREATE TABLE Employee(
  id int NOT NULL PRIMARY KEY,
  name varchar(120) NOT NULL,
  designation varchar(50) NOT NULL,
  department varchar(50),
  compensation int NOT NULL 
);

CREATE TABLE Address(
  id int NOT NULL,
  street varchar(120),
  city varchar(50),
  state varchar(50),
  country varchar(50),
  FOREIGN KEY (id) REFERENCES Employee(id) ON DELETE CASCADE
);

CREATE TABLE Vehicle(
  id int NOT NULL,
  reg_no varchar(11),
  type varchar(20),
  FOREIGN KEY (id) REFERENCES Employee(id) ON DELETE CASCADE
);

CREATE TABLE Contact(
  id int NOT NULL,
  no int(10),
  FOREIGN KEY (id) REFERENCES Employee(id) ON DELETE CASCADE,
  PRIMARY KEY(id,no)
);
