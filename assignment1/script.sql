CREATE TABLE IF NOT EXISTS added(
  `eligible_id` int(11) ,
  `email_add` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`eligible_id`));

select id,email from authors where (year(curdate())-year(birthdate) > @age) and id not in (select eligible_id from added);


insert into added select id,email from authors where (year(curdate())-year(birthdate) >18) and id not in (select eligible_id from added);


