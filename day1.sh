#!/bin/bash
echo -n "enter valid age: "
read age
sudo mysql -e "use session; select id, email from authors where abs(datediff(birthdate,curdate())/365.25) >= "$age";" > answer.txt
uniq -u answer.txt;