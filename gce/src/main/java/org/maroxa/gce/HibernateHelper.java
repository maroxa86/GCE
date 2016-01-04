package org.maroxa.gce;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateHelper {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    
    private HibernateHelper(){
    }
    
    private static SessionFactory buildSessionFactory(){
        return new Configuration().configure().buildSessionFactory();
    }
    
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
