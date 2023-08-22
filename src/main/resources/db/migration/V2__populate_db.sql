INSERT INTO client (name) VALUES
    ('Client 1'),
    ('Client 2'),
    ('Client 3'),
    ('Client 4'),
    ('Client 5'),
    ('Client 6'),
    ('Client 7'),
    ('Client 8'),
    ('Client 9'),
    ('Client 10');

INSERT INTO planet (id, name) VALUES
    ('MARS', 'Mars'),
    ('VEN', 'Venus'),
    ('PLUTO', 'Pluto'),
    ('JUP', 'Jupiter'),
    ('NEPT', 'Neptune');

INSERT INTO ticket (client_id, from_planet_id, to_planet_id) VALUES
    (1, 'MARS', 'VEN'),
    (2, 'VEN', 'MARS'),
    (3, 'PLUTO', 'JUP'),
    (4, 'MARS', 'PLUTO'),
    (5, 'JUP', 'VEN'),
    (6, 'NEPT', 'PLUTO'),
    (7, 'VEN', 'NEPT'),
    (8, 'MARS', 'NEPT'),
    (9, 'NEPT', 'VEN'),
    (10, 'JUP', 'PLUTO');
