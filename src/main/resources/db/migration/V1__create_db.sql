CREATE TABLE Client
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL CHECK (LENGTH(name) >= 3 AND LENGTH(name) <= 200)
);

CREATE TABLE Planet
(
    id   VARCHAR(50) PRIMARY KEY CHECK (id = UPPER(id)),
    name VARCHAR(500) NOT NULL CHECK (LENGTH(name) >= 1 AND LENGTH(name) <= 500)
);

CREATE TABLE Ticket (
    id             INT AUTO_INCREMENT PRIMARY KEY,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    client_id      INT,
    from_planet_id VARCHAR(50),
    to_planet_id   VARCHAR(50),
    FOREIGN KEY (client_id) REFERENCES Client (id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (from_planet_id) REFERENCES Planet (id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (to_planet_id) REFERENCES Planet (id) ON DELETE CASCADE ON UPDATE CASCADE
);

