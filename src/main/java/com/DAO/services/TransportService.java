package com.DAO.services;

import com.DAO.repositories.TransportRepository;
import com.entities.Transport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportService {

    @Autowired
    private TransportRepository transportRepository;

    public List<Transport> findAll() {
        return transportRepository.findAll();
    }

    public void save(Transport transport) {
        transportRepository.save(transport);
    }
}
