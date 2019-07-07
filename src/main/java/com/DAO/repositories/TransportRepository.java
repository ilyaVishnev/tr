package com.DAO.repositories;

import com.entities.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportRepository extends CrudRepository<Transport, Integer> {

    List<Transport> findAll();
}
