#!/bin/bash
sudo mysql -u rati -proot  sample -e "set @age =18;set @var:=(select time from log);select * from authors where DATEDIFF(CURDATE(),birthdate)/365 <@age and added>@var;update log set time=now() where id =1;"
