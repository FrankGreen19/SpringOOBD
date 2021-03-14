package com.oobd.oobd_spring.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private double orderPrice;

    @Column
    private Date orderDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client clientid;

//    @ManyToMany
//    @JoinTable (name="order_product",
//            joinColumns=@JoinColumn (name="order_id"),
//            inverseJoinColumns=@JoinColumn(name="product_id"))
    @Column
    @OneToMany
    private List<Product> products;

    public Order() {
    }
}
