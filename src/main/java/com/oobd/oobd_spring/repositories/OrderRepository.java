package com.oobd.oobd_spring.repositories;

import com.oobd.oobd_spring.models.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(isolation = Isolation.SERIALIZABLE)
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
