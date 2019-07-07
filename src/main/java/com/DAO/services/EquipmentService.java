package com.DAO.services;

import com.DAO.repositories.EquipmentRepository;
import com.entities.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    public Equipment findByUin(String uin) {
        return equipmentRepository.findByUin(uin);
    }
    public List<Equipment> findAll(){return equipmentRepository.findAll();}
}
