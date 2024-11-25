-- Add unique constraints on enrollments
ALTER TABLE enrollments 
ADD CONSTRAINT unique_student_course UNIQUE(student_id, course_id);