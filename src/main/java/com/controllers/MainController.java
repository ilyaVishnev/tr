package com.controllers;

import com.DAO.services.EquipmentService;
import com.DAO.services.ParkService;
import com.DAO.services.TransportService;
import com.entities.Equipment;
import com.entities.Park;
import com.entities.Transport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private ParkService parkService;

    @Autowired
    private TransportService transportService;

    @GetMapping("/list")
    protected ModelAndView sendList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("transports", transportService.findAll());
        modelAndView.addObject("equipments", equipmentService.findAll());
        modelAndView.addObject("parks", parkService.findAll());
        modelAndView.setViewName("list");
        return modelAndView;
    }

    @PostMapping("/create")
    protected String createTransport(@RequestParam("stateNumber") String stateNumber,
                                     @RequestParam("equipments") String uin,
                                     @RequestParam("parks") String parkName) {
        Equipment equipment = equipmentService.findByUin(uin);
        Park park = parkService.findByParkName(parkName);
        Transport transport = new Transport();
        transport.setEquipment(equipment);
        transport.setPark(park);
        transport.setStateNumber(stateNumber);
        transportService.save(transport);
        return "redirect:/list";
    }
}
