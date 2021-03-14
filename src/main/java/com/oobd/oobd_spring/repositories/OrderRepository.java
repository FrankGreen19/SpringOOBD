package com.oobd.oobd_spring.repositories;

import com.oobd.oobd_spring.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
