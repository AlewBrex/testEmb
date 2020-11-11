package main.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddCarRequest
{
    @JsonProperty("car-plate")
    private String carPlate;
    @JsonProperty("VIN")
    private String vin;
    private String model;
    private String type;
    private String vehicleCategory;
    private String brand;
    private String color;
    private String chassis;
    private Integer year;
    @JsonProperty("hors_power")
    private String horsPower;
    @JsonProperty("ecological_class")
    private String ecologicalClass;
}