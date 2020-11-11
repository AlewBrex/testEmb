package main.servise;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.extern.log4j.Log4j2;
import main.api.request.AddCarRequest;
import main.model.Car;
import main.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class CarService
{
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository)
    {
        this.carRepository = carRepository;
    }

    public List<Car> getListCar()
    {
        List<Car> list = carRepository.findAll();
        log.info("Message");
        return list;
    }

    public List<Car> getListCarWithArg(Integer year)
    {
        if(year == null)
        {
            log.info("Message");
        }
        List<Car> carList = carRepository.withArg(year);
        log.info("Message");
        return carList;
    }

    public void addCar(AddCarRequest addCarRequest)
    {
        String carPlate = addCarRequest.getCarPlate();
        String vin = addCarRequest.getVin();
        String model = addCarRequest.getModel();
        String type = addCarRequest.getType();
        String vehicleCategory = addCarRequest.getVehicleCategory();
        String brand = addCarRequest.getBrand();
        String color = addCarRequest.getColor();
        String chassis = addCarRequest.getChassis();
        Integer year = addCarRequest.getYear();
        String horsPower = addCarRequest.getHorsPower();
        String ecologicalClass = addCarRequest.getEcologicalClass();

        if (carPlate.isEmpty() || vin.isEmpty() || model.isEmpty() ||
                type.isEmpty() || vehicleCategory.isEmpty() || brand.isEmpty() ||
                color.isEmpty() || chassis.isEmpty() || year.toString().isEmpty() ||
                horsPower.isEmpty() || ecologicalClass.isEmpty())
        {
            log.info("Message");
        }
        if (carRepository.getCar(addCarRequest))
        {
            log.info("Message");
        }
        Car car = new Car(carPlate, vin, model,
                type, vehicleCategory, brand, color,
                chassis, year, horsPower, ecologicalClass);
        carRepository.save(car);
        log.info("Message");
    }
    public void deleteCar(int id)
    {
        carRepository.deleteCar(id);
        log.info("Message");
    }
}