package ru.pentragon.spring1_l6.spring1l6.services;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;
import ru.pentragon.spring1_l6.spring1l6.entities.Customer;
import ru.pentragon.spring1_l6.spring1l6.entities.Product;
import ru.pentragon.spring1_l6.spring1l6.reppositories.CustomerRepo;
import ru.pentragon.spring1_l6.spring1l6.reppositories.ProductRepo;

import java.util.List;

@Service
public class CustomerProductService {

    CustomerRepo customerRepo;
    ProductRepo productRepo;

    public CustomerProductService(CustomerRepo customerRepo, ProductRepo productRepo) {
        this.customerRepo = customerRepo;
        this.productRepo = productRepo;
    }

    public List<Product> productsInfoByCustomerID(Long idCustomer) {
        List<Product> list = null;
        Customer customer = customerRepo.read(idCustomer);
        list = customer.getProductList();
        return list;
    }


    public List<Customer> customersInfoByProductID(Long idProduct) {
        List<Customer> list = null;
        Product product = ProductRepo.read(idProduct);
        list = product.getCustomerList();
        return list;
    }

    ;

}
