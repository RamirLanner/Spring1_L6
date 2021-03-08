package ru.pentragon.spring1_l6.spring1l6.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_customer")
    private Long id_customer;

    @Column(name = "id_product")
    private Long id_product;

    @Column(name = "cost")
    private float cost;

//    @ManyToMany
//    @JoinTable(
//            name = "customers",
//            joinColumns = @JoinColumn(name = "id"),
//            inverseJoinColumns = @JoinColumn(name = "cost")
//    )
//    List<Customer> customerList;

}
