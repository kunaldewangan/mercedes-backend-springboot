package com.mercedes.by.kunal.RESTdevelopment.vehicle.repository;


import com.mercedes.by.kunal.RESTdevelopment.vehicle.model.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<VehicleModel, Long> {
}
