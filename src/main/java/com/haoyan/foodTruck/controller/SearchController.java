package com.haoyan.foodTruck.controller;

import com.haoyan.foodTruck.entity.SearchEntity;
import com.haoyan.foodTruck.entity.dto.RequestDTO;
import com.haoyan.foodTruck.entity.dto.ResponseDTO;
import com.haoyan.foodTruck.service.SearchService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.haoyan.foodTruck.pojo.Constants.INNER_ERROR;
import static com.haoyan.foodTruck.pojo.Constants.SUCCESS;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    SearchService service;
    @PostMapping("/all")
    public ResponseDTO getAll(){
        ResponseDTO res = new ResponseDTO();
        try{
            res.setMessage(service.getAll());
            res.setCode(SUCCESS);
        } catch (Exception e){
            res.setCode(INNER_ERROR);
        }
        return res;
    }
    @PostMapping("/results")
    public ResponseDTO getResult(@RequestBody RequestDTO requestDTO){
        ResponseDTO res = new ResponseDTO();

        Long distance = requestDTO.getDistance() == null ? -1:requestDTO.getDistance();
        String applicant = requestDTO.getApplicant() == null ? "":requestDTO.getApplicant();
        String truckStatus = requestDTO.getTruckStatus() == null ? "": requestDTO.getTruckStatus();
        String facilityType = requestDTO.getFacilityType() == null ? "": requestDTO.getFacilityType();
        try{
            List<SearchEntity> msg = service.getByCondition(
                    distance,
                    applicant,
                    truckStatus,
                    facilityType
            );
            res.setMessage(msg);
            res.setCode(SUCCESS);
        } catch (Exception e){
            res.setCode(INNER_ERROR);
        }

        return res;
    }

    @GetMapping("/test")
    public String testConnection(){
        return "OK";
    }
}
