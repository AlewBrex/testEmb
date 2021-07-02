package main.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import main.api.request.AddCarRequest;
import main.api.response.ResultResponse;
import main.repository.CarRepository;
import main.servise.CarServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("api/cars/")
@RequiredArgsConstructor
public class CarController {
  private final CarServiceImpl carServiceImpl;
  private final CarRepository carRepository;

  @GetMapping("")
  public ResponseEntity<ResultResponse> getListCar() {
    log.info("Get list car");
    return new ResponseEntity(carServiceImpl.getList(), HttpStatus.OK);
  }

  @GetMapping(value = "year")
  public ResponseEntity<ResultResponse> getListCarYear(
      @RequestParam(value = "year_car") Integer year) {
    log.info("Get request api/cars/year");
    return new ResponseEntity(carServiceImpl.getListCarByYear(year), HttpStatus.OK);
  }

  @GetMapping(value = "ecoClass")
  public ResponseEntity<ResultResponse> getListCarEcoClass(
      @RequestParam(value = "eco_class") Integer ecoClass) {
    log.info("Get request api/cars/ecoClass");
    return new ResponseEntity(carServiceImpl.getListCarByEcologicalClass(ecoClass), HttpStatus.OK);
  }

  @GetMapping(value = "color")
  public ResponseEntity<ResultResponse> getListCarColor(
      @RequestParam(value = "color") String color) {
    log.info("Get request api/cars/color");
    return new ResponseEntity(carServiceImpl.getListCarByColor(color), HttpStatus.OK);
  }

  @GetMapping(value = "horsePower")
  public ResponseEntity<ResultResponse> getListCarHorsePower(
      @RequestParam(value = "horse_power") Integer hp) {
    log.info("Get request api/cars/horsePower");
    return new ResponseEntity(carServiceImpl.getListCarByHorsePower(hp), HttpStatus.OK);
  }

  @GetMapping(value = "typeCar")
  public ResponseEntity<ResultResponse> getListCarTypeCar(
      @RequestParam(value = "type_car") String type) {
    log.info("Get request api/cars/typeCar");
    return new ResponseEntity(carServiceImpl.getListCarByTypeCar(type), HttpStatus.OK);
  }

  @GetMapping(value = "statistic")
  public ResponseEntity<ResultResponse> statistic() {
    log.info("Get request api/cars/statistic");
    return new ResponseEntity<>(carRepository.getStat(), HttpStatus.OK);
  }

  @PostMapping("add")
  public ResponseEntity<ResultResponse> addCar(@RequestBody AddCarRequest addCarRequest) {
    log.info("Get request api/cars/add");
    return carServiceImpl.addCar(addCarRequest);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<ResultResponse> deleteCar(@PathVariable Integer id) {
    log.info("Get request api/cars/delete");
    return carServiceImpl.deleteCarById(id);
  }
}
