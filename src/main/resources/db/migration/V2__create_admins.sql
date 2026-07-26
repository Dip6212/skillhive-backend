CREATE TABLE admins
(
    id BIGSERIAL PRIMARY KEY,

    role_id BIGINT NOT NULL,

    name VARCHAR(100) NOT NULL,

    email VARCHAR(150) UNIQUE NOT NULL,

    password VARCHAR(255) NOT NULL,

    profile_media_id BIGINT,

    is_active BOOLEAN DEFAULT TRUE,

    last_login TIMESTAMP,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_admin_role
        FOREIGN KEY(role_id)
            REFERENCES roles(id)
);