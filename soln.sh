#!/bin/bash
echo 'Enter required age'
read input
mysql -u root -p -e"
USE db2
create table if not exists voters (id int(11) ,email varchar(100)) ;
insert into voters select id,email from authors where DATEDIFF(sysdate(),birthdate)/365 >$input and id not in (select voters.id from voters);
select * from voters;" >output.txt
