#!/bin/bash

#create another table table 2 with same costraints
echo "enter the age"
read age
sudo mysql sql_assign <<EOF

create view author3 as 
select * from authors
where id is null;


create OR REPLACE view author4 as
select * from authors
where abs(datediff(birthdate,curdate())/365.25)> 18 and NOT EXISTS (select * from author3 WHERE author3.id=authors.id);
select * from author4;

create or replace view author3 as
select * from authors;


EOF



