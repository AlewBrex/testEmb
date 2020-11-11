package main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car
{
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "car_plate", nullable = false, columnDefinition = "VARCHAR(255)")
    private String carPlate;

    @Column(name = "VIN", nullable = false, columnDefinition = "VARCHAR(255)")
    private String vin;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String model;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String type;

    @Column(name = "vehicle_category", nullable = false, columnDefinition = "VARCHAR(255)")
    private String vehicleCategory;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String brand;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String color;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String chassis;

    @Column(nullable = false, columnDefinition = "INTEGER)")
    private Integer year;

    @Column(name = "hors_power", nullable = false, columnDefinition = "VARCHAR(255)")
    private String horsPower;

    @Column(name = "ecological_class", nullable = false, columnDefinition = "VARCHAR(255)")
    private String ecologicalClass;

    public Car(String carPlate, String vin, String model, String type, String vehicleCategory, String brand,
               String color, String chassis, Integer year, String horsPower, String ecologicalClass) {
        this.carPlate = carPlate;
        this.vin = vin;
        this.model = model;
        this.type = type;
        this.vehicleCategory = vehicleCategory;
        this.brand = brand;
        this.color = color;
        this.chassis = chassis;
        this.year = year;
        this.horsPower = horsPower;
        this.ecologicalClass = ecologicalClass;
    }
}