package com.haoyan.foodTruck.pojo;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.haoyan.foodTruck.entity.TruckDO;

import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

import static com.haoyan.foodTruck.pojo.Constants.CSV_LOC;

public class DbFunction {
    public static List<TruckDO> readallItems(){
        List<TruckDO> res = new ArrayList<>();
        int lineNum = 0;
        try (CSVReader csvReader = new CSVReader(new FileReader(CSV_LOC))) {
            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                if(lineNum > 0){
                    TruckDO tdo = buildTruck(nextLine);
                    res.add(tdo);
                }
                lineNum++;
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        return res;
    }

    private static TruckDO buildTruck(String[] nextLine){
        TruckDO tDO = new TruckDO();
        tDO.setApplicantID(Long.parseLong(nextLine[0]));
        tDO.setApplicant(nextLine[1]);
        tDO.setFacilityType(nextLine[2]);
        tDO.setLocationDescription(nextLine[4]);
        tDO.setAddress(nextLine[5]);
        tDO.setStatus(nextLine[10]);
        tDO.setFoodItems(nextLine[11]);
        tDO.setLatitude(Double.parseDouble(nextLine[14]));
        tDO.setLongitude(Double.parseDouble(nextLine[15]));
        tDO.setDayhours(nextLine[16]);

        String firePreventionString = nextLine[24];
        int firePreventionNum = firePreventionString.isEmpty() ? 0:Integer.parseInt(firePreventionString);
        tDO.setFirePreventionDistricts(firePreventionNum);

        String setPoliceString  = nextLine[25];
        int policeDistrictsNum = setPoliceString.isEmpty() ? 0 : Integer.parseInt(setPoliceString);
        tDO.setPoliceDistricts(policeDistrictsNum);

        String zipCodeString  = nextLine[26];
        int zipCode = zipCodeString.isEmpty() ? 0 : Integer.parseInt(zipCodeString);
        tDO.setZipCode(zipCode);

        String neighborhoodString = nextLine[27];
        int neighborhoodNum = neighborhoodString.isEmpty() ? 0: Integer.parseInt(neighborhoodString);
        tDO.setNeighborhoods(neighborhoodNum);

        return tDO;
    }
}
