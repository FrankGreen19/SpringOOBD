package com.oobd.oobd_spring.repositories;

import com.oobd.oobd_spring.models.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {
}
