CREATE TABLE testimonials
(
    id BIGSERIAL PRIMARY KEY,

    name VARCHAR(150) NOT NULL,

    designation VARCHAR(200),

    company VARCHAR(200),

    review TEXT NOT NULL,

    rating INT NOT NULL DEFAULT 5,

    profile_media_id BIGINT,

    display_order INT NOT NULL DEFAULT 0,

    is_active BOOLEAN NOT NULL DEFAULT TRUE,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_testimonial_media
        FOREIGN KEY (profile_media_id)
            REFERENCES media(id)
);