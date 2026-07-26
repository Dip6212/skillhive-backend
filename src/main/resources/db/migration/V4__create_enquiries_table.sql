CREATE TABLE enquiries
(
    id BIGSERIAL PRIMARY KEY,

    full_name VARCHAR(255) NOT NULL,

    email VARCHAR(255) NOT NULL,

    phone VARCHAR(20) NOT NULL,

    course VARCHAR(255),

    message TEXT,

    status VARCHAR(50) NOT NULL,

    created_at TIMESTAMP NOT NULL
);