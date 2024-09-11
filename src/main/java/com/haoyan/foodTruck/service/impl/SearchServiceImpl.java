package com.haoyan.foodTruck.service.impl;

import com.haoyan.foodTruck.entity.SearchEntity;
import com.haoyan.foodTruck.entity.TruckDO;
import com.haoyan.foodTruck.pojo.Constants;
import com.haoyan.foodTruck.pojo.DbFunction;
import com.haoyan.foodTruck.service.SearchService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import static com.haoyan.foodTruck.pojo.Constants.EARTH_RADIUS;
@Component
public class SearchServiceImpl implements SearchService {
    private final ReentrantLock readLock = new ReentrantLock();

    @Override
    public List<SearchEntity> getAll() {
        List<SearchEntity> res  = new ArrayList<>();
        readLock.lock();
        try{
            List<TruckDO> truckList= DbFunction.readallItems();
            for(TruckDO tDO:truckList){
                SearchEntity se = new SearchEntity(
                        tDO.getApplicant(),
                        tDO.getAddress(),
                        tDO.getStatus(),
                        tDO.getFoodItems(),
                        tDO.getFacilityType(),
                        tDO.getDayhours(),
                        tDO.getLatitude(),
                        tDO.getLongitude()
                );
                res.add(se);
            }
        } finally {
            readLock.unlock();
        }

        return res;
    }

    @Override
    public List<SearchEntity> getByCondition(double distance, String application, String status, String facilityType) {
        List<SearchEntity> res  = new ArrayList<>();
        List<TruckDO> truckList = DbFunction.readallItems();
        readLock.lock();
        try {
            for (TruckDO tDO : truckList) {
                if (distance > 0) {
                    if (getDistance(tDO.getLatitude(), tDO.getLongitude()) <= distance) {
                        tDO.setFlag(true);
                    } else {
                        tDO.setFlag(false);
                    }
                }

                if (!status.isEmpty()) {
                    if (tDO.getStatus().equals(status)) {
                        tDO.setFlag(true);
                    } else {
                        tDO.setFlag(false);
                    }
                }

                if (!facilityType.isEmpty()) {
                    if (tDO.getFacilityType().equals(facilityType)) {
                        tDO.setFlag(true);
                    } else {
                        tDO.setFlag(false);
                    }
                }
                if (!application.isEmpty()) {
                    if (tDO.getApplicant().equals(application)) {
                        tDO.setFlag(true);
                    } else {
                        tDO.setFlag(false);
                    }
                }


            }

            for (TruckDO tDO : truckList) {
                if (tDO.isFlag()) {
                    res.add(new SearchEntity(
                            tDO.getApplicant(),
                            tDO.getAddress(),
                            tDO.getStatus(),
                            tDO.getFoodItems(),
                            tDO.getFacilityType(),
                            tDO.getDayhours(),
                            tDO.getLatitude(),
                            tDO.getLongitude())
                    );
                }
            }
        } finally {
            readLock.unlock();
        }
        return res;
    }

    private double getDistance(double aLan, double aLong){
        double radLat1 = Math.toRadians(Constants.OUR_LANTITUDE);
        double radLat2 = Math.toRadians(aLan);
        double radDeltaLat = Math.toRadians(Constants.OUR_LANTITUDE - aLan);
        double radDeltaLon = Math.toRadians(Constants.OUT_LONGITUDE - aLong);

        // 应用Haversine公式
        double a = Math.sin(radDeltaLat / 2) * Math.sin(radDeltaLat / 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.sin(radDeltaLon / 2) * Math.sin(radDeltaLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = EARTH_RADIUS * c;

        return distance;
    }

}
