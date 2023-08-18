INSERT INTO client (name) VALUES
    ('Daniil'),
    ('Roma'),
    ('Andrey'),
    ('Anastasia'),
    ('Jon'),
    ('Josh'),
    ('Kevin'),
    ('Slava'),
    ('Maxim'),
    ('Gosha');

INSERT INTO planet (id, name) VALUES
    ('MARS', 'Mars'),
    ('VEN', 'Venus'),
    ('PLUTO', 'Pluto'),
    ('JUP', 'Jupiter'),
    ('NEPT', 'Neptune');

INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id) VALUES
    (CURRENT_TIMESTAMP, 1, 'MARS', 'VEN'),
    (CURRENT_TIMESTAMP, 2, 'VEN', 'MARS'),
    (CURRENT_TIMESTAMP, 3, 'PLUTO', 'JUP'),
    (CURRENT_TIMESTAMP, 4, 'MARS', 'PLUTO'),
    (CURRENT_TIMESTAMP, 5, 'JUP', 'VEN'),
    (CURRENT_TIMESTAMP, 6, 'NEPT', 'PLUTO'),
    (CURRENT_TIMESTAMP, 7, 'VEN', 'NEPT'),
    (CURRENT_TIMESTAMP, 8, 'MARS', 'NEPT'),
    (CURRENT_TIMESTAMP, 9, 'NEPT', 'VEN'),
    (CURRENT_TIMESTAMP, 10, 'JUP', 'PLUTO');
