package com.parkit.app.service;

import com.parkit.app.model.Sensor;
import com.parkit.app.repo.SensorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorService {

    private final SensorRepo sensorRepo;

    @Autowired
    public SensorService(SensorRepo sensorRepo) {
        this.sensorRepo = sensorRepo;
    }


    // Basic method
    public List<Sensor> findAllSensor(){
        return sensorRepo.findAll();
    }

    // Basic method
    public Sensor findSensorById(int sensorId){

        Sensor sensor = null;
        Optional<Sensor> opt=sensorRepo.findById(sensorId);
        if(opt.isPresent()) {
            sensor = opt.get();
        }
        return sensor;
    }

    // Basic method - Create New Sensor
    public Sensor createSensor(Sensor newSensor){
        Sensor tempSensor = null;
        if (!sensorRepo.existsById(newSensor.getId())){
            tempSensor = sensorRepo.save(newSensor);
        }
        return tempSensor;
    }

    // Basic method - Update Sensor
    public Sensor updateSensor(Sensor sensor){
        Sensor tempSensor = null;
        if (sensorRepo.existsById(sensor.getId())){
            tempSensor = sensorRepo.save(sensor);
        }
        return tempSensor;
    }

    // Basic method - Delete Sensor
    public boolean deleteSensorById(int sensorId){
        boolean control = false;
        if (sensorRepo.existsById(sensorId)){
            sensorRepo.deleteById(sensorId);
            control = true;
        }
        return control;
    }

    public List<Sensor> findSensorsByParkingId(int parkingId){
        return sensorRepo.findSensorsByParking_Id(parkingId);
    }
}
