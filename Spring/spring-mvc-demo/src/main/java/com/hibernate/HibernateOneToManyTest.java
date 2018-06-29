package com.hibernate;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.transaction.Transactional;

public class HibernateOneToManyTest {

    @Transactional
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            // begin txn
            session.beginTransaction();

            /*Instructor instructor = new Instructor("John", "Doe", "johndoe@hotmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("youtube.com/john-doe", "gaming");
            instructor.setInstructorDetail(instructorDetail);
            session.save(instructor);*/

            /* // add course
            Instructor instructor = session.get(Instructor.class, 1);
            Course course1 = new Course("Course A");
            Course course2 = new Course(("Course B"));
            instructor.addCourse(course1);
            instructor.addCourse(course2);
            session.save(course1);
            session.save(course2); */

            /* // get instructor courses
            Instructor instructor = session.get(Instructor.class, 1);
            System.out.println("Instructor courses: " + instructor.getCourses()); */

            // delete course
            Course course = session.get(Course.class, 11);
            session.delete(course);

            // commit txn
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
