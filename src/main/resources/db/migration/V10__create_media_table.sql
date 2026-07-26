CREATE TABLE media
(
    id BIGSERIAL PRIMARY KEY,

    file_name VARCHAR(255) NOT NULL,

    original_file_name VARCHAR(255) NOT NULL,

    content_type VARCHAR(100) NOT NULL,

    file_size BIGINT NOT NULL,

    storage_path TEXT NOT NULL,

    file_url TEXT NOT NULL,

    uploaded_by BIGINT,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);