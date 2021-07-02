package main.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "cars")
@Data
@RequiredArgsConstructor
public class Car {
  @Id
  @NotNull
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false, columnDefinition = "DATETIME")
  private LocalDateTime time;

  @Column(name = "car_plate", nullable = false, columnDefinition = "VARCHAR(255)")
  private String carPlate;

  @Column(name = "VIN", nullable = false, columnDefinition = "VARCHAR(255)")
  private String vin;

  @Column(name = "model_car", nullable = false, columnDefinition = "VARCHAR(255)")
  private String model;

  @Column(name = "type_car", nullable = false, columnDefinition = "VARCHAR(255)")
  private String type;

  @Column(name = "vehicle_category", nullable = false, columnDefinition = "VARCHAR(255)")
  private String vehicleCategory;

  @Column(nullable = false, columnDefinition = "VARCHAR(255)")
  private String brand;

  @Column(nullable = false, columnDefinition = "VARCHAR(255)")
  private String color;

  @Column(nullable = false, columnDefinition = "VARCHAR(255)")
  private String chassis;

  @Column(name = "year_car", nullable = false, columnDefinition = "INT)")
  private Integer year;

  @Column(name = "hors_power", nullable = false, columnDefinition = "INT")
  private Integer horsPower;

  @Column(name = "ecological_class", nullable = false, columnDefinition = "INT")
  private Integer ecologicalClass;

  public Car(
      String carPlate,
      LocalDateTime time,
      String vin,
      String model,
      String type,
      String vehicleCategory,
      String brand,
      String color,
      String chassis,
      Integer year,
      Integer horsPower,
      Integer ecologicalClass) {
    this.carPlate = carPlate;
    this.time = time;
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

  @Override
  public String toString() {
    return "Car{" +
            "id=" + id +
            ", time=" + time +
            ", carPlate='" + carPlate + '\'' +
            ", vin='" + vin + '\'' +
            ", model='" + model + '\'' +
            ", type='" + type + '\'' +
            ", vehicleCategory='" + vehicleCategory + '\'' +
            ", brand='" + brand + '\'' +
            ", color='" + color + '\'' +
            ", chassis='" + chassis + '\'' +
            ", year=" + year +
            ", horsPower=" + horsPower +
            ", ecologicalClass=" + ecologicalClass +
            '}';
  }
}
