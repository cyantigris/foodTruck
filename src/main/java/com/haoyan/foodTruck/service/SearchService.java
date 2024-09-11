package com.haoyan.foodTruck.service;

import com.haoyan.foodTruck.entity.SearchEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SearchService {
    List<SearchEntity> getAll();
    List<SearchEntity> getByCondition(double distance, String application,String status, String facilityType);

}
