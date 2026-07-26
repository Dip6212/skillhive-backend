CREATE TABLE course_packages
(
    id BIGSERIAL PRIMARY KEY,

    name VARCHAR(100) NOT NULL,

    course_id BIGINT NOT NULL,

    CONSTRAINT fk_package_course
        FOREIGN KEY (course_id)
            REFERENCES courses(id)
            ON DELETE CASCADE
);