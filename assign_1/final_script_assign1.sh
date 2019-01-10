#!/bin/sh

read age
sudo mysql -u root -e "set @age=${age};source assgn_script_2.sql;" session > "output_dump.txt";
