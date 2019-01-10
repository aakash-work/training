
echo "Enter age"
read age
echo "Enter file name"
read out

sudo mysql -u root session < sql_script.sql
sudo mysql -u root -e "set @age=${age};source eligible.sql;" session > ${out}
