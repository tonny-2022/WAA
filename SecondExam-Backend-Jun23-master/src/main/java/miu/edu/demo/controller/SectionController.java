package miu.edu.demo.controller;


import miu.edu.demo.entity.Section;
import miu.edu.demo.entity.Student;
import miu.edu.demo.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sections")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SectionController {

    @Autowired
    SectionService sectionService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Section createSection(@RequestBody Section section) {
        return sectionService.createSection(section);
    }

    @GetMapping
    public List<Section> getAllSections() {
        return sectionService.getAllSections();
    }

    @GetMapping("/{sectionId}")
    public Section getSectionById(@PathVariable Long sectionId) {
        return sectionService.getSectionById(sectionId);
    }

    @PutMapping("/{sectionId}")
    public Section updateSection(@PathVariable Long sectionId, @RequestBody Section section) {
        return sectionService.updateSection(sectionId, section);
    }

    @DeleteMapping("/{sectionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSection(@PathVariable Long sectionId) {
        sectionService.deleteSection(sectionId);
    }

    @GetMapping("/{sectionId}/students")
    public List<Student> findStudentsById(@PathVariable Long sectionId) {
        return sectionService.findStudentsById(sectionId);
    }

    @PutMapping("/{sectionId}/students/{studentId}")
    public void updateStudentsInSection(@PathVariable Long sectionId, @PathVariable Integer studentId) {
        sectionService.updateStudentsInSection(sectionId, studentId);
    }

    @DeleteMapping("/{sectionId}/students/{studentId}")
    public void removeStudentsInSection(@PathVariable Long sectionId, @PathVariable Integer studentId) {
        sectionService.removeStudentsInSection(sectionId, studentId);
    }
}

