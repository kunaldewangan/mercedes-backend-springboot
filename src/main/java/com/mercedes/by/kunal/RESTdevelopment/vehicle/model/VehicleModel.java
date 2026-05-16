package com.mercedes.by.kunal.RESTdevelopment.vehicle.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicles")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class VehicleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String modelName; // e.g., "S-Class"

    private String series;    // e.g., "W223"

    private Integer horsePower;


//   -- without Lambok --
//
//
//    public VehicleModel() {
//    }
//
//    public VehicleModel(Long id, Integer horsePower, String series, String modelName) {
//        this.id = id;
//        this.horsePower = horsePower;
//        this.series = series;
//        this.modelName = modelName;
//    }
//
//
//   -- Getter --
//
//    public Long getId() {
//        return id;
//    }
//
//    public Integer getHorsePower() {
//        return horsePower;
//    }
//
//    public String getSeries() {
//        return series;
//    }
//
//    public String getModelName() {
//        return modelName;
//    }
//
//
//   -- Setter --
//
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setHorsePower(Integer horsePower) {
//        this.horsePower = horsePower;
//    }
//
//    public void setSeries(String series) {
//        this.series = series;
//    }
//
//    public void setModelName(String modelName) {
//        this.modelName = modelName;
//    }
//
//



}
