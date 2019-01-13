DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  empId int(11) not null AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  designation varchar(20) NOT NULL,
  department varchar(50) NOT NULL,
  compensation int(11) NOT NULL,
  PRIMARY KEY (empId)
);

DROP TABLE IF EXISTS address;
CREATE TABLE address(
    empId int(11) NOT NULL,
    houseNo varchar(20) not null,
    street varchar(20) not null,
    city varchar(20) not null,
    country varchar(20) not null,
    primary key(empId),
    foreign key (empId) references employee(empId)

);

DROP TABLE IF EXISTS vehicle;
CREATE TABLE vehicle(
    empId int(11) NOT NULL,
    regNo varchar(20) not null,
    type varchar(20) not null,
    primary key(empId),
    foreign key (empId) references employee(empId)

);

DROP TABLE IF EXISTS contact;
CREATE TABLE contact(
    empId int(11) NOT NULL,
    phoneNo int(11) NOT NULL,
    primary key(phoneNo),
    foreign key (empId) references employee(empId)
);
