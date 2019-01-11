USE session;
CREATE TABLE IF NOT EXISTS sent_ids(
    id int(11) NOT NULL,
    FOREIGN KEY (id) REFERENCES authors(id)
);

SELECT id, email from authors where DATEDIFF(NOW(),birthdate)/365 > @age and id NOT IN(SELECT id from sent_ids);
INSERT into sent_ids SELECT id FROM authors WHERE DATEDIFF(NOW(),birthdate)/365 > @age and id NOT IN(SELECT id from sent_ids);
