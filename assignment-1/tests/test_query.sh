#!/bin/bash
cd ..
sudo mysql -u root -e "use session; drop table if exists last;"
echo "Initial Querying.."
bash query.sh 18
sleep 2
echo "Inserting new row.."
sudo mysql -u root -e "use session; source tests/test.sql;"
echo "Querying after insert.."
bash query.sh 18
cd tests
