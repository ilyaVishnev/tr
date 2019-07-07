package com.DAO.services;

import com.DAO.repositories.ParkRepository;
import com.entities.Park;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkService {

    @Autowired
    private ParkRepository parkRepository;

    public Park findByParkName(String parkName) {
        return parkRepository.findByParkName(parkName);
    }
    public List<Park> findAll(){return parkRepository.findAll();}
}
