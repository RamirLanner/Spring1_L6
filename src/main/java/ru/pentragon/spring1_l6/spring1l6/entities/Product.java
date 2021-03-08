package ru.pentragon.spring1_l6.spring1l6.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public Product(Long id, String title, float cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private float cost;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "orders",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_customer")
    )
    @ToString.Exclude
    List<Customer> customerList;
    //List<Order> orderList;

}
