package ru.pentragon.spring1_l6.spring1l6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.pentragon.spring1_l6.spring1l6.entities.Customer;
import ru.pentragon.spring1_l6.spring1l6.entities.Order;
import ru.pentragon.spring1_l6.spring1l6.entities.Product;
import ru.pentragon.spring1_l6.spring1l6.reppositories.CustomerRepo;
import ru.pentragon.spring1_l6.spring1l6.reppositories.ProductRepo;
import ru.pentragon.spring1_l6.spring1l6.services.CustomerProductService;

@SpringBootApplication
public class Spring1l6Application {

    public static void main(String[] args) {

        SpringApplication.run(Spring1l6Application.class, args);

        SessionFactory factory = new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();
        try {
            CustomerProductService service = new CustomerProductService(new CustomerRepo(factory), new ProductRepo(factory) );
            System.out.println(service.productsInfoByCustomerID(1L).toString());
            System.out.println(service.customersInfoByProductID(1L).toString());
        } finally {
            factory.close();
        }

    }

}
