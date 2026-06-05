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

    public Optional<VehicleModel> getVehicleByModelName(String modelname) {
        return vehicleRepository.findByModelName(modelname);
    }


    public VehicleModel updateVehicle(Long id, VehicleModel newVehicleDetails)
    {
        return vehicleRepository.findById(id)
                .map(vehicle ->
                        {
                            vehicle.setVIdentifier(newVehicleDetails.getVIdentifier());
                            vehicle.setModelName(newVehicleDetails.getModelName());
                            vehicle.setModelYear(newVehicleDetails.getModelYear());
                            vehicle.setSeries(newVehicleDetails.getSeries());
                            vehicle.setMileage(newVehicleDetails.getMileage());
                            vehicle.setVehicleType(newVehicleDetails.getVehicleType());
                            vehicle.setEngine(newVehicleDetails.getEngine());
                            vehicle.setHorsePower(newVehicleDetails.getHorsePower());
                            vehicle.setEngineType(newVehicleDetails.getEngineType());
                            vehicle.setStatus(newVehicleDetails.getStatus());
                            vehicle.setLaunchDate(newVehicleDetails.getLaunchDate());
                            vehicle.setLifeTime(newVehicleDetails.getLifeTime());
                            return vehicleRepository.save(vehicle);
                        })
                .orElseThrow(() -> new RuntimeException("Vehicle not found with ID "+ id));

    }


    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }





}
