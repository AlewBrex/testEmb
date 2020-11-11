package main.repository;

import main.api.request.AddCarRequest;
import main.model.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository  extends CrudRepository<Car, Integer>
{
    List<Car> findAll();

    @Query(value = "SELECT * FROM cars WHERE year = ? ORDER BY year DESC", nativeQuery = true)
    List<Car> withArg(Integer year);

    @Query(value = "SELECT * FROM cars WHERE car_plate = ? AND VIN = ?" +
            "AND model = ? AND type = ? AND vehicle_category = ? AND brand = ? AND color = ?" +
            "AND chassis = ? AND year = ? AND hors_power = ? AND ecological_class = ?", nativeQuery = true)
    boolean getCar(AddCarRequest addCarRequest);

    @Query(value = "DELETE FROM cars WHERE id = ?")
    void deleteCar(int id);
}