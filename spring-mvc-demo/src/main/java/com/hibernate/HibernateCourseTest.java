/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 18 Mar 2018
 **/

package com.hibernate;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.transaction.Transactional;

public class HibernateCourseTest {

    @Transactional(rollbackOn = Exception.class)
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, 1);
            Course course1 = new Course("Coding");
            instructor.addCourse(course1);
            Course course2 = new Course("Gaming");
            instructor.addCourse(course2);
            session.save(course1);
            session.save(course2);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
