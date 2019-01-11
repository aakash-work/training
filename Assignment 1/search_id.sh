#Using 18 as default if parameter not passed
if [ $# -eq 0 ]
  then
    echo "No arguments provided"
    age=18
    output="output.txt"
   else
    echo "The age chosen is $1"
fi

age=$1
output=$2
sudo mysql -u root session -e "set @age=$age;source assignment_sql.sql;"  > $output

