#Using 18 as default if parameter not passed
#!/bin/bash -x 
if [ $# -eq 0 ]
  then
    echo "No arguments provided"
    age=18
    output="output.txt"
   else
    echo "The age chosen is $1"
    age=$1
    output=$2
fi

sudo mysql -u root session -e "set @age=$age;source assignment_sql.sql;"  > $output

