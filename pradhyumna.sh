#!/bin/bash

echo 'Enter required age'
read input

echo 'Enter Database name'
read db

mysql -u root -p -e"
USE $db;
CREATE TABLE IF NOT EXISTS \`voters\` (
  \`id\` int(11) NOT NULL AUTO_INCREMENT,
  \`email\` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (\`id\`)
);

INSERT INTO voters  
   (id,email)  
SELECT id,email 
FROM authors 
WHERE DATEDIFF(CURDATE(),birthdate)/365.25>=$input and authors.id NOT IN (select id from voters);
 

DROP TABLE IF EXISTS \`newvoters\`;

CREATE TABLE \`newvoters\` (
  \`id\` int(11) NOT NULL AUTO_INCREMENT,
  \`email\` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (\`id\`)
);

INSERT INTO newvoters  
   (id,email)
SELECT id,email 
FROM authors 
WHERE DATEDIFF(CURDATE(),birthdate)/365.25>=$input; 

INSERT INTO voters  
   (id,email)
SELECT id,email 
FROM newvoters;

select * from newvoters;" >a.txt
