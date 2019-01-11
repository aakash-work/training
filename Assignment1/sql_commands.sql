
CREATE TABLE IF NOT EXISTS ALREADY_COMPLETED
(`id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
);


SELECT id , first_name , last_name , email 
FROM authors 
WHERE CAST(DATEDIFF(CURDATE(),birthdate)/365 AS int) > 20
AND id not in (SELECT id from ALREADY_COMPLETED);




INSERT INTO ALREADY_COMPLETED SELECT id   
FROM authors 
WHERE CAST(DATEDIFF(CURDATE(),birthdate)/365 AS int) > 20
AND id not in (SELECT id from ALREADY_COMPLETED);
