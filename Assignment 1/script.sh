#!/bin/bash
read input
output=$(sudo mysql session <<EOF
use session;
select id,email from authors where abs(datediff(birthdate,curdate())/365.25) >= "$input" and added > (select previousCheck from timeTab);
delete from timeTab;
insert into timeTab values(current_timestamp());
exit
EOF
)
echo "$output" >> Results