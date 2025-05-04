-- Single Table
CREATE TABLE economic_data (
                              id INT PRIMARY KEY AUTO_INCREMENT,
                              date DATE,
                              value DECIMAL(10, 2),
                              infoType VARCHAR(20) -- 'Inflation' or 'InterestRate'
);

INSERT INTO economic_data (date, value, infoType)
VALUES
    ('2023-01-01', 13.9, 'Inflation'),
    ('2023-02-01', 13.6, 'Inflation'),
    ('2023-03-01', 13.8, 'Inflation'),
    ('2023-04-01', 13.5, 'Inflation'),
    ('2023-05-01', 13.1, 'Inflation'),
    ('2023-06-01', 12.7, 'Inflation'),
    ('2023-07-01', 12.1, 'Inflation'),
    ('2023-08-01', 11.7, 'Inflation'),
    ('2023-09-01', 10.9, 'Inflation'),
    ('2023-10-01', 10.2, 'Inflation');

INSERT INTO economic_data (date, value, infoType)
VALUES
    ('2023-01-01', 6.34, 'Mortgage'),
    ('2023-02-01', 6.34, 'Mortgage'),
    ('2023-03-01', 6.34, 'Mortgage'),
    ('2023-04-01', 6.34, 'Mortgage'),
    ('2023-05-01', 6.34, 'Mortgage'),
    ('2023-06-01', 6.35, 'Mortgage'),
    ('2023-07-01', 6.36, 'Mortgage'),
    ('2023-08-01', 6.33, 'Mortgage'),
    ('2023-09-01', 6.33, 'Mortgage'),
    ('2023-10-01', 6.34, 'Mortgage');
