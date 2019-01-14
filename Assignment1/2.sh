#!/bin/bash
echo "enter age"
read n
mysql -u root -p -e"
use assign
#select id from authors where TIMESTAMPDIFF(YEAR,birthdate,CURDATE())>$n;
create table if not exists middle as select id from authors where TIMESTAMPDIFF(YEAR,birthdate,CURDATE())>$n;

select * from authors where id NOT IN (select middle.id from middle);"> output.txt;

