CREATE TABLE region
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

INSERT INTO region (id, name)
VALUES
    (1, 'baki'),
    (2, 'xirdalan'),
    (3, 'sumqayit');

ALTER TABLE statistics
    ADD COLUMN region_id INT;
