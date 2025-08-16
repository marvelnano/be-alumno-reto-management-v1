DROP TABLE IF EXISTS students;

CREATE TABLE students (
    id_student INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    id_course INT NOT NULL,
    nombres VARCHAR(50),
    apellidos VARCHAR(150),
    edad INT,
    email VARCHAR(150)
);