#!/bin/bash
mysql -u $2 -p$3 session -e\
"set @age=$1; select @age; \
create temporary table over (first_name varchar(50), last_name varchar(50)); \
insert into over select first_name, last_name from authors where birthdate < date_add(curdate(), interval -@age year); \
create temporary table differ(first_name varchar(50), last_name varchar(50)); \
create table if not exists overage$1 (first_name varchar(50), last_name varchar(50)); \
insert into differ select over.first_name, over.last_name from over left join \
overage$1 on over.first_name = overage$1.first_name where overage$1.first_name is null; \
select * from differ; \
insert into overage$1 select * from differ;"
