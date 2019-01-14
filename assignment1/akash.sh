
#!/bin/bash
user="root"
dbname="test"
password="password"
a=0
if [ $a -eq 0 ]
then 
 	mysql -u$user -D$dbname -p$password -e "select id,email from authors where DATEDIFF(CURDATE(),authors.birthdate)/365.25>=18"> /home/akash.kumar/a.txt 
 	a=a+1;
fi
mysql -u$user -D$dbname -p$password -e "create table if not exists newta as select id,email from authors where DATEDIFF(CURDATE(),authors.birthdate)/365.25>=18; select id,email from authors where DATEDIFF(CURDATE(),authors.birthdate)/365.25>=16 and not exists (select id from newta where authors.id=newta.id); "> /home/akash.kumar/a.txt



