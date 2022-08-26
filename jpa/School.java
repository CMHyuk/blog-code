package study;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class School {

    @Id @GeneratedValue
    private Long id;

    private String schoolName;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        student.setSchool(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
