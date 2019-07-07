package com.DAO.repositories;

import com.entities.Park;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkRepository extends CrudRepository<Park,Integer> {

   Park findByParkName(String parkName);
   List<Park> findAll();
}
