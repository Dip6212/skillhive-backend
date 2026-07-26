CREATE TABLE partners
(
    id BIGSERIAL PRIMARY KEY,

    name VARCHAR(150) NOT NULL,

    website_url TEXT,

    display_order INT NOT NULL DEFAULT 0,

    is_active BOOLEAN NOT NULL DEFAULT TRUE,

    logo_media_id BIGINT,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_partner_logo
        FOREIGN KEY (logo_media_id)
            REFERENCES media(id)
);