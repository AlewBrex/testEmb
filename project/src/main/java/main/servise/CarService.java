package main.servise;

import main.api.request.AddCarRequest;
import main.api.response.ResultResponse;
import main.exception.AddCarException;
import main.exception.DeleteCarException;
import org.springframework.http.ResponseEntity;

public interface CarService {

  ResultResponse getList();

  ResultResponse getListCarByYear(Integer year);

  ResultResponse getListCarByColor(String color);

  ResultResponse getListCarByHorsePower(Integer hp);

  ResultResponse getListCarByTypeCar(String type);

  ResultResponse getListCarByEcologicalClass(Integer ecoClass);

  ResponseEntity<ResultResponse> addCar(AddCarRequest addCarRequest) throws AddCarException;

  ResponseEntity<ResultResponse> deleteCarById(Integer id) throws DeleteCarException;

  ResultResponse getStatistic();
}
