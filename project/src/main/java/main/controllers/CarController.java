package main.controllers;

import lombok.extern.log4j.Log4j2;
import main.api.request.AddCarRequest;
import main.model.Car;
import main.repository.CarRepository;
import main.servise.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Log4j2
@RestController
@RequestMapping("api/cars/")
public class CarController
{
    private final CarService carService;
    private final CarRepository carRepository;

    public CarController(CarService carService, CarRepository carRepository)
    {
        this.carService = carService;
        this.carRepository = carRepository;
    }

    @GetMapping("all")
    public ResponseEntity getListCar()
    {
        log.info("Message");
        return new ResponseEntity(carService.getListCar(), HttpStatus.OK);
    }

    @GetMapping(value = "all", params = {"year"})
    public ResponseEntity getListCarWithArg(@RequestParam(value = "year") Integer year)
    {
        log.info("Message");
        return new ResponseEntity(carService.getListCarWithArg(year), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity addCar(@RequestBody AddCarRequest addCarRequest)
    {
        Integer year = addCarRequest.getYear();
        boolean repoYear = carRepository.getCar(addCarRequest);
        if (repoYear)
        {
            return ResponseEntity.status(HttpStatus.IM_USED).body(null);
        }
        if (year == null)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        carService.addCar(addCarRequest);
        return ResponseEntity.status(HttpStatus.OK).body(addCarRequest);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteCar(@PathVariable int id)
    {
        Optional<Car> deleteCar = carRepository.findById(id);
        if (!deleteCar.isPresent())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        carRepository.deleteCar(id);
        return ResponseEntity.status(HttpStatus.OK).body(deleteCar.get());
    }
}