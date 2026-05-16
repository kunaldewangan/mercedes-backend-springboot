package com.mercedes.by.kunal.RESTdevelopment.vehicle.services;


import com.mercedes.by.kunal.RESTdevelopment.vehicle.model.VehicleModel;
import com.mercedes.by.kunal.RESTdevelopment.vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<VehicleModel> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public VehicleModel saveVehicle(VehicleModel vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Optional<VehicleModel> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }


    public VehicleModel updateVehicle(Long id, VehicleModel newVehicleDetails)
    {
        return vehicleRepository.findById(id)
                .map(vehicle ->
                        {
                            vehicle.setModelName(newVehicleDetails.getModelName());
                            vehicle.setSeries(newVehicleDetails.getSeries());
                            vehicle.setHorsePower(newVehicleDetails.getHorsePower());
                            return vehicleRepository.save(vehicle);
                        })
                .orElseThrow(() -> new RuntimeException("Vehicle not found with ID "+ id));

    }


    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }





}
