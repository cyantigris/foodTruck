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

    @PostMapping("/getResult")
    public ResponseDTO getResult(@RequestBody RequestDTO requestDTO){
        ResponseDTO res = new ResponseDTO();

        if(requestDTO.getDistance() == -1){
            res.setMessage(service.getAll());
        } else {
            List<SearchEntity> msg = service.getByCondition(
                        requestDTO.getDistance(),
                        requestDTO.getApplication(),
                        requestDTO.getTruckStatus(),
                        requestDTO.getFacilityType()
            );
            res.setMessage(msg);
        }
        res.setCode(200);
        return res;
    }

    @GetMapping("/test")
    public String testConnection(){
        return "OK";
    }
}
