CREATE TABLE Employee (
    empID int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    designation varchar(255) NOT NULL,
    department varchar(50) NOT NULL,
    salary varchar(50) NOT NULL,
    PRIMARY KEY (empID)
);

CREATE TABLE Address(
	empID int NOT NULL,
	street varchar(255) NOT NULL,
	city varchar(255) NOT NULL,
	state varchar(255) NOT NULL,
	country varchar(255) NOT NULL,
	FOREIGN KEY (empID) REFERENCES Employee(empID),
	PRIMARY KEY(empID) 
);

CREATE TABLE Vehicle(
	empID int NOT NULL,
	regNumber varchar(11) NOT NULL,
	type varchar(20) NOT NULL,
	FOREIGN KEY (empID) REFERENCES Employee(empID),
	PRIMARY KEY(empID)
);

CREATE TABLE Contact(
	empID int NOT NULL,
	phNo int(10) NOT NULL,
	FOREIGN KEY (empID) REFERENCES Employee(empID),
	PRIMARY KEY(phNo)
);
