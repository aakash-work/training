#/bin/bash

ARGS=2
age=$1
out=$2

sudo mysql -u root session < sql_script.sql

sudo mysql -u root -e "set @age=${age};source script.sql;" session > ${out}  
