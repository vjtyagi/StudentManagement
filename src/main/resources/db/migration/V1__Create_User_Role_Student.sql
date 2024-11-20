-- Create the roles table
CREATE TABLE IF NOT EXISTS roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);
-- Insert default roles into the 'roles' table
INSERT INTO roles(name) VALUES
('USER'),
('ADMIN');

-- create user's table 
CREATE TABLE  IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    CONSTRAINT password_length_check CHECK (LENGTH(password) BETWEEN 8 AND 15)
);

-- Create user_roles table
CREATE TABLE  IF NOT EXISTS user_roles (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    role_id INTEGER NOT NULL,

    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE,
    CONSTRAINT user_user_role UNIQUE (user_id, role_id)
);

-- Create students table
CREATE TABLE  IF NOT EXISTS students (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    department VARCHAR(50) NOT NULL,
    enrollment_status VARCHAR(50) NOT NULL,
    date_of_birth DATE NOT NULL,

    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
