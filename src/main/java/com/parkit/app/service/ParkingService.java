package com.parkit.app.service;

import com.parkit.app.model.Parking;
import com.parkit.app.repo.ParkingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingService {

    private final ParkingRepo parkingRepo;

    @Autowired
    public ParkingService(ParkingRepo parkingRepo) {
        this.parkingRepo = parkingRepo;
    }

    // Basic method
    public List<Parking> findAllParking(){
        return parkingRepo.findAll();
    }

    // Basic method
    public Parking findParkingById(int parkingId){

        Parking parking = null;
        Optional<Parking> opt=parkingRepo.findById(parkingId);
        if(opt.isPresent()) {
            parking = opt.get();
        }
        return parking;
    }

    // Basic method - Create New Parking
    public Parking createParking(Parking newParking){
        Parking tempParking = null;
        if (!parkingRepo.existsById(newParking.getId())){
            tempParking = parkingRepo.save(newParking);
        }
        return tempParking;
    }

    // Basic method - Update Parking
    public Parking updateParking(Parking parking){
        Parking tempParking = null;
        if (parkingRepo.existsById(parking.getId())){
            tempParking = parkingRepo.save(parking);
        }
        return tempParking;
    }

    // Basic method - Delete Parking
    public boolean deleteParkingById(int parkingId){
        boolean control = false;
        if (parkingRepo.existsById(parkingId)){
            parkingRepo.deleteById(parkingId);
            control = true;
        }
        return control;
    }
}
