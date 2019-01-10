#create a table timeStmp with a column time as timestamp and add value '1970-01-01 10:10:10'

#!/bin/bash

read input
output=$(sudo mysql Test <<EOF
use Test
select id, email from authors where abs(datediff(birthdate,curdate())/365)>="$input" and added>(select * from timeStmp) ;
truncate timeStmp;
insert into timeStmp values(now());
EOF
)
echo "$output" >> outfile




