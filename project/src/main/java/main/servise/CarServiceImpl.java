package main.servise;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import main.api.request.AddCarRequest;
import main.api.response.BadResultResponse;
import main.api.response.ListCarResponse;
import main.api.response.OkResultResponse;
import main.api.response.ResultResponse;
import main.exception.AddCarException;
import main.exception.DeleteCarException;
import main.model.Car;
import main.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

  private final CarRepository carRepository;

  public ResultResponse getList() {
    List<Car> list = carRepository.findAll();
    log.info("Get list car");
    return new ListCarResponse(list);
  }

  public ResultResponse getListCarByYear(Integer year) {
    if (year == null) {
      getList();
      log.info("Year no set! Output of all list");
    }
    List<Car> carList = carRepository.listCarByYear(year);
    log.info("Get list car by year");
    return new ListCarResponse(carList);
  }

  public ResultResponse getListCarByEcologicalClass(Integer ecoClass) {
    if (ecoClass == null) {
      getList();
      log.info("EcoClass no set! Output of all list");
    }
    List<Car> carList = carRepository.listCarByEcologicalClass(ecoClass);
    log.info("Get list car by ecological_class");
    return new ListCarResponse(carList);
  }

  public ResultResponse getListCarByColor(String color) {
    if (color.isBlank()) {
      getList();
      log.info("Color no set! Output of all list");
    }
    List<Car> carList = carRepository.listCarByColor(color);
    log.info("Get list car by color");
    return new ListCarResponse(carList);
  }

  public ResultResponse getListCarByHorsePower(Integer hp) {
    if (hp == 0) {
      getList();
      log.info("Horse power no set! Output of all list");
    }
    List<Car> carList = carRepository.listCarByHorsePower(hp);
    log.info("Get list car by horse_power");
    return new ListCarResponse(carList);
  }

  public ResultResponse getListCarByTypeCar(String type) {
    if (type.isBlank()) {
      getList();
      log.info("Type no set! Output of all list");
    }
    List<Car> carList = carRepository.listCarByTypeCar(type);
    log.info("Get list car by type_car");
    return new ListCarResponse(carList);
  }

  public ResponseEntity<ResultResponse> addCar(AddCarRequest ar) throws AddCarException {
    if (checkAddCar(ar)) {
      throw new AddCarException();
    }
    if (carRepository.getCarByVin(ar.getVin()).isPresent()) {
      Optional<Car> car = carRepository.getCarByVin(ar.getVin());
      log.info("Сar - " + car.toString() + " exists! Change data.");
      return new ResponseEntity<>(new BadResultResponse(), HttpStatus.BAD_REQUEST);
    }
    Car car =
        new Car(
            ar.getCarPlate(),
            LocalDateTime.now(),
            ar.getVin(),
            ar.getModel(),
            ar.getType(),
            ar.getVehicleCategory(),
            ar.getBrand(),
            ar.getColor(),
            ar.getChassis(),
            ar.getYear(),
            ar.getHorsPower(),
            ar.getEcologicalClass());
    carRepository.save(car);
    log.info("Added new Car - " + car);
    return new ResponseEntity<>(new OkResultResponse(), HttpStatus.OK);
  }

  public ResponseEntity<ResultResponse> deleteCarById(Integer id) throws DeleteCarException {
    if (id == null) {
      throw new DeleteCarException();
    }
    Optional<Car> deleteCar = carRepository.findById(id);
    if (deleteCar.isEmpty()) {
      log.info("Car not found");
      return new ResponseEntity<>(new BadResultResponse(), HttpStatus.NOT_FOUND);
    }
    carRepository.deleteCar(id);
    log.info("Delete {} element", id);
    return new ResponseEntity<>(new OkResultResponse(), HttpStatus.OK);
  }

  @Scheduled(fixedRate = 15 * 60 * 1000)
  public ResultResponse getStatistic() {
    log.info("Get statistics car");
    return carRepository.getStat();
  }

  private boolean checkAddCar(AddCarRequest acr) {
    return !(acr.getCarPlate().isBlank()
        || acr.getVin().isBlank()
        || acr.getModel().isBlank()
        || acr.getType().isBlank()
        || acr.getVehicleCategory().isBlank()
        || acr.getBrand().isBlank()
        || acr.getColor().isBlank()
        || acr.getChassis().isBlank()
        || acr.getYear() == null
        || acr.getHorsPower() == null
        || acr.getEcologicalClass() == null);
  }
}
