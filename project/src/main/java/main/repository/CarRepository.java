package main.repository;

import main.api.response.ResultResponse;
import main.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
  List<Car> findAll();

  @Query(value = "SELECT * FROM cars AS c WHERE c.VIN = ?", nativeQuery = true)
  Optional<Car> getCarByVin(String vin);

  @Query(
      value = "SELECT * FROM cars AS c WHERE c.year_car = ? ORDER BY year_car DESC",
      nativeQuery = true)
  List<Car> listCarByYear(Integer year);

  @Query(
      value = "SELECT * FROM cars AS c WHERE c.ecological_class = ? ORDER BY ecological_class DESC",
      nativeQuery = true)
  List<Car> listCarByEcologicalClass(Integer ecoClass);

  @Query(value = "SELECT * FROM cars WHERE c.color = ?", nativeQuery = true)
  List<Car> listCarByColor(String color);

  @Query(
      value = "SELECT * FROM cars WHERE c.horse_power > ? ORDER BY horse_power DESC",
      nativeQuery = true)
  List<Car> listCarByHorsePower(Integer hp);

  @Query(value = "SELECT * FROM cars WHERE c.type_car = ?", nativeQuery = true)
  List<Car> listCarByTypeCar(String type);

  @Query(
      value =
          "SELECT count(*) AS count_car, min(time) AS first_pub, max(time) AS last_pub, "
              + "min(horse_power) AS min_power_car, max(horse_power) AS max_power_car, "
              + "min(year_car) AS oldest_car, max(year_car) AS  youngest_car FROM cars;",
      nativeQuery = true)
  ResultResponse getStat();

  @Modifying
  @Transactional
  @Query(value = "DELETE FROM cars WHERE id = ?", nativeQuery = true)
  void deleteCar(int id);
}
