package com.oobd.oobd_spring.repositories;

import com.oobd.oobd_spring.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(isolation = Isolation.SERIALIZABLE)
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
