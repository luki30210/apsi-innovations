package pl.pw.elka.apsi.innovations;

import org.hibernate.Session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pl.pw.elka.apsi.innovations.hibernate.model.Rating;
import pl.pw.elka.apsi.innovations.hibernate.util.HibernateUtil;

@SpringBootApplication
public class InnovationsApplication {

    public static void main(String[] args) {
        Rating rating = new Rating();
//        rating.setIdIdea(1);
//        rating.setIdUser(1);
//        rating.setValue(2);

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        session.save(rating);
//        session.getTransaction().commit();
//        System.out.println("Rating ID=" + rating.getId());

        HibernateUtil.getSessionFactory().close();

//        SpringApplication.run(InnovationsApplication.class, args);
    }
}
