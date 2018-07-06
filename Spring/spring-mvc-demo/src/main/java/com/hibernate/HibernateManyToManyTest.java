package com.hibernate;

import com.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.transaction.Transactional;

public class HibernateManyToManyTest {

    @Transactional
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class).buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            // begin txn
            session.beginTransaction();

            /*Course course = new Course("Course1");

            session.save(course); // add course before adding students

            Student student1 = new Student("Bibhas","Abhishek","bibhas_01@hotmail.com");
            Student student2 = new Student("Srishti","Singh","srishti.singh700@gmail.com");

            course.addStudent(student1);
            course.addStudent(student2);

            session.save(student1);
            session.save(student2);*/

            /*Student student = session.get(Student.class, 1);
            System.out.println(student);
            System.out.println("Courses: " + student.getCourses());*/

            /*Course course2 = new Course("Course2");
            Course course3 = new Course("Course3");

            course2.addStudent(student);
            course3.addStudent(student);

            session.save(course2);
            session.save(course3);*/

            /*Course course = session.get(Course.class, 11);
            session.delete(course);*/

            Student student = session.get(Student.class, 2);
            System.out.println(student);
            System.out.println("Courses: " + student.getCourses());
            session.delete(student);

            // commit txn
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
