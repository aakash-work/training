create table if not exists `existing_users` (
	`id` int(11) NOT NULL,
	primary key(`id`)
);

drop table if exists result_dump;

create table result_dump (
	id int(11) NOT NULL,
	primary key(id)
);

insert into session.result_dump select a.id from session.authors a where YEAR(CURDATE()) -YEAR(a. birthdate) >= @age;

delete from session.result_dump where id in (select u.id from session.existing_users u);

insert into session.existing_users select id from session.result_dump;


select a.id, a.email from session.authors a where a.id in (select u.id from session.existing_users u);

drop table result_dump;
