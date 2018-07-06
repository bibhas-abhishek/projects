package com.hibernate;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.transaction.Transactional;

public class HibernateOneToManyUniTest {

    @Transactional
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
                .buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            // begin txn
            session.beginTransaction();

            /*Course course = new Course("Course-OneToManyUni2");
            course.addReview(new Review("Review 4"));
            course.addReview(new Review("Review 5"));

            session.save(course);*/

            Course course = session.get(Course.class, 11);
            session.delete(course);

            // commit txn
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
