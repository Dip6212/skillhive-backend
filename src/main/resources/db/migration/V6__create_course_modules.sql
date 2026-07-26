CREATE TABLE course_modules
(
    id BIGSERIAL PRIMARY KEY,

    title VARCHAR(255) NOT NULL,

    description TEXT,

    duration VARCHAR(100),

    display_order INTEGER,

    package_id BIGINT NOT NULL,

    CONSTRAINT fk_module_package
        FOREIGN KEY (package_id)
            REFERENCES course_packages(id)
            ON DELETE CASCADE
);