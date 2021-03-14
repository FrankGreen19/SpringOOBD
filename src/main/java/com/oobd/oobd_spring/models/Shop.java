package com.oobd.oobd_spring.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    @OneToMany
    private List<Order> orders;

    @Column
    @OneToMany()
    private List<Client> clients;

    @Column
    @OneToMany()
    private List<Worker> workers;

    @Column
    @OneToMany()
    private List<Product> products;

    public Shop(String name) {
        this.name = name;
    }

    public Shop() {}

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showProducts() {
        for (Product product: this.products)
            System.out.println(product.toString());
    }
}
