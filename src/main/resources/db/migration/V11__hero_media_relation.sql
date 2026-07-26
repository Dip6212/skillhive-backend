ALTER TABLE heroes
    ADD COLUMN hero_image_media_id BIGINT;

ALTER TABLE heroes
    ADD COLUMN background_image_media_id BIGINT;

ALTER TABLE heroes
    ADD CONSTRAINT fk_hero_image
        FOREIGN KEY(hero_image_media_id)
            REFERENCES media(id);

ALTER TABLE heroes
    ADD CONSTRAINT fk_background_image
        FOREIGN KEY(background_image_media_id)
            REFERENCES media(id);