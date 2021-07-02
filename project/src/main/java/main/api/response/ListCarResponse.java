package main.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.model.Car;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCarResponse implements ResultResponse {
  private List<Car> listCar;
}
