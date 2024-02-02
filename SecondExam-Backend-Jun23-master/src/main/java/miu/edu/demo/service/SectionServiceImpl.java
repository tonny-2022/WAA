package miu.edu.demo.service;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import miu.edu.demo.entity.Section;
import miu.edu.demo.entity.Student;
import miu.edu.demo.repo.SectionRepo;
import miu.edu.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionRepo sectionRepository;

    @Autowired
    private StudentRepo studentRepo;


    public Section createSection(Section section) {
        // Perform any necessary business logic operations, if applicable
        return sectionRepository.save(section);
    }

    public List<Section> getAllSections() {
        // Perform any necessary business logic operations, if applicable
        return sectionRepository.findAll();
    }

    public Section getSectionById(Long sectionId) {
        // Perform any necessary business logic operations, if applicable
        return sectionRepository.findById(sectionId).orElse(null);
    }

    public Section updateSection(Long sectionId, Section updatedSection) {
        // Perform any necessary business logic operations, if applicable
        Section existingSection = sectionRepository.findById(sectionId).orElse(null);
        if (existingSection != null) {
            existingSection.setName(updatedSection.getName());
            existingSection.setTerm(updatedSection.getTerm());
            // Update other properties as needed
            return existingSection;
        }
        return null;
    }

    public void deleteSection(Long sectionId) {
        // Perform any necessary business logic operations, if applicable
        sectionRepository.deleteById(sectionId);
    }

    @Override
    public List<Student> findStudentsById(Long id) {
        return sectionRepository.findStudentsById(id);
    }

    EntityManager em;
    @Override
    public void updateStudentsInSection(Long sectionId, Integer studentId) {
        var section = sectionRepository.findById(sectionId).orElse(null);
        var student = studentRepo.findById(studentId).orElse(null);
        var updatedStudentList = section.getStudents();
        updatedStudentList.add(student);
        section.setStudents(updatedStudentList);

    }

    @Override
    public void removeStudentsInSection(Long sectionId, Integer studentId) {
        var section = sectionRepository.findById(sectionId).orElse(null);
        var student = studentRepo.findById(studentId).orElse(null);
        section.getStudents().remove(student);
    }
}

