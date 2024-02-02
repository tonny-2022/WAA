INSERT INTO Student (id, name, gpa) VALUES (111, 'Shaima', 3.7);
INSERT INTO Student (id, name, gpa) VALUES (112, 'Zaineh', 3.6);
INSERT INTO Student (id, name, gpa) VALUES (113, 'Yasmeen', 3.9);
INSERT INTO Student (id, name, gpa) VALUES (114, 'Mira', 3.8);
INSERT INTO Student (id, name, gpa) VALUES (115, 'Tanvir', 3.8);
INSERT INTO Student (id, name, gpa) VALUES (116, 'Amer', 3.8);
INSERT INTO Student (id, name, gpa) VALUES (117, 'Syed', 3.8);

INSERT INTO Faculty (id, name) VALUES (1000, 'Dean');
INSERT INTO Faculty (id, name) VALUES (2000, 'Umur');

INSERT INTO Section (id,name,term,academic_year,faculty_id) VALUES (611,'WAA',1,2023,1000);
INSERT INTO Section (id,name,term,academic_year,faculty_id) VALUES (612,'DS',1,2023,2000);

INSERT INTO SECTION_STUDENTS (students_id,section_id) VALUES (111,611);
INSERT INTO SECTION_STUDENTS (students_id,section_id) VALUES (112,611);
INSERT INTO SECTION_STUDENTS (students_id,section_id) VALUES (113,612);
INSERT INTO SECTION_STUDENTS (students_id,section_id) VALUES (114,612);


