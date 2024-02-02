package miu.edu.demo.service;

import miu.edu.demo.entity.Section;
import miu.edu.demo.entity.Student;
import miu.edu.demo.repo.StudentRepo;
import miu.edu.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;


    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void delete(int id) {
        studentRepo.deleteById(id);
    }

    @Override
    public void update(int id, Student s) {
        // Perform any necessary business logic operations, if applicable
        var existingStudent = studentRepo.findById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setName(s.getName());
            existingStudent.setGpa(s.getGpa());

            // Update other properties as needed
            studentRepo.save(existingStudent);
    }
    }

    @Override
    public Student findById(int id) {
        return studentRepo.findById(id).orElse(null);
    }



    @Override
    public List<Student> findByGpaLessThan(double gpa) {
        return null;
    }

    @Override
    public List<Student> findByProgram(String programLevel) {
        return null;
    }
}
