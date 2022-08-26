import study.School;
import study.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            School school = new School();
            school.setSchoolName("school-A");

            Student student = new Student();
            Student student1 = new Student();

            student.setStudentName("student-A");
            student1.setStudentName("student-B");

            school.addStudent(student);
            school.addStudent(student1);

            em.persist(school);
            em.persist(student);
            em.persist(student1);

            em.flush();
            em.clear();

            Student student2 = school.getStudents().get(0);
            Student student3 = school.getStudents().get(1);
            System.out.println(student2);
            System.out.println(student3);

            em.find(Student.class, student.getId());

            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
