package com.DAO.repositories;

import com.entities.Equipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends CrudRepository<Equipment, Integer> {

    Equipment findByUin(String uin);
    List<Equipment> findAll();
}
