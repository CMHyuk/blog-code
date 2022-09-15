import study.School;
import study.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            School school = new School();
            School school1 = new School();

            Student student1 = new Student();
            Student student2 = new Student();

            school.setSchoolName("111");
            school1.setSchoolName("222");

            student1.setStudentName("aaa");
            student2.setStudentName("bbb");

            school.addStudent(student1);
            school1.addStudent(student2);

            em.persist(school);
            em.persist(school1);

            em.flush();
            em.clear();

            //즉시로딩, 지연로딩
            /*List<Student> result = em.createQuery("select s from Student s", Student.class)
                    .getResultList();*/

            //페치조인
            /*List<Student> result = em.createQuery("select s from Student s join fetch s.school", Student.class)
                    .getResultList();*/

            //별칭
            /*List<Student> result = em.createQuery("select s from Student s join fetch s.school sc where sc.schoolName = :schoolName", Student.class)
                    .setParameter("schoolName", "111")
                    .getResultList();*/

            //페이징
           /* List<School> result = em.createQuery("select s from School s join fetch s.students", School.class)
                    .setFirstResult(0)
                    .setMaxResults(1)
                    .getResultList();*/

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
