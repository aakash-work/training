#!/bin/bash
sudo mysql -u root -e "set @age=$1; use session; source query.sql;"
