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
//    @OneToMany(cascade = CascadeType.ALL)
    @OneToMany()
    private List<Product> products;

    public Order() {
    }

    public Order(double orderPrice, Date orderDate, Client clientid, List<Product> products) {
        this.orderPrice = orderPrice;
        this.orderDate = orderDate;
        this.clientid = clientid;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Client getClientid() {
        return clientid;
    }

    public void setClientid(Client clientid) {
        this.clientid = clientid;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
