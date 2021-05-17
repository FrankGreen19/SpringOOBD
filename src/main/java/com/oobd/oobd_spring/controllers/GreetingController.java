package com.oobd.oobd_spring.controllers;

import com.oobd.oobd_spring.models.Client;
import com.oobd.oobd_spring.models.Order;
import com.oobd.oobd_spring.models.Product;
import com.oobd.oobd_spring.repositories.ClientRepository;
import com.oobd.oobd_spring.repositories.OrderRepository;
import com.oobd.oobd_spring.repositories.ProductRepository;
import com.oobd.oobd_spring.service.DbWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.transaction.TransactionManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Controller
public class GreetingController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);

        DbWork db = DbWork.getInstance();
        PlatformTransactionManager transactionManager = db.transactionManager();

        Product product = new Product("Jacket", "Brand", 2200);
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(product);
        Order order = new Order(2600, new Date(), null, products);

        makeTransaction(order);

        return "greeting";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {

        Optional<Order> order = orderRepository.findById(1);
        orderRepository.delete(order.get());

        return "greeting";
    }

    @Transactional
    public void makeTransaction(Order order) {

        for (Product product : order.getProducts()) {
            productRepository.save(product);
        }

        orderRepository.save(order);
    }

    @GetMapping("/manager")
    public String manager(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {

        DbWork db = DbWork.getInstance();

        Product product = new Product("Skirt", "Brand", 1200);

        EntityManager entityManager = db.getEmManager();

        for (int i = 0; i < 5; i++) {
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
        }

        db.closeEntityManager();

        DbWork.clear();

        return "greeting";
    }

}
