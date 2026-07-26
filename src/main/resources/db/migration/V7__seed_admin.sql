INSERT INTO admins (
    role_id,
    name,
    email,
    password,
    is_active
)
VALUES (
           (
               SELECT id
               FROM roles
               WHERE name = 'ROLE_SUPER_ADMIN'
           ),
           'Super Admin',
           'admin@edtech.com',
           '$2a$10$8LKNlZFAlhNx1wbtV5BSHejFBcUycZMXi6G1wWSSfWVIe5NadfRZK',
           true
       );