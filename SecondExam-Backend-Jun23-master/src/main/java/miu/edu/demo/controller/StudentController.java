package miu.edu.demo.controller;

import miu.edu.demo.entity.Student;
import miu.edu.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> findAll(@RequestParam(value = "filter" ,required = false) String criteria ,
                                 @RequestParam(value = "input" ,required = false) String input) {
        if(criteria!=null && criteria.equals("gpa"))
            return studentService.findByGpaLessThan(Double.valueOf(input));
        else if(criteria!=null && criteria.equals("program"))
            return studentService.findByProgram(input);
        else
            return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable("id") int id) {
        return studentService.findById(id);
    }

    @PostMapping()
    public void save(@RequestBody Student student){
        studentService.save(student);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        studentService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Student student) {
        studentService.update(id, student);
    }

}



