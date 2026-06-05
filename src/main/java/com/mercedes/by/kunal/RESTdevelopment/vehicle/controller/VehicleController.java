package com.mercedes.by.kunal.RESTdevelopment.vehicle.controller;


import com.mercedes.by.kunal.RESTdevelopment.vehicle.model.VehicleModel;
import com.mercedes.by.kunal.RESTdevelopment.vehicle.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins = "http://localhost:5173")             //for React API call.
@RequestMapping("/api/v1/public/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    // Get all Mercedes vehicles
    @GetMapping
    public List<VehicleModel> getAll() {
        return vehicleService.getAllVehicles();
    }

//    Need to see later
//     Add a new vehicle (e.g., S-Class, W223, 496hp)
    @PostMapping
    public ResponseEntity<VehicleModel> createVehicle(@RequestBody VehicleModel vehicle) {
        return ResponseEntity.ok(vehicleService.saveVehicle(vehicle));
    }

    // Get a specific vehicle by ID
    @GetMapping("/{id}")
    public ResponseEntity<VehicleModel> getById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get a specific vehicle by model name
    @GetMapping("/modelname/{modelName}")
    public ResponseEntity<VehicleModel> getByModelName(@PathVariable String modelName) {
        return vehicleService.getVehicleByModelName(modelName)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a vehicle details -- PUT method
    @PutMapping("/update/{id}")
    public ResponseEntity<VehicleModel> updateVehicleById(@PathVariable Long id, @RequestBody VehicleModel newvehicleDetail)
    {
       VehicleModel updatedVehicle = vehicleService.updateVehicle(id, newvehicleDetail);

       return ResponseEntity.ok(updatedVehicle);

    }




    // Delete a vehicle
    // Keep a message on response entity that the ID is deleted
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);

//        return ResponseEntity.noContent().build(); // Return NoContent in POSTman. Make ResponseEntity<Void>
//        return ResponseEntity.ok("ID is deleted..."); // Return String message. ResponseEntity<String>

        Map<String, String> response = new HashMap<>();
        response.put("Message", "Vehicle ID: "+ id + " has been deleted successfully...");
        return ResponseEntity.ok(response); // for this, Keep ResponseEntity<Map<String, String>>


    }



}
