CREATE TABLE courses
(
    id BIGSERIAL PRIMARY KEY,

    title VARCHAR(255) NOT NULL,

    slug VARCHAR(255) UNIQUE NOT NULL,

    short_description TEXT,

    description TEXT,

    duration VARCHAR(100),

    level VARCHAR(50),

    mode VARCHAR(50),

    rating DOUBLE PRECISION,

    students INTEGER,

    image_url TEXT,

    brochure_url TEXT,

    featured BOOLEAN DEFAULT FALSE
);