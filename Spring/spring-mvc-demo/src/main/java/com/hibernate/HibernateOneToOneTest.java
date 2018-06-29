package com.hibernate;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.transaction.Transactional;

public class HibernateOneToOneTest {

    @Transactional
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            /*InstructorDetail instructorDetail = session.get(InstructorDetail.class, 1);
            System.out.println(instructorDetail);
            System.out.println(instructorDetail.getInstructor());*/
            Instructor instructor = new Instructor("Jane", "Doe", "janedoe@hotmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("youtube.com/jane-doe", "dancing");
            instructor.setInstructorDetail(instructorDetail);
            session.save(instructor);
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
