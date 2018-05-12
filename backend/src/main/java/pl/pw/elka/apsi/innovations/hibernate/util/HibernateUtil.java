package pl.pw.elka.apsi.innovations.hibernate.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    //Annotation based configuration
    private static SessionFactory session_factory;

    private static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry standard_registry =
                    new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(standard_registry).getMetadataBuilder().build();

            return metadata.getSessionFactoryBuilder().build();
        }
        catch (HibernateException ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw ex;
        }
    }

    public static SessionFactory getSessionFactory() {
        if(session_factory == null)
        {
            session_factory = buildSessionFactory();
        }
        return session_factory;
    }
}