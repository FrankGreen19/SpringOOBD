package com.oobd.oobd_spring.lab17;

import com.oobd.oobd_spring.models.Client;
import com.oobd.oobd_spring.models.Order;
import com.oobd.oobd_spring.models.Product;
import com.oobd.oobd_spring.repositories.OrderRepository;
import com.oobd.oobd_spring.repositories.ProductRepository;
import com.oobd.oobd_spring.service.DbWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        DbWork db = DbWork.getInstance();
        EntityManager entityManager = db.getEmManager();
        entityManager.getTransaction().begin();

        Product product = new Product("Jacket", "Brand", 2200);
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(product);
        Order order = new Order(2600, new Date(), null, products);

        entityManager.persist(order);

        entityManager.getTransaction().commit();
        db.closeEntityManager();

        DbWork.clear();
    }

}
