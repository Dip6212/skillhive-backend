CREATE TABLE heroes
(
    id BIGSERIAL PRIMARY KEY,

    title VARCHAR(255) NOT NULL,

    subtitle VARCHAR(255),

    description TEXT,

    primary_button_text VARCHAR(100),

    primary_button_link VARCHAR(255),

    secondary_button_text VARCHAR(100),

    secondary_button_link VARCHAR(255),

    hero_image_url TEXT,

    background_image_url TEXT,

    is_active BOOLEAN NOT NULL DEFAULT TRUE,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);