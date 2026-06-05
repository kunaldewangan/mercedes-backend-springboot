package com.mercedes.by.kunal.RESTdevelopment.vehicle.repository;


import com.mercedes.by.kunal.RESTdevelopment.vehicle.model.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<VehicleModel, Long> {

//Creating this explicitely in order to fetch vehicle by ModelName
//    Make sure to keep the exact variable name in the parameter like (modelname) which is defined in VehicleModel;
    Optional<VehicleModel> findByModelName(String modelname);
}
