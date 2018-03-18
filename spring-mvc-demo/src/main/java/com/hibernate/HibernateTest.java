/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 18 Mar 2018
 **/

package com.hibernate;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.transaction.Transactional;

public class HibernateTest {

    @Transactional
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            /*Instructor instructor = new Instructor("Anand", "MadarNigam", "madar@hotmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("youtube.com/madar", "haramipanti");
            instructor.setInstructorDetail(instructorDetail);*/

            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, 2);
            if (instructor != null)
                session.delete(instructor);

            /*System.out.print(session.createQuery("from Student s where s.id = 2").getResultList());
            int studentId = 2;
            session.get(Student.class, studentId).setFirstName("Cheeku");
            session.getTransaction().commit();*/
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

}
