package com.karthikbhat;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory(){

        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(com.karthikbhat.Employee.class);
            configuration.addAnnotatedClass(com.karthikbhat.Address.class);
            configuration.configure("hibernate-conf.cfg.xml");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            return sessionFactory;
        }
        catch(Throwable ex){
            System.err.println("error during building");
            throw new ExceptionInInitializerError(ex);
        }
    }


    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null)
            sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}
