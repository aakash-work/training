#!/bin/bash
user="root"
dbname="Assignment"
password="password"


mysql -u root -p -e " use Assignment; create table if not exists newage(id int,email varchar(100)); select id,email from authors where DATEDIFF(CURDATE(),authors.birthdate)/365.25>=18 and not exists (select id from newage where authors.id=newage.id); insert into newage select id,email from authors where DATEDIFF(CURDATE(),authors.birthdate)/365.25>=18; "> /home/spoorthy.s/result.txt
