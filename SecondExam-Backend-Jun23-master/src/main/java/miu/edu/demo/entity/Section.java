package miu.edu.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Section {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Integer term;
    Integer academicYear;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Student> students;

	public Section(Long id, String name, Integer term, Integer academicYear, List<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.term = term;
		this.academicYear = academicYear;
		this.students = students;
	}
	 public Section(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTerm() {
		return term;
	}

	public void setTerm(Integer term) {
		this.term = term;
	}

	public Integer getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(Integer academicYear) {
		this.academicYear = academicYear;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}


}
