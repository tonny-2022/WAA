package miu.edu.demo.repo;

import miu.edu.demo.entity.Section;
import miu.edu.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepo extends JpaRepository<Section,Long> {

    @Query("select s.students FROM Section s where s.id = :id")
    List<Student> findStudentsById(Long id);

}
