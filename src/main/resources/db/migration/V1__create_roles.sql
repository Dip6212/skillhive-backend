CREATE TABLE roles
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL,
    description TEXT
);

INSERT INTO roles(name, description)
VALUES
    ('ROLE_SUPER_ADMIN','Full Access'),
    ('ROLE_ADMIN','Administrative Access'),
    ('ROLE_EDITOR','Content Management');