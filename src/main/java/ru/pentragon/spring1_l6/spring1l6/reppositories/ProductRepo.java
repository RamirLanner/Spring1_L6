package ru.pentragon.spring1_l6.spring1l6.reppositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pentragon.spring1_l6.spring1l6.entities.Product;

import javax.persistence.EntityManagerFactory;

@Component
public class ProductRepo {
    private static SessionFactory sessionFactory;

    @Autowired
    public ProductRepo(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.sessionFactory = factory.unwrap(SessionFactory.class);
    }

    public static void create(Product product){
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }
    }

    public static Product read(Long id){
        Product product = new Product();
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            product = session.get(Product.class, id);
            session.getTransaction().commit();
        }
        return product;
    }

    public static void update(Long id, String newTitle, float newCost){
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            product.setTitle(newTitle);
            product.setCost(newCost);
            session.getTransaction().commit();
        }
    }

    public static void delete(Long id){
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    //
}
