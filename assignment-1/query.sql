create table if not exists last(id int NOT NULL PRIMARY KEY AUTO_INCREMENT, timestamp datetime NOT NULL);
select * from authors where round(datediff(now(), birthdate) / 365.25) > @age AND
added >  (select IFNULL (MAX(timestamp), 0) from last);
INSERT INTO last VALUES (NULL,now());