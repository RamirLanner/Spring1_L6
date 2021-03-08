package ru.pentragon.spring1_l6.spring1l6.reppositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pentragon.spring1_l6.spring1l6.entities.Customer;
import ru.pentragon.spring1_l6.spring1l6.entities.Product;

import javax.persistence.EntityManagerFactory;

@Component
public class CustomerRepo {

    private SessionFactory sessionFactory;

    @Autowired
    public CustomerRepo(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.sessionFactory = factory.unwrap(SessionFactory.class);
    }

    public void create(Customer customer){
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
        }
    }

    public Customer read(Long id){
        Customer customer = null;
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            customer = session.get(Customer.class, id);
            session.getTransaction().commit();
        }
        return customer;
    }

    public void update(Long id, String newName){
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            customer.setName(newName);
            session.getTransaction().commit();
        }
    }

    public void delete(Long id){
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            session.delete(customer);
            session.getTransaction().commit();
        }
    }

    //
}
