CREATE TABLE Author (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE Course (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE Topic (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   title VARCHAR(255) NOT NULL,
   message TEXT NOT NULL,
   creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   author_id BIGINT,
   course_id BIGINT,
   FOREIGN KEY (author_id) REFERENCES Author(id),
   FOREIGN KEY (course_id) REFERENCES Course(id),
   INDEX (author_id),
   INDEX (course_id)
);
