
CREATE TABLE IF NOT EXISTS completed(
    `id` int(11) NOT NULL,
    PRIMARY KEY (`id`)
);

SELECT id, email, abs(datediff(birthdate, curdate())/365) as AGE from authors WHERE abs(datediff(birthdate, curdate())/365)>=@age
AND id NOT IN (SELECT * FROM completed);

INSERT INTO completed SELECT id FROM authors WHERE abs(datediff(birthdate, curdate())/365)>=@age
AND id NOT IN (SELECT * FROM completed);