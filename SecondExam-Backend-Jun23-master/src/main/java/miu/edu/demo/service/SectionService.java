package miu.edu.demo.service;

import miu.edu.demo.entity.Section;
import miu.edu.demo.entity.Student;
import miu.edu.demo.repo.SectionRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface SectionService {

    public Section createSection(Section section);

    public List<Section> getAllSections();

    public Section getSectionById(Long sectionId);
    public Section updateSection(Long sectionId, Section updatedSection);

    public void deleteSection(Long sectionId);

    public List<Student> findStudentsById(Long id);

    public void updateStudentsInSection(Long sectionId, Integer studentId);

    void removeStudentsInSection(Long sectionId, Integer studentId);

}
