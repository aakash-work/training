#!/bin/bash 

ARGS=2
 
age=$1
output_file=$2 

echo $age
#run mysql query with paramenters 


sudo mysql -u root session  -e  "set @age=${age}; source sql_commands.sql;" > ${output_file}


exit

# end of script.
