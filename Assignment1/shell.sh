#!/bin/bash
read -p "Enter the value " age
echo "Age read"
mysql -u root -p -e"
use Author
SELECT * FROM authors WHERE TIMESTAMPDIFF(YEAR,birthdate,CURDATE()) > $age;

CREATE TABLE if not exists temp as SELECT id FROM authors WHERE TIMESTAMPDIFF(YEAR,birthdate,CURDATE()) > $age;


SELECT * FROM authors WHERE id NOT IN temp AND SELECT temp.id FROM temp;" > out.txt;
