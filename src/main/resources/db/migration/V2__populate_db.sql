INSERT INTO client(name)
VALUES ('Daniil'),
       ('Kolia'),
       ('Zhenia'),
       ('Andry'),
       ('Oleg'),
       ('Josh'),
       ('Caven'),
       ('Slava'),
       ('Anastasia'),
       ('Max');
INSERT INTO planet(id, name)
VALUES ('MARS', 'Mars'),
       ('VENERA', 'Venera'),
       ('EARTH', 'Earth'),
       ('MERCURY', 'Mercury'),
       ('PLUTON', 'Pluton');
INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id)
VALUES ('2023-12-30 13:08:54', 1, 'MARS', 'EARTH'),
       ('2018-11-30 13:08:54', 2, 'EARTH', 'MARS'),
       ('2018-11-30 13:08:54', 3, 'MARS', 'PLUTON'),
       ('2011-11-30 13:08:54', 4, 'VENERA', 'MARS'),
       ('2016-11-30 13:08:54', 5, 'EARTH', 'VENERA'),
       ('2015-11-30 13:08:54', 6, 'PLUTON', 'EARTH'),
       ('2015-08-30 13:08:54', 7, 'EARTH', 'MERCURY'),
       ('2016-09-30 13:08:54', 8, 'MARS', 'VENERA'),
       ('2000-10-30 13:08:54', 9, 'VENERA', 'MERCURY'),
       ('2000-03-30 13:08:54', 10, 'MERCURY', 'PLUTON');
