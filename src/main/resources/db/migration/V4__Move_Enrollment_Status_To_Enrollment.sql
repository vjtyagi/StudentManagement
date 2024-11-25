-- Add new status column to enrollments table
ALTER TABLE enrollments ADD COLUMN status VARCHAR(255) DEFAULT 'ENROLLED' NOT NULL;

-- drop enrollment status from students table
ALTER TABLE students DROP COLUMN enrollment_status;