package com.haoyan.foodTruck.controller;

import com.haoyan.foodTruck.entity.SearchEntity;
import com.haoyan.foodTruck.entity.dto.RequestDTO;
import com.haoyan.foodTruck.entity.dto.ResponseDTO;
import com.haoyan.foodTruck.service.SearchService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    SearchService service;
    @PostMapping("/all")
    public ResponseDTO getResult(){
        ResponseDTO res = new ResponseDTO();
        res.setMessage(service.getAll());
        res.setCode(200);
        return res;
    }
    @PostMapping("/results")
    public ResponseDTO getResult(@RequestBody RequestDTO requestDTO){
        ResponseDTO res = new ResponseDTO();

        Long distance = requestDTO.getDistance() == null ? -1:requestDTO.getDistance();
        String applicant = requestDTO.getApplicant() == null ? "":requestDTO.getApplicant();
        String truckStatus = requestDTO.getTruckStatus() == null ? "": requestDTO.getTruckStatus();
        String facilityType = requestDTO.getFacilityType() == null ? "": requestDTO.getFacilityType();

        List<SearchEntity> msg = service.getByCondition(
                distance,
                applicant,
                truckStatus,
                facilityType
        );
        res.setMessage(msg);
        res.setCode(200);
        return res;
    }

    @GetMapping("/test")
    public String testConnection(){
        return "OK";
    }
}
