package main.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddCarRequest
{
    @JsonProperty("car_plate")
    private String carPlate;
    @JsonProperty("VIN")
    private String vin;
    @JsonProperty("model_car")
    private String model;
    @JsonProperty("type_car")
    private String type;
    @JsonProperty("vehicle_category")
    private String vehicleCategory;
    private String brand;
    private String color;
    private String chassis;
    @JsonProperty("year_car")
    private Integer year;
    @JsonProperty("hors_power")
    private Integer horsPower;
    @JsonProperty("ecological_class")
    private Integer ecologicalClass;
}