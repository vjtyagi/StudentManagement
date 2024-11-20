-- Create Course Table
CREATE TABLE IF NOT EXISTS courses (
    id BIGSERIAL PRIMARY KEY,
    course_code VARCHAR(255) NOT NULL UNIQUE,
    course_name VARCHAR(255) NOT NULL,
    credits INTEGER NOT NULL,
    department VARCHAR(255) NOT NULL
);
-- Create Enrollment Table
CREATE TABLE IF NOT EXISTS enrollments (
    id BIGSERIAL PRIMARY KEY,
    student_id BIGINT NOT NULL,
    course_id BIGINT NOT NULL,
    semester VARCHAR(255),
    grade VARCHAR(10),
    CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE,
    CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES courses(id) on DELETE CASCADE
);

-- Create Index on student_id and course_id for better performance
CREATE INDEX idx_enrollments_student_id ON enrollments(student_id);
CREATE INDEX idx_enrollments_course_id ON enrollments(course_id);