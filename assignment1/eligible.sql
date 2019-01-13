#
# Table structure for valid_auth
#
CREATE TABLE IF NOT EXISTS valid_auth(
	id int(11) NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (id)

);

SELECT id,email FROM authors where (year(curdate())-year(birthdate)>@age) and id not in (select id from valid_auth);

INSERT INTO valid_auth
SELECT id FROM authors where (year(curdate())-year(birthdate)>@age) and id not in (select id from valid_auth);
