#!/bin/bash

echo 'Executing default sql script....'

sudo mysql -u root session< ../sql_script.sql

echo 'Table Created Successfully!'

echo 'Enter required age'
read input

echo 'Searching Table...'

output=$(sudo mysql -u root session -e "set @age=$input; source execute.sql;"
)

echo 'Creating an output file...'

echo "$output" >> outputfile

echo 'A file named outputfile has been created!'

echo 'Done :)'


