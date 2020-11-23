package com.zoe.commerce;

import com.zoe.commerce.models.Client;
import com.zoe.commerce.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client> findByName(String name);
    Client findById(long id);
}
