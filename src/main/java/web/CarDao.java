package web;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDao {
    private static int CAR_COUNT;
    private final List<Car> cars;

    public CarDao() {
        cars = new ArrayList<>();
        addCars();
    }

    public List<Car> getCars(int count) {
        return cars.subList(0, count);
    }

    public List<Car> getCars() {
        return cars.subList(0, cars.size());
    }

    private void addCars() {
        cars.add(new Car(CAR_COUNT++, "Lexus", 3));
        cars.add(new Car(CAR_COUNT++, "Toyota", 2));
        cars.add(new Car(CAR_COUNT++, "Volvo", 8));
        cars.add(new Car(CAR_COUNT++, "Mers", 0));
        cars.add(new Car(CAR_COUNT++, "BMW", 4));
    }
}
