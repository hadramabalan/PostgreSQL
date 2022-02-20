DROP TABLE IF EXISTS person CASCADE;
CREATE TABLE person(
        account_number SERIAL PRIMARY KEY,
        first_name VARCHAR(100) NOT NULL,
        last_name VARCHAR(100) NOT NULL,
        Account_status VARCHAR(20)
);
DROP TABLE IF EXISTS student CASCADE;
CREATE TABLE student(
        account_number SERIAL PRIMARY KEY,
        CONSTRAINT student_fk_account_number
                FOREIGN KEY (account_number)
                REFERENCES person(account_number)
                ON UPDATE CASCADE
                ON DELETE SET NULL
);
DROP TABLE IF EXISTS mentor CASCADE;
CREATE TABLE mentor(
        account_number SERIAL PRIMARY KEY,
        CONSTRAINT student_fk_account_number
                FOREIGN KEY (account_number)
                REFERENCES person(account_number)
                ON UPDATE CASCADE
                ON DELETE SET NULL
);
DROP TABLE IF EXISTS university CASCADE;
CREATE TABLE university(
        uni_name VARCHAR(100) PRIMARY KEY,
        faculty VARCHAR(100)[] CHECK (array_length(faculty, 1) > 0)
);
DROP TABLE IF EXISTS program CASCADE;
CREATE TABLE program(
        program_name VARCHAR(100) PRIMARY KEY,
        uni_name VARCHAR(100),
        CONSTRAINT program_fk_uni_name
                FOREIGN KEY(uni_name)
                REFERENCES university(uni_name)
                ON UPDATE CASCADE
                ON DELETE SET NULL
);
DROP TABLE IF EXISTS exam CASCADE;
CREATE TABLE exam(
        exam_name VARCHAR(100) PRIMARY KEY,
        program_name VARCHAR(100) UNIQUE,
        uni_name VARCHAR(100),
        CONSTRAINT exam_fk_program_name
                FOREIGN KEY(exam_name)
                REFERENCES exam(exam_name)
                ON UPDATE CASCADE
                ON DELETE SET NULL,
        CONSTRAINT exam_fk_uni_name
                FOREIGN KEY(uni_name)
                REFERENCES university(uni_name)
                ON UPDATE CASCADE
                ON DELETE SET NULL
);
DROP TABLE IF EXISTS study_material CASCADE;
CREATE TABLE study_material(
        material_name VARCHAR(255) PRIMARY KEY,
        material_type VARCHAR(100)[]
);
DROP TABLE IF EXISTS science CASCADE;
CREATE TABLE science(
        science_name VARCHAR(100) PRIMARY KEY
);
DROP TABLE IF EXISTS friendship CASCADE;
CREATE TABLE friendship(
                first_account_number SERIAL NOT NULL,
                second_account_number SERIAL NOT NULL,
                PRIMARY KEY(first_account_number, second_account_number),
                CONSTRAINT first_fk_student
                        FOREIGN KEY(first_account_number)
                        REFERENCES student
                        ON UPDATE CASCADE
                        ON DELETE SET NULL,
                CONSTRAINT second_fk_student
                        FOREIGN KEY(second_account_number)
                        REFERENCES student
                        ON UPDATE CASCADE
                        ON DELETE SET NULL
);
DROP TABLE IF EXISTS exam_contents CASCADE;
CREATE TABLE exam_contents(
        exam_name VARCHAR(100) NOT NULL,
        material_name VARCHAR(255) NOT NULL,
        PRIMARY KEY(exam_name, material_name),
        CONSTRAINT contents_fk_exam
                FOREIGN KEY(exam_name)
                REFERENCES exam
                ON UPDATE CASCADE
                ON DELETE SET NULL,
        CONSTRAINT contents_fk_material
                FOREIGN KEY(material_name)
                REFERENCES study_material
                ON UPDATE CASCADE
                ON DELETE SET NULL
);
DROP TABLE IF EXISTS mentorship CASCADE;
CREATE TABLE mentorship(
        exam_name VARCHAR(100) NOT NULL,
        mentored_account_number SERIAL NOT NULL,
        mentoring_account_number SERIAL NOT NULL,
        PRIMARY KEY(exam_name, mentored_account_number, mentoring_account_number),
        CONSTRAINT mentorship_fk_exam
                FOREIGN KEY(exam_name)
                REFERENCES exam
                ON UPDATE CASCADE
                ON DELETE SET NULL,
        CONSTRAINT mentorship_fk_student
                FOREIGN KEY(mentored_account_number)
                REFERENCES student
                ON UPDATE CASCADE
                ON DELETE SET NULL,
        CONSTRAINT mentorship_fk_mentor
                FOREIGN KEY(mentoring_account_number)
                REFERENCES mentor
                ON UPDATE CASCADE
                ON DELETE SET NULL
);