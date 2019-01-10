set @age = 40;
create temporary table over (first_name varchar(50), last_name varchar(50));
insert into over select first_name, last_name from authors where birthdate < date_add(curdate(), interval -@age year);
create temporary table differ(first_name varchar(50), last_name varchar(50));
insert into differ select over.first_name, over.last_name from over left join 
overage on over.first_name = overage.first_name where overage.first_name is null;
select * from differ;
insert into overage select * from differ

