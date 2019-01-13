package com.karthikbhat;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.PersistenceException;

public class DBOps extends Throwable{

    public static void addEmp(Employee employee){

        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            session.save(employee);

            session.getTransaction().commit();

            System.out.println("Transaction Done : "+ employee.getId());

            session.close();
        }

        catch (PersistenceException e){
            System.out.println("Duplicate key");

        }
        catch (Exception e){
            System.out.println("Something went wrong");
        }
    }

    public static void delEmp(String id){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        Transaction tx = session.beginTransaction();

        Employee employee = session.load(Employee.class, id);

        if(employee == null){
            System.out.println("Employee does not exist");
            session.close();
            return;
        }


        session.delete(employee);

        tx.commit();

        System.out.println("Transaction Done : "+ employee.getId());

        session.close();

    }

    public static Employee getEmp(String id){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        Transaction tx = session.beginTransaction();
        Employee employee = session.get(Employee.class, id);

        tx.commit();

        session.close();

        return employee;
    }

    public static void updateEmp(Employee employee){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {

            Transaction tx = session.beginTransaction();
            session.update(employee);

            tx.commit();
        }
        catch (PersistenceException e){
            System.out.println(e);
            System.out.println("Employee does not exist");

        }
        catch(Exception e){
            System.out.println("Something went wrong");
        }
        finally {
            session.close();
        }
    }





}
